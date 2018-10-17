package demo.thread.callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
  
  public MyCallable(String name) {
    Thread.currentThread().setName(name);
  }

  public String call() throws Exception {
    String name = Thread.currentThread().getName();
    System.out.println("正在执行的线程名字是：" + name);
    return name;
  }

}
