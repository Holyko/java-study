package demo.pattern.structural.bridgepattern.place;

public class Healton extends AbstractPlace {

	@Override
	public String name() {
		return "希尔顿酒店";
	}

	@Override
	public void show() {
		System.out.println("在" + name() + "，遇见了很多人。");
	}

}
