import java.util.concurrent.*;

public class ExecutorTest {
  private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(1);

  public static void main (String[] args) {

    System.out.println("hello 1");

    EXECUTOR_SERVICE.execute(() -> {
      try {
        Thread.sleep(1000);
        System.out.println("hello 3");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    System.out.println("hello 2");

    Future<Object> submit = EXECUTOR_SERVICE.submit(() -> {
      Thread.sleep(5000);
      return "This is returned after the thread has done it's work";
    });

    submit.cancel(true);

    while (!submit.isDone()) {
      //System.out.println("task not completed yet");
      try {
        submit.get();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    System.out.println("Task completed");
    if (submit.isDone()) {
      try {
        System.out.println(submit.get());
      } catch (InterruptedException | ExecutionException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
