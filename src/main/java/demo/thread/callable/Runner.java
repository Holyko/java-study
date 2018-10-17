package demo.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Runner {

  public static void main(String[] args) {
    FutureTask<String> futureTask = new FutureTask<String>(new MyCallable("callable方式"));
    futureTask.run();
    
    if (futureTask.isDone()) {
      try {
        System.out.println(futureTask.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }
  }
  
}
