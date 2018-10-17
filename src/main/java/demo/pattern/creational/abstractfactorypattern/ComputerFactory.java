package demo.pattern.creational.abstractfactorypattern;

import demo.pattern.creational.abstractfactorypattern.computer.Computer;
import demo.pattern.creational.abstractfactorypattern.computer.Mac;
import demo.pattern.creational.abstractfactorypattern.computer.Surface;
import demo.pattern.creational.abstractfactorypattern.computer.Thinkpad;
import demo.pattern.creational.abstractfactorypattern.mouse.Mouse;

public class ComputerFactory extends AbstractFactory {
	
	public static final String Factory = "Computer";

	@Override
	public Computer buildComputer(String brand) {
		if (brand == null) {
			return null;
		}
		
		if ("Apple".equals(brand)) {
			return new Mac();
		}
		if ("Microsoft".equals(brand)) {
			return new Surface();
		}
		if ("Lenovo".equals(brand)) {
			return new Thinkpad();
		}
		
		return null;
	}

	@Override
	public Mouse buildMouse(String brand) {
		return null;
	}

}
