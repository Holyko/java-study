package demo.pattern.structural.proxypattern;

public class Runner {

	public static void main(String[] args) {
		Computer computer = new ComputerSeller();
		computer.price();
	}
	
}
