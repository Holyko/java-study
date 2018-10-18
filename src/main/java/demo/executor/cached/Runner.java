package demo.executor.cached;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

  public static void main(String[] args) throws InterruptedException {
    ExecutorService executor = Executors.newCachedThreadPool();
    
    for (int i = 0; i < 10; i++) {
      executor.execute(new CachedRunnable("cached-thread-" + i));
    }
    
    Thread.sleep(1000 * 3);
    
    ThreadGroup group = Thread.currentThread().getThreadGroup();
    int total = group.activeCount();
    Thread[] threads = new Thread[total];
    group.enumerate(threads);
    System.out.println(total);
    for (Thread thread : threads) {
      System.out.println(thread.getName() + " - " + thread.isInterrupted());
    }
  }
  
}
