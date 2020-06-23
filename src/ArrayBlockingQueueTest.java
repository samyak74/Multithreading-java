import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ArrayBlockingQueueTest {
	public static void main (String[] args) {
		CustomArrayBlockingQueue<Integer> queue = new CustomArrayBlockingQueue<>(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		System.out.println("remaining " + queue.remainingCapacity());
		if (queue.remainingCapacity()==0) {
			queue.remove();
		}
		if (queue.remainingCapacity() > 0) {
			queue.add(2);
		} else {
			System.out.println("queue is full\n");
		}

		for (Integer integer : queue) {
			System.out.println(integer);
		}

	}
}
