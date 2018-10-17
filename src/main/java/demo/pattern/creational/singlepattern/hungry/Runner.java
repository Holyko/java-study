package demo.pattern.creational.singlepattern.hungry;

public class Runner {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			HungrySingleton.instance().use();
		}
	}
	
}
