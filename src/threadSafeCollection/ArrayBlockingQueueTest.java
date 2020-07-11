package threadSafeCollection;

import java.rmi.MarshalledObject;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class ArrayBlockingQueueTest {

	public String makeSound() {
		return "moo";
	}
	public static void main (String[] args) {
		CustomArrayBlockingQueue<Integer> queue = new CustomArrayBlockingQueue<>(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		List<Double> list = new ArrayList<>();
		list.add(1D);
		list.add(2D);
		list.add(3D);
		double valueSum = 0;
		Map<String, List<Double>> idVsValuesMap = new HashMap<>();
		idVsValuesMap.put("1", list);
		for (Map.Entry<String, List<Double>> entry : idVsValuesMap.entrySet()) {
			System.out.println("id " + entry.getKey() +  "value " + entry.getValue());
			OptionalDouble average = entry.getValue().stream().parallel()
							.mapToDouble(doubleVal -> doubleVal).average();
			if (average.isPresent()) {
				System.out.println("avg" + average);
				valueSum += average.getAsDouble();
			}
		}
		System.out.println("val sum " + valueSum);
		System.out.println(list.toString());
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
