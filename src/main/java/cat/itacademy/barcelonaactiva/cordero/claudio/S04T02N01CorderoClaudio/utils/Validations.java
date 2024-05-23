package cat.itacademy.barcelonaactiva.cordero.claudio.S04T02N01CorderoClaudio.utils;

public class Validations {
	
	public static boolean isValidName(String name) {
		return name.matches("^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+$");
	}
	
}
