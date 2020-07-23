package miscTest;

public class TestException {
	public static void main(String[] args) {
		int t = 5;
		while(t-- > 0) {
			double x = 5/(double) 0;

			System.out.println(x);
		}
	}
}
