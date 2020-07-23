package customExceptions;

public class Main {
	public static void main(String[] args) throws CustomException {

		throw new CustomException("500", "something went wrong");
	}
}
