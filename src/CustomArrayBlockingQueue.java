
import java.util.concurrent.ArrayBlockingQueue;

public class CustomArrayBlockingQueue<E> extends ArrayBlockingQueue<E> {

	private int size;

	public CustomArrayBlockingQueue(int capacity) {
		super(capacity);
		this.size = capacity;
	}

	@Override
	synchronized public boolean add(E e) {
		if (super.size() == this.size) {
			this.remove();
		}
		return super.add(e);
	}
}
