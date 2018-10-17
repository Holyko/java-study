package demo.pattern.structural.decoratorpattern;

public class XiaoMi implements Phone {

	private String name = "小米";
	
	@Override
	public void width() {
		System.out.println(name + "：获取宽度");
	}

	@Override
	public void height() {
		System.out.println(name + "：获取高度");
	}

}
