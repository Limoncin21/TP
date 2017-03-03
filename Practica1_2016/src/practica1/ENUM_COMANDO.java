package practica1;

public enum ENUM_COMANDO {
HELP("HELP"), QUIT("QUIT"), NEWINST("NEWINST"), RUN("RUN"), RESET("RESET"), REPLACE("REPLACE");
	
	private String cadena;
	/**
	 * Devuelve la cadena
	 * @param cad str4ing cadena
	 */
	private ENUM_COMANDO(String cad) {
		cadena = cad;
	}

	/**
	 * devuelve cadena
	 */
	public String toString() {
		return cadena;
	}
}
