package demo.pattern.creational.abstractfactorypattern.mouse;

public class LenovoMouse implements Mouse {

	public static final String BRAND = "Lenovo";
	
	public void use() {
		System.out.println(BRAND + ": you can use the mouse now!");
	}

}
