package demo.pattern.creational.singlepattern;

import demo.pattern.creational.singlepattern.hungry.HungrySingleton;
import demo.pattern.creational.singlepattern.lazy.LazySingleton;

public class Runner {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			HungrySingleton.instance().use();
			LazySingleton.instance().use();
		}
	}
	
}
