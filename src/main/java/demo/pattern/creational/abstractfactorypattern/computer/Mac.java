package demo.pattern.creational.abstractfactorypattern.computer;

public class Mac implements Computer {
	
	public static final String Brand = "Apple";

	public void use() {
		System.out.println(Brand + ": you can use the computer now!");
	}

}
