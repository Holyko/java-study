package demo.pattern.creational.builderpattern;

public class Runner {

	public static void main(String[] args) {
		ComputerBuilder builder = new ComputerBuilder();
		Computer computer = builder.build();
		
		computer.price();
		computer.use();
	}
	
}
