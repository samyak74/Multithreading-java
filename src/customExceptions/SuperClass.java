package customExceptions;

import java.io.IOException;

public class SuperClass {
	 void testMethod() throws RuntimeException {
		System.out.println("method in super");
		throw new IllegalArgumentException("");
	}
}
