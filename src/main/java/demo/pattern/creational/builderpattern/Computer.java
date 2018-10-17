package demo.pattern.creational.builderpattern;

import java.util.ArrayList;
import java.util.List;

import demo.pattern.creational.builderpattern.cpu.Cpu;
import demo.pattern.creational.builderpattern.disk.Disk;
import demo.pattern.creational.builderpattern.memory.Memory;

public class Computer {

	private List<Component> components = new ArrayList<>();
	
	public void cpu(Cpu cpu) {
		this.components.add(cpu);
	}
	
	public void disk(Disk disk) {
		this.components.add(disk);
	}
	
	public void memory(Memory memory) {
		this.components.add(memory);
	}
	
	public void price() {
		double total = 0.00d;
		for (Component component : components) {
			total += component.price();
		}
		System.out.println("total: " + total);
	}
	
	public void use() {
		for (Component component : components) {
			component.use();
		}
	}
	
}
