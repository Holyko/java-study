package demo.structure.queue;

import demo.utils.StringHelper;

public class Runner {

  public static void main(String[] args) throws Exception {
    Queue<String> queue = new Queue<>();
    
    for (int i = 0; i < 10; i++) {
      String tmp = StringHelper.random(10);
      queue.add(tmp);
    }
    
    queue.dispaly();
    
    while (queue.hasNext()) {
      System.out.println(queue.element());
      queue.remove();
    }
  }
  
}
