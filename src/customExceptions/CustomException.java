package customExceptions;

public class CustomException extends Exception {

	CustomException(String statusCode, String message) {
		super(statusCode + " " + message);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
