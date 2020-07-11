package threads;

public class WorkerThread implements Runnable {
  private String message;
  WorkerThread(String s) {
    this.message = s;
  }

  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " START " + message );
    processMessage();
    System.out.println(Thread.currentThread().getName() + " END ");
  }

  private void processMessage() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
