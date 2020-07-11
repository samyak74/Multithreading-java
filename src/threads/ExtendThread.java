package threads;

public class ExtendThread extends Thread {
  private String printThis;
  ExtendThread(String param) {
    printThis = param;
  }
  public void run() {
    for (int i = 0; i < 500; i++) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(printThis + currentThread().getName());
    }
  }
}
