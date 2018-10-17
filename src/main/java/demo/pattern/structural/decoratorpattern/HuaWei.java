package demo.pattern.structural.decoratorpattern;

public class HuaWei implements Phone {
	
	private String name = "华为";

	@Override
	public void width() {
		System.out.println(name + "：获取宽度");
	}

	@Override
	public void height() {
		System.out.println(name + "：获取高度");
	}

}
