package miscTest;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ObjectsTesting {
	private static final long TIME_OFFSET = 1000L;
	public static Long getNumberOfRequests1(Queue<Long> timeStamps) {
		//TODO improvement in this logic
		Long endTime = System.currentTimeMillis() - TIME_OFFSET;
		long requests = 0;
		while (timeStamps.size() > 0 && timeStamps.peek() > endTime) {
			timeStamps.remove();
			requests++;
		}
		return requests;
	}

	public static Long getNumberOfRequests(Queue<Long> timeStamps) {
		//TODO improvement in this logic
		Long endTime = System.currentTimeMillis() - TIME_OFFSET;
		System.out.println("end time " + endTime);
		long requests = 0;
		while (timeStamps.size() > 0) {
		//	System.out.println("in while " + timeStamps.peek());
			if (timeStamps.peek() > endTime) {
				System.out.println("in if " + timeStamps.peek());
				requests++;
			}
			try {
				timeStamps.remove();
			} catch (NoSuchElementException e) {
			}
		}
		return requests;
	}

	public static void main(String[] args) throws InterruptedException {
		Geo geo = new Geo();
		geo.setLat(2.2);
		geo.setLon(1.2);
		geo.setP(new Product("a","b",3.0));
		Geo geo1 = new Geo(new Product("a","b",3.0),2.2,1.2);

		/*boolean equals1 = Objects.equals(geo, geo1);
		boolean equals = geo.equals(geo1);
		boolean equals2 = Objects.deepEquals(geo, geo1);
		System.out.println(equals + " " + equals1+ " " + equals2);
		System.out.println(geo.toString() + "\n" + geo1.toString());*/

		Queue<Long> timestamps = new ArrayDeque<>();
		System.out.println("first " + System.currentTimeMillis());
		timestamps.add(System.currentTimeMillis());
		Thread.sleep(1001);
		System.out.println("second "+ System.currentTimeMillis());
		timestamps.add(System.currentTimeMillis());
		Long numberOfRequests = getNumberOfRequests(timestamps);
		System.out.println(numberOfRequests);


	}
}
