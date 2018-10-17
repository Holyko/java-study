package demo.pattern.structural.filterpattern.criteria;

import java.util.ArrayList;
import java.util.List;

import demo.pattern.structural.filterpattern.computer.Computer;

public class CriteriaApple implements Criteria {

	@Override
	public List<Computer> filte(List<Computer> computers) {
		List<Computer> list = new ArrayList<Computer>();
		
		for (Computer computer : computers) {
			if (Computer.Brand.Apple.equals(computer.getBrand())) {
				list.add(computer);
			}
		}
		
		return list;
	}

}
