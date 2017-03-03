package practica1;

public enum ENUM_BYTECODE {
	PUSH("PUSH"), LOAD("LOAD"), STORE("STORE"), ADD("ADD"), SUB("SUB"), MUL("MUL"), DIV("DIV"), OUT("OUT"), HALT(
			"HALT");

	private String cadena;

	/**
	 * Constructor
	 * @param cad byteCode
	 */
	private ENUM_BYTECODE(String cad) {
		cadena = cad;
	}

	/**
	 * Devuelve la cadena
	 */
	public String toString() {
		return cadena;
	}
}
