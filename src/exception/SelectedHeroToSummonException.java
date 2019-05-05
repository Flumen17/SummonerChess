package exception;

public class SelectedHeroToSummonException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public SelectedHeroToSummonException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}
