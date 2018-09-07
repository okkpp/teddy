package okkpp;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jfinal.config.Constants;
import com.jfinal.config.Plugins;
import com.jfinal.log.Log;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;

import io.jboot.db.JbootDbManager;

@SpringBootApplication
public class DemoApiApplication {

	private static Log log;
	
	private static final Plugins plugins = new Plugins();
	
	public static void main(String[] args) {
		
		SpringApplication.run(DemoApiApplication.class, args);
	}
	
	@Bean
	public boolean JbootDbPlugin() {
		List<ActiveRecordPlugin> arps = JbootDbManager.me().getActiveRecordPlugins();
        for (ActiveRecordPlugin arp : arps) {
            plugins.add(arp);
        }

//        JbootAppListenerManager.me().onJfinalPluginConfig(new JfinalPlugins(plugins));
        System.out.println("start JfinalPlugins");
        startPlugins();
		return true;
	}
	private static void startPlugins() {
		List<IPlugin> pluginList = plugins.getPluginList();
		if (pluginList == null) {
			return ;
		}
		
		for (IPlugin plugin : pluginList) {
			try {
				// process ActiveRecordPlugin devMode
				if (plugin instanceof com.jfinal.plugin.activerecord.ActiveRecordPlugin) {
					com.jfinal.plugin.activerecord.ActiveRecordPlugin arp = (com.jfinal.plugin.activerecord.ActiveRecordPlugin)plugin;
					if (arp.getDevMode() == null) {
						arp.setDevMode(new Constants().getDevMode());
					}
				}
				
				if (plugin.start() == false) {
					String message = "Plugin start error: " + plugin.getClass().getName();
					log.error(message);
					throw new RuntimeException(message);
				}
			}
			catch (Exception e) {
				String message = "Plugin start error: " + plugin.getClass().getName() + ". \n" + e.getMessage();
				log.error(message, e);
				throw new RuntimeException(message, e);
			}
		}
	}
}
