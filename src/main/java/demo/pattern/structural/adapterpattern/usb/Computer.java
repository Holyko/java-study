package demo.pattern.structural.adapterpattern.usb;

public class Computer implements UsbInterface {
	
	public CardAdaptor adaptor;
	
	public void load(CardAdaptor adaptor) {
		this.adaptor = adaptor;
	}

	@Override
	public void use() {
		System.out.println("电脑的USB接口被使用了。");
		adaptor.use();
	}

}
