package okkpp.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import okkpp.constants.EhCacheConstants;

@Component
public class EhcacheUtil {

	@Autowired
	private CacheManager cacheManager;
	private static String defaultCache = EhCacheConstants.DEFAULT_NAME;

	public boolean isConfiged() {
		if (null == cacheManager) {
			return false;
		} else {
			return true;
		}
	}

	public void put(String key, Object value) {
		put(null, key, value);
	}

	public void put(String cacheName, String key, Object value) {
		cacheName = null == cacheName ? defaultCache : cacheName;
		Cache cache = cacheManager.getCache(cacheName);
		Element element = new Element(key, value);
		cache.put(element);
	}

	public Object get(String key) {
		return get(null, key);
	}

	public Object get(String cacheName, String key) {
		cacheName = null == cacheName ? defaultCache : cacheName;
		Cache cache = cacheManager.getCache(cacheName);
		Element element = cache.get(key);
		return element == null ? null : element.getObjectValue();
	}

	public void remove(String key) {
		remove(null, key);
	}

	public void remove(String cacheName, String key) {
		cacheName = null == cacheName ? defaultCache : cacheName;
		Cache cache = cacheManager.getCache(cacheName);
		cache.remove(key);
	}

	public Cache getCache() {
		return getCache(null);
	}

	public Cache getCache(String cacheName) {
		cacheName = null == cacheName ? defaultCache : cacheName;
		return cacheManager.getCache(cacheName);
	}

}
