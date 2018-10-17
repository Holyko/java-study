package demo.pattern.structural.proxypattern;

public class ComputerBuilder implements Computer {

	@Override
	public void price() {
		System.out.println("出厂价格：100.00元。");
	}

}
