package demo.pattern.structural.bridgepattern;

import demo.pattern.structural.bridgepattern.person.LiLei;
import demo.pattern.structural.bridgepattern.person.Person;
import demo.pattern.structural.bridgepattern.person.XiaoMing;
import demo.pattern.structural.bridgepattern.place.Healton;
import demo.pattern.structural.bridgepattern.place.Home;
import demo.pattern.structural.bridgepattern.place.Place;

public class Runner {

	public static void main(String[] args) {
		Person xiaoming = new XiaoMing();
		Person lilei = new LiLei();
		
		Place healton = new Healton();
		Place home = new Home();
		
		xiaoming.to(healton);
		lilei.to(home);
	}
	
}
