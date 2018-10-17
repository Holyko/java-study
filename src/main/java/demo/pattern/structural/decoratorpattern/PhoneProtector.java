package demo.pattern.structural.decoratorpattern;

public abstract class PhoneProtector implements Phone {

	protected Phone phone;
	
	public PhoneProtector(Phone phone) {
		this.phone = phone;
	}
	
	public void width() {
		phone.width();
	}
	
	public void height() {
		phone.height();
	}
	
}
