package demo.pattern.creational.builderpattern.memory;

import demo.pattern.creational.builderpattern.Component;

public abstract class Memory implements Component {
	
	protected String name = "defualt";

	protected double price = 0.00d;

	public String name() {
		return name;
	};

	public double price() {
		return price;
	}

	public void use() {
		System.out.println("Memory" + name + " - " + price);
	};
	
}
