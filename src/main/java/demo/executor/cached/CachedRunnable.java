package demo.executor.cached;

public class CachedRunnable implements Runnable {
  
  private String name;
  
  public CachedRunnable(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    Thread.currentThread().setName(this.name);
    System.out.println(Thread.currentThread().getName() + ": my id is " + Thread.currentThread().getId());
    Thread.currentThread().interrupt();
  }

}
