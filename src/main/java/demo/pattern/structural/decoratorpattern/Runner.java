package demo.pattern.structural.decoratorpattern;

public class Runner {

	public static void main(String[] args) {
		Phone xiaomi = new XiaoMi();
		Phone huawei = new HuaWei();
		
		PhoneProtector protector1 = new RedPhoneProtector(xiaomi);
		protector1.width();
		
		PhoneProtector protector2 = new RedPhoneProtector(huawei);
		protector2.height();
	}
	
}
