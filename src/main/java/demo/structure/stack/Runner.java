package demo.structure.stack;

import demo.utils.StringHelper;

public class Runner {

	public static void main(String[] args) {
	  Stack<String> stack = new Stack<String>(10);
	  
	  for (int i = 0; i < 10; i++) {
        String tmp = StringHelper.random(10);
        stack.push(tmp);
      }
	  
	  stack.display();
	  
	  while (stack.hasNext()) {
        System.out.println(stack.peek());
        stack.pop();
      }
	}
	
}
