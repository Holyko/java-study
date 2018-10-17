package demo.pattern.structural.bridgepattern.person;

import demo.pattern.structural.bridgepattern.place.Place;

public class XiaoMing extends AbstractPerson {
	
	public XiaoMing() {
		super.name = "小明";
	}

	@Override
	public void to(Place place) {
		System.out.println(super.name + "去" + place.name());
		place.show();
	}

}
