package demo.pattern.structural.filterpattern;

import java.util.ArrayList;
import java.util.List;

import demo.pattern.structural.filterpattern.computer.Computer;
import demo.pattern.structural.filterpattern.criteria.CriteriaApple;
import demo.pattern.structural.filterpattern.criteria.CriteriaBlackMicrosoft;
import demo.pattern.structural.filterpattern.criteria.CriteriaXiaoMi;

public class Runner {

	public static void main(String[] args) {
		List<Computer> computers = new ArrayList<>();
		
		computers.add(new Computer(Computer.Brand.Apple, Computer.Size.X13, Computer.Color.White));
		computers.add(new Computer(Computer.Brand.Apple, Computer.Size.X15, Computer.Color.White));
		computers.add(new Computer(Computer.Brand.XiaoMi, Computer.Size.X13, Computer.Color.White));
		computers.add(new Computer(Computer.Brand.Microsoft, Computer.Size.X13, Computer.Color.White));
		computers.add(new Computer(Computer.Brand.Microsoft, Computer.Size.X13, Computer.Color.Black));
		computers.add(new Computer(Computer.Brand.Microsoft, Computer.Size.X13, Computer.Color.Ohter));
		computers.add(new Computer(Computer.Brand.HuaWei, Computer.Size.X13, Computer.Color.White));
		computers.add(new Computer(Computer.Brand.HuaWei, Computer.Size.X13, Computer.Color.Ohter));
		
		System.out.println("所有的电脑：");
		show(computers);
		
		List<Computer> apples = new CriteriaApple().filte(computers);
		System.out.println("苹果电脑：");
		show(apples);
		
		List<Computer> black_microsofts = new CriteriaBlackMicrosoft().filte(computers);
		System.out.println("黑色的微软电脑：");
		show(black_microsofts);
		
		List<Computer> xiaomis = new CriteriaXiaoMi().filte(computers);
		System.out.println("小米电脑：");
		show(xiaomis);
	}
	
	public static void show(List<Computer> computers){
      for (Computer computer : computers) {
         System.out.println("[brand: " + computer.getBrand() + ", size: " + computer.getSize() + ", color: " + computer.getColor() + "]");
      }
   } 
	
}
