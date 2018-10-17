package demo.pattern.creational.abstractfactorypattern;

import demo.pattern.creational.abstractfactorypattern.computer.Computer;
import demo.pattern.creational.abstractfactorypattern.computer.Mac;
import demo.pattern.creational.abstractfactorypattern.computer.Surface;
import demo.pattern.creational.abstractfactorypattern.mouse.AppleMouse;
import demo.pattern.creational.abstractfactorypattern.mouse.MicrosoftMouse;
import demo.pattern.creational.abstractfactorypattern.mouse.Mouse;

public class Runner {

	public static void main(String[] args) {
		
		AbstractFactory computerFactory = FactoryBuilder.buildFactory(ComputerFactory.Factory);
		
		Computer mac = computerFactory.buildComputer(Mac.Brand);
		mac.use();
		
		Computer surface = computerFactory.buildComputer(Surface.Brand);
		surface.use();
		
		AbstractFactory mouseFactory = FactoryBuilder.buildFactory(MouseFactory.Factory);
		
		Mouse appleMouse = mouseFactory.buildMouse(AppleMouse.Brand);
		appleMouse.use();
		
		Mouse microsoftMouse = mouseFactory.buildMouse(MicrosoftMouse.Brand);
		microsoftMouse.use();
		
	}
	
}
