package demo.pattern.creational.builderpattern.disk;

import demo.pattern.creational.builderpattern.Component;

public abstract class Disk implements Component {
	
	protected String name = "defualt";

	protected double price = 0.00d;

	public String name() {
		return name;
	};

	public double price() {
		return price;
	}

	public void use() {
		System.out.println("Disk: " + name + " - " + price);
	};
	
}
