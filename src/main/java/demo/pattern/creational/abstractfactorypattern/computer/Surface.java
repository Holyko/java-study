package demo.pattern.creational.abstractfactorypattern.computer;

public class Surface implements Computer {

	public static final String Brand = "Microsoft";
	
	public void use() {
		System.out.println(Brand + ": you can use the computer now!");
	}

}
