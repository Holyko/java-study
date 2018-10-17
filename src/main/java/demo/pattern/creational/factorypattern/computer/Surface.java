package demo.pattern.creational.factorypattern.computer;

public class Surface implements Computer {

	public static final String BRAND = "Microsoft";
	
	@Override
	public void use() {
		System.out.println(BRAND + ": you can use the computer now!");
	}

}
