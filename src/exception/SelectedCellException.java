package exception;

public class SelectedCellException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public SelectedCellException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
