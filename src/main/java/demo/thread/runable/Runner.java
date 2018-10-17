package demo.thread.runable;

public class Runner {

  public static void main(String[] args) {
    new Thread(new MyRunable(), "Runable方式").start();
  }
  
}
