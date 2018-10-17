package demo.pattern.structural.facadepattern;

import demo.pattern.structural.facadepattern.component.CPU;
import demo.pattern.structural.facadepattern.component.Component;
import demo.pattern.structural.facadepattern.component.Disk;
import demo.pattern.structural.facadepattern.component.Memory;

public class Computer {

	private Component cpu;
	
	private Component memory;
	
	private Component disk;

	public Computer() {
		this.cpu = new CPU();
		this.memory = new Memory();
		this.disk = new Disk();
	}
	
	public void start() {
		System.out.println("开机");
		cpu.start();
		memory.start();
		disk.start();
	}
	
	public void stop() {
		System.out.println("关机");
		cpu.stop();
		memory.stop();
		disk.stop();
	}
	
}
