package okkpp.common.config;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jfinal.config.Constants;
import com.jfinal.config.Plugins;
import com.jfinal.log.Log;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

import okkpp.config.MyDbManager;

@Configuration
public class JbootDbConfig {

	static final Logger logger = LoggerFactory.getLogger(JbootDbConfig.class);

	private static Log log;

	private static final Plugins plugins = new Plugins();

//	public static void main(String[] args) {
//		List<ActiveRecordPlugin> arps = new MyDbManager().getActiveRecordPlugins();
//		for (ActiveRecordPlugin arp : arps) {
//			plugins.add(arp);
//		}
//		
//		startPlugins();
//	}

	@Bean
	public boolean jbootDbPlugin() {
		
//		MyClassScanner.scanSubClass(Model.class);
		
		List<ActiveRecordPlugin> arps = new MyDbManager().getActiveRecordPlugins();
		for (ActiveRecordPlugin arp : arps) {
			plugins.add(arp);
		}

		logger.info("start JfinalPlugins");
		startPlugins();
		return true;
	}

	private static void startPlugins() {
		List<IPlugin> pluginList = plugins.getPluginList();
		if (pluginList == null) {
			return;
		}

		for (IPlugin plugin : pluginList) {
			try {
				// process ActiveRecordPlugin devMode
				if (plugin instanceof com.jfinal.plugin.activerecord.ActiveRecordPlugin) {
					com.jfinal.plugin.activerecord.ActiveRecordPlugin arp = (com.jfinal.plugin.activerecord.ActiveRecordPlugin) plugin;
					if (arp.getDevMode() == null) {
						arp.setDevMode(new Constants().getDevMode());
					}
				}

				if (!plugin.start()) {
					String message = "Plugin start error: " + plugin.getClass().getName();
					log.error(message);
					throw new RuntimeException(message);
				}
			} catch (Exception e) {
				String message = "Plugin start error: " + plugin.getClass().getName() + ". \n" + e.getMessage();
				throw new RuntimeException(message, e);
			}
		}
	}

}
