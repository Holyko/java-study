package demo.pattern.structural.filterpattern.criteria;

import java.util.List;

import demo.pattern.structural.filterpattern.computer.Computer;

public interface Criteria {
	
	public List<Computer> filte(List<Computer> computers);

}
