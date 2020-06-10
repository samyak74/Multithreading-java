import java.util.concurrent.*;

public class RunApp {
  // scheduled thread pool will schedule the threads at a fixed rate or fixed delay
  private static final ScheduledExecutorService SCHEDULED_EXECUTOR_SERVICE = new ScheduledThreadPoolExecutor(1);
  //cache thread pool will create new threads as per incoming tasks and kill those threads if they are idle for 60 seconds
  private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
  private static final ExecutorService EXECUTOR_SERVICE_1 = Executors.newFixedThreadPool(2);
  private static final ExecutorService EXECUTOR_SERVICE_2 = Executors.newSingleThreadExecutor();
  private static final ExecutorService EXECUTOR_SERVICE_3 = new ThreadPoolExecutor(
          10, //core pool size
          100, // max pool size
          120, // keep alive time
          TimeUnit.SECONDS,
          new ArrayBlockingQueue<>(300));

  static {
    SCHEDULED_EXECUTOR_SERVICE.scheduleAtFixedRate(() -> {
      System.out.println("scheduled to print in every 1 second");
    }, 0, 1000, TimeUnit.MILLISECONDS);

    SCHEDULED_EXECUTOR_SERVICE.schedule(() -> {
      System.out.println("scheduled to print just once in 5 sec");
    }, 5000, TimeUnit.MILLISECONDS);

    SCHEDULED_EXECUTOR_SERVICE.scheduleWithFixedDelay(() -> {
      System.out.println("scheduled to print in 2 seconds delay");
    }, 0, 2000, TimeUnit.MILLISECONDS);
  }

  public static void main (String[] args) throws java.lang.Exception {
    ExtendThread extendThread = new ExtendThread("hello from thread 1 ");
    ExtendThread extendThread1 = new ExtendThread("hi from thread 2");
    //set the priority for a thread
    extendThread.setPriority(Thread.MIN_PRIORITY);
    //start the thread
    extendThread.start();
    //wait for the thread to complete it's execution
    extendThread.join();

    // thread using implementing Runnable
    ImplementRunnable implementRunnable = new ImplementRunnable("hola from thread 3");
    Thread thread3 = new Thread(implementRunnable);
    thread3.start();

    //Executor service example
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    for (int i = 0; i < 10; i++) {
      Runnable worker = new WorkerThread("" + i);
      executorService.execute(worker);
    }
    executorService.shutdown();
    while (!executorService.isTerminated()) {}
    System.out.println("Finished all threads");
  }
}
