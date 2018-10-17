package demo.pattern.creational.abstractfactorypattern.mouse;

public class AppleMouse implements Mouse {
	
	public static final String Brand = "Apple";

	public void use() {
		System.out.println(Brand + ": you can use the mouse now!");
	}

}
