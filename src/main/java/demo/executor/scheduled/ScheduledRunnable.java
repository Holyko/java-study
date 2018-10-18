package demo.executor.scheduled;

public class ScheduledRunnable implements Runnable {
  
  private String name;
  
  public ScheduledRunnable(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    Thread.currentThread().setName(this.name);
    System.out.println(Thread.currentThread().getName() + ": my id is " + Thread.currentThread().getId());
    
    try {
      Thread.sleep(1000 * 3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
