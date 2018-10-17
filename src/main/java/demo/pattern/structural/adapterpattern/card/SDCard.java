package demo.pattern.structural.adapterpattern.card;

public class SDCard implements CardInterface {

	@Override
	public void use() {
		System.out.println("SD Card 被使用了。");
	}

}
