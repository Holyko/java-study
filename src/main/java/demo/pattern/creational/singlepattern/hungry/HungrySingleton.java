package demo.pattern.creational.singlepattern.hungry;

/**
 * 单例模式：饥汉
 * 在类加载的时候被初始化，会一直存在于内存中，造成内存浪费。
 * 由于没有同步锁的存在，效率会很高。
 *
 */

public class HungrySingleton {
	
	private static HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton() {
		System.out.println("the hungry singleton: init.");
	}
	
	public static HungrySingleton instance() {
		return hungrySingleton;
	}
	
	public void use() {
		System.out.println("the hungry singletom: use.");
	}
	
}
