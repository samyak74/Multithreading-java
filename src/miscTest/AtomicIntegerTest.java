package miscTest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicIntegerTest {
	public static void main(String[] args) {
		Map<String, AtomicLong> atomicLongMap = new ConcurrentHashMap<>();
		atomicLongMap.put("client", new AtomicLong());
		atomicLongMap.get("client").set(2);
	}
}
