package demo.executor.scheduled;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Runner {

  public static void main(String[] args) throws InterruptedException {
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
    
    for (int i = 0; i < 10; i++) {
      executor.scheduleAtFixedRate(new ScheduledRunnable("scheduled-thread-" + i), 1000, 3000, TimeUnit.MILLISECONDS);
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
