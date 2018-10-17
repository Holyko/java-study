package demo.pattern.structural.facadepattern.component;

public abstract class AbstractComponent implements Component {
	
	public String name;

	@Override
	public void start() {
		System.out.println(name + "is started.");
	}

	@Override
	public void stop() {
		System.out.println(name + "is stoped.");
	}

}
