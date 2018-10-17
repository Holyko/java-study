package demo.pattern.creational.abstractfactorypattern.mouse;

public class MicrosoftMouse implements Mouse {

	public static final String Brand = "Microsoft";
	
	public void use() {
		System.out.println(Brand + ": you can use the mouse now!");
	}

}
