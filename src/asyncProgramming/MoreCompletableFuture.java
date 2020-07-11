package asyncProgramming;

import java.util.concurrent.CompletableFuture;

public class MoreCompletableFuture {
	public static void main(String [] args) {
		CompletableFuture<Integer> completableFuture = new CompletableFuture<>();
		pipeLine1(completableFuture);
		completableFuture.complete(10);

	}

	public static void pipeLine1(CompletableFuture<Integer> completableFuture) {
		CompletableFuture<Void> voidCompletableFuture = completableFuture.thenApply(val -> val * 100)
						.thenApply(val -> val + 10)
						//.thenApply(MoreCompletableFuture::returnVal)
						.exceptionally(MoreCompletableFuture::handleError)
						.thenAccept(System.out::println);
		boolean done = voidCompletableFuture.isDone();
		if (done) {
			System.out.println("done tasks");
		}
	}
	private static int returnVal(int a) {
		throw new RuntimeException();
	}
	private static int handleError(Throwable throwable) {
		return 100;
	}

}
