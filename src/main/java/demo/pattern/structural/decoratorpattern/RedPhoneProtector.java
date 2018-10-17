package demo.pattern.structural.decoratorpattern;

public class RedPhoneProtector extends PhoneProtector {

	public RedPhoneProtector(Phone phone) {
		super(phone);
	}
	
	@Override
	public void width() {
		System.out.println("使用精密仪器");
		phone.width();
	}
	
	@Override
	public void height() {
		System.out.println("使用手工测量");
		phone.width();
	}

}
