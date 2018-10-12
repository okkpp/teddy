package okkpp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.dialect.Dialect;

import io.jboot.Jboot;
import io.jboot.core.cache.JbootCache;
import io.jboot.db.TableInfo;
import io.jboot.db.datasource.DataSourceBuilder;
import io.jboot.db.datasource.DataSourceConfig;
import io.jboot.db.datasource.DataSourceConfigManager;
import io.jboot.db.dbpro.JbootDbProFactory;
import io.jboot.db.dialect.JbootAnsiSqlDialect;
import io.jboot.db.dialect.JbootMysqlDialect;
import io.jboot.db.dialect.JbootOracleDialect;
import io.jboot.db.dialect.JbootPostgreSqlDialect;
import io.jboot.db.dialect.JbootSqlServerDialect;
import io.jboot.db.dialect.JbootSqlite3Dialect;
import io.jboot.exception.JbootIllegalConfigException;
import io.jboot.utils.ArrayUtils;
import io.jboot.utils.ClassKits;
import io.jboot.utils.StrUtils;

public class MyDbManager {

	private List<ActiveRecordPlugin> activeRecordPlugins = new ArrayList<>();

	public MyDbManager() {
		// 所有的数据源，包含了分库数据源的子数据源
		Map<String, DataSourceConfig> allDatasourceConfigs = DataSourceConfigManager.me().getDatasourceConfigs();

		for (Map.Entry<String, DataSourceConfig> entry : allDatasourceConfigs.entrySet()) {
			DataSourceConfig datasourceConfig = entry.getValue();

			if (datasourceConfig.isConfigOk()) {
				ActiveRecordPlugin activeRecordPlugin = createRecordPlugin(datasourceConfig);
				activeRecordPlugin.setShowSql(Jboot.me().isDevMode());
				activeRecordPlugin.setDbProFactory(new JbootDbProFactory());

				JbootCache jbootCache = Jboot.me().getCache();
				if (jbootCache != null) {
					activeRecordPlugin.setCache(jbootCache);
				}

				configSqlTemplate(datasourceConfig, activeRecordPlugin);
				configDialect(activeRecordPlugin, datasourceConfig);

				activeRecordPlugins.add(activeRecordPlugin);
			}
		}
	}

	/**
	 * 配置 本地 sql
	 *
	 * @param datasourceConfig
	 * @param activeRecordPlugin
	 */
	private void configSqlTemplate(DataSourceConfig datasourceConfig, ActiveRecordPlugin activeRecordPlugin) {
		String sqlTemplatePath = datasourceConfig.getSqlTemplatePath();
		if (StrUtils.isNotBlank(sqlTemplatePath)) {
			if (sqlTemplatePath.startsWith("/")) {
				activeRecordPlugin.setBaseSqlTemplatePath(datasourceConfig.getSqlTemplatePath());
			} else {
				activeRecordPlugin.setBaseSqlTemplatePath(
						PathKit.getRootClassPath() + "/" + datasourceConfig.getSqlTemplatePath());
			}
		} else {
			activeRecordPlugin.setBaseSqlTemplatePath(PathKit.getRootClassPath());
		}

		String sqlTemplateString = datasourceConfig.getSqlTemplate();
		if (sqlTemplateString != null) {
			String[] sqlTemplateFiles = sqlTemplateString.split(",");
			for (String sql : sqlTemplateFiles) {
				activeRecordPlugin.addSqlTemplate(sql);
			}
		}
	}

	/**
	 * 配置 数据源的 方言
	 *
	 * @param activeRecordPlugin
	 * @param datasourceConfig
	 */
	private void configDialect(ActiveRecordPlugin activeRecordPlugin, DataSourceConfig datasourceConfig) {

		if (datasourceConfig.getDialectClass() != null) {
			Dialect dialect = ClassKits.newInstance(datasourceConfig.getDialectClass(), false);
			if (dialect == null) {
				throw new NullPointerException("can not new instance by class:" + datasourceConfig.getDialectClass());
			}
			activeRecordPlugin.setDialect(dialect);
			return;
		}

		switch (datasourceConfig.getType()) {
		case DataSourceConfig.TYPE_MYSQL:
			activeRecordPlugin.setDialect(new JbootMysqlDialect());
			break;
		case DataSourceConfig.TYPE_ORACLE:
			if (StrUtils.isBlank(datasourceConfig.getContainerFactory())) {
				activeRecordPlugin.setContainerFactory(new CaseInsensitiveContainerFactory());
			}
			activeRecordPlugin.setDialect(new JbootOracleDialect());
			break;
		case DataSourceConfig.TYPE_SQLSERVER:
			activeRecordPlugin.setDialect(new JbootSqlServerDialect());
			break;
		case DataSourceConfig.TYPE_SQLITE:
			activeRecordPlugin.setDialect(new JbootSqlite3Dialect());
			break;
		case DataSourceConfig.TYPE_ANSISQL:
			activeRecordPlugin.setDialect(new JbootAnsiSqlDialect());
			break;
		case DataSourceConfig.TYPE_POSTGRESQL:
			activeRecordPlugin.setDialect(new JbootPostgreSqlDialect());
			break;
		default:
			throw new JbootIllegalConfigException(
					"only support datasource type : mysql、orcale、sqlserver、sqlite、ansisql and postgresql, please check your jboot.properties. ");
		}
	}

	/**
	 * 创建 ActiveRecordPlugin 插件，用于数据库读写
	 *
	 * @param config
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private ActiveRecordPlugin createRecordPlugin(DataSourceConfig config) {

		String configName = config.getName();
		DataSource dataSource = new DataSourceBuilder(config).build();

		ActiveRecordPlugin activeRecordPlugin = StrUtils.isNotBlank(configName)
				? new ActiveRecordPlugin(configName, dataSource)
				: new ActiveRecordPlugin(dataSource);

		if (StrUtils.isNotBlank(config.getDbProFactory())) {
			activeRecordPlugin.setDbProFactory(ClassKits.newInstance(config.getDbProFactory()));
		}

		if (StrUtils.isNotBlank(config.getContainerFactory())) {
			activeRecordPlugin.setContainerFactory(ClassKits.newInstance(config.getContainerFactory()));
		}

		if (config.getTransactionLevel() != null) {
			activeRecordPlugin.setTransactionLevel(config.getTransactionLevel());
		}

		/**
		 * 不需要添加映射的直接返回
		 */
		if (!config.isNeedAddMapping()) {
			return activeRecordPlugin;
		}

		List<TableInfo> tableInfos = new MyTableInfoManager().getTablesInfos(config);
		if (ArrayUtils.isNullOrEmpty(tableInfos)) {
			return activeRecordPlugin;
		}

		for (TableInfo ti : tableInfos) {
			if (StrUtils.isNotBlank(ti.getPrimaryKey())) {
				activeRecordPlugin.addMapping(ti.getTableName(), ti.getPrimaryKey(),
						(Class<? extends Model<?>>) ti.getModelClass());
			} else {
				activeRecordPlugin.addMapping(ti.getTableName(), (Class<? extends Model<?>>) ti.getModelClass());
			}
		}

		return activeRecordPlugin;
	}

	public List<ActiveRecordPlugin> getActiveRecordPlugins() {
		return activeRecordPlugins;
	}
}
