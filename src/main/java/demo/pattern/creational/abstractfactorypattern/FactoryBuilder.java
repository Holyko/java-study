package demo.pattern.creational.abstractfactorypattern;

public class FactoryBuilder {

	public static AbstractFactory buildFactory(String factory) {
		if (ComputerFactory.Factory.equals(factory)) {
			return new ComputerFactory();
		}
		if (MouseFactory.Factory.equals(factory)) {
			return new MouseFactory();
		}
		
		return null;
	}
	
}
