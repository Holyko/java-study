package demo.pattern.creational.factorypattern;

import demo.pattern.creational.factorypattern.computer.Computer;
import demo.pattern.creational.factorypattern.computer.Mac;
import demo.pattern.creational.factorypattern.computer.Surface;
import demo.pattern.creational.factorypattern.computer.Thinkpad;

public class ComputerFactory {

	public Computer build(String brand) {
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
	
}
