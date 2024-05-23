package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.DTO;

public class FruitResponse {

	private FruitDTO fruit;
	private String message;
	private String error;
	

	public FruitResponse() {
		super();
	}
	
	public FruitResponse(FruitDTO fruit, String message, String error) {
		super();
		this.fruit = fruit;
		this.message = message;
		this.error = error;
	}
	
	
	public FruitDTO getFruit() {
		return fruit;
	}
	public void setFruit(FruitDTO fruit) {
		this.fruit = fruit;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	public String ok() {
		
		return "";
	}
	@Override
	public String toString() {
		return "FruitResponse [fruit=" + fruit + ", message=" + message + ", error=" + error + "]";
	}
}
