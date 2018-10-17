package demo.pattern.structural.adapterpattern.card;

public class TFCard implements CardInterface {

	@Override
	public void use() {
		System.out.println("TF Card 被使用了。");
	}

}
