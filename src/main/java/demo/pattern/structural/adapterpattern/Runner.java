package demo.pattern.structural.adapterpattern;

import demo.pattern.structural.adapterpattern.card.CardInterface;
import demo.pattern.structural.adapterpattern.card.SDCard;
import demo.pattern.structural.adapterpattern.card.TFCard;
import demo.pattern.structural.adapterpattern.usb.CardAdaptor;
import demo.pattern.structural.adapterpattern.usb.Computer;

public class Runner {

	public static void main(String[] args) {
		Computer computer = new Computer();
		CardInterface sd = new SDCard();
		CardInterface tf = new TFCard();
		CardAdaptor adaptor = new CardAdaptor(sd);
		computer.load(adaptor);
		computer.use();
		
		adaptor = new CardAdaptor(tf);
		computer.load(adaptor);
		computer.use();
	}
	
}
