package demo.pattern.creational.factorypattern;

import demo.pattern.creational.factorypattern.computer.Computer;

public class Runner {

	public static void main(String[] args) {
		ComputerFactory factory = new ComputerFactory();
		
		Computer mac = factory.build("Apple");
		mac.use();
		
		Computer surface = factory.build("Microsoft");
		surface.use();
		
		Computer thinkpad = factory.build("Lenovo");
		thinkpad.use();
	}
	
}
