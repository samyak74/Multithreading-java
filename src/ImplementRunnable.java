public class ImplementRunnable implements Runnable {
  String param;
  ImplementRunnable(String param) {
    this.param = param;
  }
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("thread implemented using runnable is running " + param);
    }
  }
}
