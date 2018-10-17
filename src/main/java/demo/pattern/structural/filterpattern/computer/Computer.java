package demo.pattern.structural.filterpattern.computer;

public class Computer {

	private String brand;
	
	private String size;
	
	private String color;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Computer(String brand, String size, String color) {
		this.brand = brand;
		this.size = size;
		this.color = color;
	}
	
	public static class Brand {
		
		public static final String Apple = "apple";
		
		public static final String Microsoft = "microsoft";
		
		public static final String XiaoMi = "xiaomi";
		
		public static final String HuaWei = "huawei";
		
	}
	
	public static class Size {

		public static final String X13 = "x13";
		
		public static final String X15 = "x15";
		
		public static final String X17 = "x17";
	}
	
	public static class Color {

		public static final String Black = "black";
		
		public static final String White = "white";
		
		public static final String Ohter = "other";
	}
	
	
}
