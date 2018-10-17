package demo.pattern.creational.factorypattern.computer;

public class Mac implements Computer {
	
	public static final String BRAND = "Apple";

	@Override
	public void use() {
		System.out.println(BRAND + ": you can use the computer now!");
	}

}
