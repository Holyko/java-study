package demo.pattern.creational.abstractfactorypattern;

import demo.pattern.creational.abstractfactorypattern.computer.Computer;
import demo.pattern.creational.abstractfactorypattern.mouse.AppleMouse;
import demo.pattern.creational.abstractfactorypattern.mouse.LenovoMouse;
import demo.pattern.creational.abstractfactorypattern.mouse.MicrosoftMouse;
import demo.pattern.creational.abstractfactorypattern.mouse.Mouse;

public class MouseFactory extends AbstractFactory {
	
	public static final String Factory = "Mouse";

	@Override
	public Computer buildComputer(String brand) {
		return null;
	}

	@Override
	public Mouse buildMouse(String brand) {
		if (brand == null) {
			return null;
		}
		
		if ("Apple".equals(brand)) {
			return new AppleMouse();
		}
		if ("Microsoft".equals(brand)) {
			return new MicrosoftMouse();
		}
		if ("Lenovo".equals(brand)) {
			return new LenovoMouse();
		}
		
		return null;
	}

}
