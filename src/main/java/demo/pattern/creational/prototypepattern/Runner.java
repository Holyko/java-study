package demo.pattern.creational.prototypepattern;

import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Mac mac = new Mac();
		Mac cloneMac = (Mac) mac.clone();
		cloneMac.use();
		System.out.println(mac.name == cloneMac.name);
		
		Mac deepCloneMac = (Mac) mac.deepClone();
		deepCloneMac.use();
		System.out.println(mac.name == deepCloneMac.name);
	}
}
