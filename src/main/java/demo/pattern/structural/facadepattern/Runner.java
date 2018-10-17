package demo.pattern.structural.facadepattern;

public class Runner {

	public static void main(String[] args) throws InterruptedException {
		Computer computer = new Computer();
		computer.start();
		
		Thread.sleep(1000 * 3);
		
		computer.stop();
	}
	
}
