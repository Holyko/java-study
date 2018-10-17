package demo.pattern.structural.adapterpattern.usb;

import demo.pattern.structural.adapterpattern.card.CardInterface;

public class CardAdaptor implements UsbInterface {

	public CardInterface card;
	
	public CardAdaptor(CardInterface card) {
		this.card = card;
	}
	
	@Override
	public void use() {
		System.out.println("读卡器的USB接口被使用了。");
		card.use();
	}

}
