package demo.pattern.creational.abstractfactorypattern;

import demo.pattern.creational.abstractfactorypattern.computer.Computer;
import demo.pattern.creational.abstractfactorypattern.mouse.Mouse;

public abstract class AbstractFactory {

	public abstract Computer buildComputer(String brand);
	
	public abstract Mouse buildMouse(String brand);
	
}
