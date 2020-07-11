package asyncProgramming;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
	public static void main(String[] args) {
		//commit 3
		System.out.println(Thread.currentThread().getName());
		System.out.println("Start");
		CompletableFuture.supplyAsync(CompletableFutureTest::doProcess)
						.thenApply(value -> value + " append this")
						.thenAccept(System.out::println);
		for (int i = 0; i < 10; i++) {
			CompletableFuture.runAsync(() -> {
				//System.out.println(Thread.currentThread().getName());
				threadSleep( 1000);
				System.out.println("runnable process end");
			});
		}
		System.out.println("End");
		threadSleep(5000);
	}



	public static String doProcess() {
		System.out.println(Thread.currentThread().getName());
		threadSleep(2000);
		return "return this";
	}

	public static void threadSleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
