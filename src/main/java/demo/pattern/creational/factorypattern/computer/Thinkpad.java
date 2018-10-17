package demo.pattern.creational.factorypattern.computer;

public class Thinkpad implements Computer {

	public static final String BRAND = "Lenovo";
	
	@Override
	public void use() {
		System.out.println(BRAND + ": you can use the computer now!");
	}

}
