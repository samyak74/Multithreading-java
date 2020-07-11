package asyncProgramming;

import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class CompletableFutureAsync {
	private static final ExecutorService executorService = Executors.newFixedThreadPool(10);


	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			CompletableFuture.supplyAsync(s)
							.thenApply(o -> {
								String o1 = o;
								System.out.println("a");
								o1 += "apply";
								return o1;
							})
							.thenApply(o -> {
								String o1 = o;
								System.out.println("b");
								o1 += "apply1";
								return o1;
							}).thenAccept(o -> System.out.println("final object " + o));

		}
		System.out.println("here");
		
	}
	private final static Supplier<String> s = () -> {
		Random random = new Random();
		long l = random.nextInt(5000);
		System.out.println("random num1 " + l);
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "supplier return ";
	};

	final static Supplier s1 = () -> {
		Random random = new Random();
		long l = random.nextInt(5000);
		System.out.println("random num2 " + l);
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "supplier return 1";
	};

	final static Supplier s2 = () -> {
		Random random = new Random();
		long l = random.nextInt(5000);
		System.out.println("random num2 " + l);
		try {
			Thread.sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "supplier return 2";
	};

}
