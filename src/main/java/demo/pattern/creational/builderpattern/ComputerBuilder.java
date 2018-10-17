package demo.pattern.creational.builderpattern;

import demo.pattern.creational.builderpattern.cpu.Cpu;
import demo.pattern.creational.builderpattern.cpu.IntelCpu;
import demo.pattern.creational.builderpattern.disk.Disk;
import demo.pattern.creational.builderpattern.disk.SeagateDisk;
import demo.pattern.creational.builderpattern.memory.KingstonMemory;
import demo.pattern.creational.builderpattern.memory.Memory;

public class ComputerBuilder {

	public Computer build() {
		Cpu cpu = new IntelCpu("Intel i7", 899.99d);
		Disk disk = new SeagateDisk("希捷", 99.00d);
		Memory memory = new KingstonMemory("Kingston", 199.99d);
		
		Computer computer = new Computer();
		computer.cpu(cpu);
		computer.disk(disk);
		computer.memory(memory);
		
		return computer;
	}
	
}
