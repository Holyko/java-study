package demo.pattern.structural.proxypattern;

public class ComputerSeller implements Computer {
	
	private Computer computer;
	
	public ComputerSeller() {
		this.computer = new ComputerBuilder();
	}

	@Override
	public void price() {
		System.out.println("柜面价：999.99元。");
		computer.price();
	}

}
