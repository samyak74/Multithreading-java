package miscTest;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueTest {
	public static void main(String[] args) {
		Queue<Long> queue = new ArrayDeque<>();
		queue.add(100L);
		queue.add(200L);
		queue.add(300L);
		System.out.println(queue.peek());
	}
}
