package okkpp.config;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.jfinal.plugin.activerecord.Model;

import io.jboot.db.TableInfo;
import io.jboot.db.annotation.Table;
import io.jboot.db.datasource.DataSourceConfig;
import io.jboot.db.model.JbootModelConfig;
import io.jboot.utils.ArrayUtils;
import io.jboot.utils.StrUtils;

public class MyTableInfoManager {

	private List<TableInfo> allTableInfos;

    public List<TableInfo> getTablesInfos(DataSourceConfig dataSourceConfig) {
        List<TableInfo> tableInfos = new ArrayList<>();

        Set<String> configTables = null;
        if (StrUtils.isNotBlank(dataSourceConfig.getTable())) {
            configTables = StrUtils.splitToSet(dataSourceConfig.getTable(), ",");
        }

        for (TableInfo tableInfo : getAllTableInfos()) {
            if (tableInfo.getDatasources().contains(dataSourceConfig.getName())) {

                //如果 datasource.table 已经配置了，就只用这个配置的，不是这个配置的都排除
                if (configTables != null && !configTables.contains(tableInfo.getTableName())) {
                    continue;
                }

                tableInfos.add(tableInfo);
            }
        }

        if (StrUtils.isNotBlank(dataSourceConfig.getExTable())) {
            Set<String> configExTables = StrUtils.splitToSet(dataSourceConfig.getExTable(), ",");
            for (Iterator<TableInfo> iterator = tableInfos.iterator(); iterator.hasNext(); ) {
                TableInfo tableInfo = iterator.next();

                //如果配置当前数据源的排除表，则需要排除当前数据源的表信息
                if (configExTables.contains(tableInfo.getTableName())) {
                    iterator.remove();
                }
            }
        }

        return tableInfos;
    }

    private List<TableInfo> getAllTableInfos() {
        if (allTableInfos == null) {
            allTableInfos = new ArrayList<>();
            initTableInfos(allTableInfos);
        }
        return allTableInfos;
    }

    @SuppressWarnings("rawtypes")
	private void initTableInfos(List<TableInfo> tableInfos) {
		List<Class<Model>> modelClassList = MyClassScanner.scanSubClass(Model.class);
        if (ArrayUtils.isNullOrEmpty(modelClassList)) {
            return;
        }

        String scanPackage = JbootModelConfig.getConfig().getScan();

        for (Class<Model> clazz : modelClassList) {
            Table tb = clazz.getAnnotation(Table.class);
            if (tb == null)
                continue;

            if (scanPackage != null && !clazz.getName().startsWith(scanPackage)) {
                continue;
            }

            Set<String> datasources = new HashSet<>();
            if (StrUtils.isNotBlank(tb.datasource())) {
                datasources.addAll(StrUtils.splitToSet(tb.datasource(), ","));
            } else {
                datasources.add(DataSourceConfig.NAME_DEFAULT);
            }

            TableInfo tableInfo = new TableInfo();
            tableInfo.setModelClass(clazz);
            tableInfo.setPrimaryKey(tb.primaryKey());
            tableInfo.setTableName(tb.tableName());
            tableInfo.setDatasources(datasources);

            tableInfo.setActualDataNodes(tb.actualDataNodes());
            tableInfo.setDatabaseShardingStrategyConfig(tb.databaseShardingStrategyConfig());
            tableInfo.setTableShardingStrategyConfig(tb.tableShardingStrategyConfig());

            if (tb.keyGeneratorClass() != null && Void.class != tb.keyGeneratorClass()) {
                tableInfo.setKeyGeneratorClass(tb.keyGeneratorClass().getName());
            }
            tableInfo.setKeyGeneratorColumnName(tb.keyGeneratorColumnName());

            tableInfos.add(tableInfo);
        }

    }
}
