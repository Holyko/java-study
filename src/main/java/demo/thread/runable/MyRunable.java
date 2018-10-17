package demo.thread.runable;

public class MyRunable implements Runnable {

  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println("正在执行的线程名字是：" + name);
  }

}
