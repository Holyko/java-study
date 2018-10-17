package demo.pattern.creational.abstractfactorypattern.computer;

public class Thinkpad implements Computer {

	public static final String BRAND = "Lenovo";
	
	public void use() {
		System.out.println(BRAND + ": you can use the computer now!");
	}

}
