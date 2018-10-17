package demo.pattern.creational.singlepattern.lazy;

/**
 * 单例模式：懒汉
 * 在第一使用的时候，才会去初始化，避免内存浪费。
 * 虽然有同步锁，但是在被实例化后，同步锁也失去了意义，仅在首次实例化的时候会影响效率。
 *
 */
public class LazySingleton {
	
	private static LazySingleton lazySingleton = null;
	
	private LazySingleton() {
		System.out.println("the lazy singleton: init.");
	}
	
	public static LazySingleton instance() {
		if (lazySingleton == null) {
			synchronized (LazySingleton.class) {
				if (lazySingleton == null) {
					lazySingleton = new LazySingleton();
				}
			}
		}
		return lazySingleton;
	}
	
	public void use() {
		System.out.println("the lazy singletom: use.");
	}

}
