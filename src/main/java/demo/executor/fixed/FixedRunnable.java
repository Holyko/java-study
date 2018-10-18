package demo.executor.fixed;

public class FixedRunnable implements Runnable {
  
  private String name = null;
  
  public FixedRunnable(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    Thread.currentThread().setName(this.name);
    System.out.println(Thread.currentThread().getName() + ": my id is " + Thread.currentThread().getId());
    Thread.currentThread().interrupt();
  }

}
