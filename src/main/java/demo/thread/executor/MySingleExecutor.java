package demo.thread.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MySingleExecutor {

  private static ExecutorService service = Executors.newSingleThreadExecutor();
  
  public static void start() {
    Callable<Integer> callable = new Callable<Integer>() {
      
      public Integer call() throws Exception {
        System.out.println("正在执行的线程名字是：" + Thread.currentThread().getName());
        return 200;
      }
    };
    
    Future<Integer> future = service.submit(callable);
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e1) {
      e1.printStackTrace();
    }
    if (future.isDone()) {
      try {
        System.out.println(future.get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      } finally {
        future.cancel(true);
      }
    }
  }
  
  public static void main(String[] args) {
    start();
  }
  
}
