package demo.pattern.creational.prototypepattern;

public class Mac extends Computer {

	private static final long serialVersionUID = 7105512786619664842L;

	public Mac() {
		super.name = "Apple Mac";
	}

	@Override
	public void use() {
		System.out.println(super.name + ": used.");
	}
	
}
