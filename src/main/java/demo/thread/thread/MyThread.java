package demo.thread.thread;

public class MyThread extends Thread {

  public MyThread(String name) {
    super(name);
  }
  
  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println("正在执行的线程名字是：" + name);
  }
  
}
