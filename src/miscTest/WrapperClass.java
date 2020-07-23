
package miscTest;



public class WrapperClass {
	private static void print(Object o) {
		System.out.println(o+"\n");
	}

	public static void main(String[] args) {
		Geo g = new Geo();
		Long l2 = 2L;
		long l3 = l2;
		Long l4 = null;
		long l5 = 5L;
		print(g.getLat());

		int i = 1;
		Integer i1 = 1;
		print(i);

		double d = 1;
		Double d1 = 1.0;
		//print(d);

		float f = 1;
		Float f1 = 1.0F;
		//print(f1);

		boolean b = false;
		Boolean b1 = null;
		//print(b1);


	}
}
