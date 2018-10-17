package demo.pattern.creational.singlepattern.lazy;

public class Runner {
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			LazySingleton.instance().use();
		}
	}
	
}
