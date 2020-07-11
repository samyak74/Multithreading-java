package asyncProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ExecutorsAsync {
	private static final ExecutorService executorService = Executors.newFixedThreadPool(10);


	public static void main(String[] args) {
		List<Future<Object>> futures = new ArrayList<>();
		List<Callable<Object>> callableList = new ArrayList<>();
		callableList.add(c);
		callableList.add(c1);
		callableList.add(c2);
		callableList.add(() -> "inline callable");
		try {
			futures = executorService.invokeAll(callableList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (Future<Object> future : futures) {
			try {
				Object o = future.get();
				System.out.println("result returned : " + o);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

	}
	private static final Callable c = () -> {
		Random random = new Random();
		long l = random.nextInt(5000);
		System.out.println("random num1 " + l);
		Thread.sleep(l);
		return "result 1";
	};

	private static final Callable c1 = () -> {
		Random random = new Random();
		long l = random.nextInt(5000);
		System.out.println("random num2 " + l);
		Thread.sleep(l);
		return "result 2";
	};

	private static final Callable c2 = () -> {
		Random random = new Random();
		long l = random.nextInt(5000);
		System.out.println("random num3 " + l);
		Thread.sleep(l);
		return "result 3";
	};

}
