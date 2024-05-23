package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.DTO;

public class FruitDTO {

	private String name;
	private int kilograms;
	
	public FruitDTO() {
		super();
	}

	public FruitDTO(String name, int kilograms) {
		super();
		this.name = name;
		this.kilograms = kilograms;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKilograms() {
		return kilograms;
	}

	public void setKilograms(int kilograms) {
		this.kilograms = kilograms;
	}

	@Override
	public String toString() {
		return "FruitDTO [name=" + name + ", kilograms=" + kilograms + "]";
	}	
}
