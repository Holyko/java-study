package demo.pattern.structural.bridgepattern.person;

import demo.pattern.structural.bridgepattern.place.Place;

public class LiLei extends AbstractPerson {
	
	public LiLei() {
		super.name = "李雷";
	}

	@Override
	public void to(Place place) {
		System.out.println(super.name + "去" + place.name());
		place.show();
	}
}
