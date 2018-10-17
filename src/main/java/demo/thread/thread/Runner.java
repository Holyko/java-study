package demo.thread.thread;

public class Runner {

  public static void main(String[] args) {
    MyThread myThread = new MyThread("Thread方式");
    myThread.start();
  }
  
}
