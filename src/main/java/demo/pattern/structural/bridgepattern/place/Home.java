package demo.pattern.structural.bridgepattern.place;

public class Home extends AbstractPlace {

	@Override
	public String name() {
		return "家里";
	}

	@Override
	public void show() {
		System.out.println("在" + name() + "，玩了一晚上的游戏。");
	}

}
