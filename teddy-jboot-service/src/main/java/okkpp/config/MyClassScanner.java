package okkpp.config;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import com.jfinal.core.Const;
import com.jfinal.kit.PathKit;

import io.jboot.utils.ClassScanner;

public class MyClassScanner {

//	@SuppressWarnings("rawtypes")
//	public static void main(String[] args) {
//		try {
//			String canonicalPath = new File("D:/eclipse/workspace/teddy/teddy-service/target/classes/").getCanonicalPath();
//			System.out.println(canonicalPath);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
////		List<Class<Model>> list = scanSubClass(Model.class);
////		for(Class<Model> c : list) {
////			System.out.println(c.getName());
////		}
//	}
	
	@SuppressWarnings("rawtypes")
	private static final Set<Class> appClasses = new HashSet<>();

	public static <T> List<Class<T>> scanSubClass(Class<T> pclazz) {
		return scanSubClass(pclazz, false);
	}

	public static <T> List<Class<T>> scanSubClass(Class<T> pclazz, boolean mustCanNewInstance) {
		if (pclazz == null) {
			throw new RuntimeException("pclazz cannot be null");
		}

		if (appClasses.isEmpty()) {
			try {
				searchClass();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			initAppClasses();
		}

		List<Class<T>> classes = new ArrayList<>();
		findClassesByParent(classes, pclazz, mustCanNewInstance);
		return classes;
	}
    private static void searchClass() throws IOException, ClassNotFoundException {
        String basePack = "okkpp";
        //通过当前线程得到类加载器从而得到URL的枚举
        Enumeration<URL> urlEnumeration = Thread.currentThread().getContextClassLoader().getResources(basePack.replace(".", "/"));
        while (urlEnumeration.hasMoreElements()) {
            URL url = urlEnumeration.nextElement();//得到的结果大概是：jar:file:/C:/Users/ibm/.m2/repository/junit/junit/4.12/junit-4.12.jar!/org/junit
            
            String protocol = url.getProtocol();//大概是jar
            System.out.println("url="+url+" protocol="+protocol);
            if ("jar".equalsIgnoreCase(protocol)) {
                //转换为JarURLConnection
                JarURLConnection connection = (JarURLConnection) url.openConnection();
                if (connection != null) {
                    JarFile jarFile = connection.getJarFile();
                    if (jarFile != null) {
                        //得到该jar文件下面的类实体
                        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                        while (jarEntryEnumeration.hasMoreElements()) {
                            /*entry的结果大概是这样：
                                    org/
                                    org/junit/
                                    org/junit/rules/
                                    org/junit/runners/*/
                            JarEntry entry = jarEntryEnumeration.nextElement();
                            String jarEntryName = entry.getName();
                            //这里我们需要过滤不是class文件和不在basePack包名下的类
                            if (jarEntryName.contains(".class") && jarEntryName.replaceAll("/",".").startsWith(basePack)) {
                                String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replace("/", ".");
                                initAppClasses(classForName(className));
                            }
                        }
                    }
                }
            }else if("file".equalsIgnoreCase(protocol)) {
            	initByFilePath(new File(url.getFile()).getCanonicalPath());
            }
        }
    }
	/**
	 * 开发环境下，用于热加载后重新清空所有的类
	 */
	static void clearAppClasses() {
		appClasses.clear();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> void findClassesByParent(List<Class<T>> classes, Class<T> pclazz, boolean mustCanNewInstance) {
		for (Class clazz : appClasses) {
			System.out.println(clazz.getName());
			tryToaddClass(classes, pclazz, mustCanNewInstance, clazz);
		}
	}

	/**
	 * 扫包核心：扫描项目包含的所有类
	 */
	@SuppressWarnings("unused")
	private static void initAppClasses() {

		initByFilePath(PathKit.getRootClassPath());

		Set<String> jars = new HashSet<>();
		findJars(jars, ClassScanner.class.getClassLoader());

		for (String path : jars) {

			JarFile jarFile = null;
			try {
				jarFile = new JarFile(path);
				if (isExcluedeJar(jarFile.getManifest())) {
					continue;
				}
				Enumeration<JarEntry> entries = jarFile.entries();
				while (entries.hasMoreElements()) {
					JarEntry jarEntry = entries.nextElement();
					String entryName = jarEntry.getName();
					if (!jarEntry.isDirectory() && entryName.endsWith(".class")) {
						String className = entryName.replace("/", ".").substring(0, entryName.length() - 6);
						initAppClasses(classForName(className));
					}
				}
			} catch (IOException e1) {
			} finally {
				if (jarFile != null)
					try {
						jarFile.close();
					} catch (IOException e) {
					}
			}

		}
	}

	private static boolean isExcluedeJar(Manifest manifest) {
		if (manifest == null) {
			return false;
		}
		Attributes mainAttributes = manifest.getMainAttributes();
		if (mainAttributes == null) {
			return false;
		}

		String exportPackage = mainAttributes.getValue("Export-Package");
		if (exportPackage != null) {
			if (exportPackage.startsWith("com.google.") || exportPackage.startsWith("org.apache.")
					|| exportPackage.startsWith("org.jboss.") || exportPackage.startsWith("com.netflix.")
					|| exportPackage.startsWith("com.github.") || exportPackage.startsWith("org.eclipse.")
					|| exportPackage.startsWith("com.fasterxml.") || exportPackage.startsWith("org.slf4j")
					|| exportPackage.startsWith("net.sf")) {
				return true;
			}
		}

		String vendor = mainAttributes.getValue("Implementation-Vendor");
		if (vendor != null) {
			vendor = vendor.toLowerCase();
			if (vendor.indexOf("jboss") > -1 || vendor.indexOf("apache") > -1 || vendor.indexOf("oracle") > -1
					|| vendor.indexOf("netty") > -1 || vendor.indexOf("dubbo") > -1) {
				return true;
			}
		}

		return false;
	}

	private static void initByFilePath(String filePath) {
		System.out.println("initByFilePath : "+filePath);
		List<File> classFileList = new ArrayList<>();
		scanClassFile(classFileList, filePath);
		for (File file : classFileList) {

			int start = filePath.length();
			int end = file.toString().length() - ".class".length();

			String classFile = file.toString().substring(start + 1, end);
			String className = "okkpp."+classFile.replace(File.separator, ".");

			initAppClasses(classForName(className));
		}
	}

	@SuppressWarnings("rawtypes")
	private static void initAppClasses(Class clazz) {
		if (clazz != null)
			appClasses.add(clazz);
	}

	private static void findJars(Set<String> set, ClassLoader classLoader) {
		try {
			if (classLoader instanceof URLClassLoader) {
				URLClassLoader urlClassLoader = (URLClassLoader) classLoader;
				URL[] urLs = urlClassLoader.getURLs();
				String JAVA_HOME = new File(System.getProperty("java.home"), "..").getCanonicalPath();
				for (URL url : urLs) {
					String path = url.getPath();
					path = URLDecoder.decode(path, Const.DEFAULT_ENCODING);
					
					// path : /d:/xxx
					if (path.startsWith("/") && path.indexOf(":") == 2) {
						path = path.substring(1);
					}
//					path = path.replaceAll("!", "");
//					if (path.endsWith("/")) {
//						path = path.substring(0, path.length()-1);
//					}
					System.out.println("path = "+path+" protocol="+url.getProtocol());
					
					if (!path.toLowerCase().endsWith(".jar")) {
						System.out.println("not end whith jar");
						initByFilePath(new File(path).getCanonicalPath());
					}

					if (!path.startsWith(JAVA_HOME)) {
						set.add(path);
					}
				}
			}
			ClassLoader parent = classLoader.getParent();
			if (parent != null) {
				findJars(set, parent);
			}
		} catch (Throwable ex) {
			ex.printStackTrace();
		}
	}

	private static <T> void tryToaddClass(List<Class<T>> classes, Class<T> pclazz, boolean mustCanNewInstance,
			Class<T> clazz) {
		if (classes == null || pclazz == null || clazz == null || !pclazz.isAssignableFrom(clazz)) {

			return;
		}

		if (!mustCanNewInstance) {
			classes.add(clazz);
			return;
		}

		if (clazz.isInterface() || Modifier.isAbstract(clazz.getModifiers())) {
			return;
		}

		classes.add(clazz);
	}

	@SuppressWarnings("rawtypes")
	private static Class classForName(String className) {
		try {
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			return Class.forName(className, false, cl);
		} catch (Throwable ex) {
			// ignore
		}
		return null;
	}

	private static void scanClassFile(List<File> fileList, String path) {
		File files[] = new File(path).listFiles();
		if (null == files || files.length == 0)
			return;
		for (File file : files) {
			if (file.isDirectory()) {
				scanClassFile(fileList, file.getAbsolutePath());
			} else if (file.getName().endsWith(".class")) {
				fileList.add(file);
			}
		}
	}

}
