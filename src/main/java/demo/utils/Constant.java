package demo.utils;

public class Constant {

	public static class Net {
		
		public static final String Default_IP = "127.0.0.1";
		
		public static final int Default_Port = 10000;
		
	}
	
	public enum Position {
	  TOP(0), BOTTOM(1);
	  
	  private int value;

      private Position(int value) {
        this.value = value;
      }
	}
	
}
