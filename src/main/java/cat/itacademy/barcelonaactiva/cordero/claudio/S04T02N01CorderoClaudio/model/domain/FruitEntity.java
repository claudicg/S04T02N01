package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.model.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(schema = "fruitsdb", name = "FRUITS")
public class FruitEntity {

	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "kilograms")
	private int kilograms;
	
	
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
		return "FruitEntity [name=" + name + ", kilograms=" + kilograms + "]";
	}	
}
