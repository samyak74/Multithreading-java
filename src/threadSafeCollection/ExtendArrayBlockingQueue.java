package threadSafeCollection;

import threadSafeCollection.ArrayBlockingQueueTest;

public class ExtendArrayBlockingQueue extends ArrayBlockingQueueTest {
	@Override
	public String makeSound() {
		return "hi";
	}
}
