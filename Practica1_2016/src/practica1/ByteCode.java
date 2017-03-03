package practica1;

public class ByteCode {
	private ENUM_BYTECODE name;
	private int param;// necesario para Push, Load y Store
	
	/**
	 * Constructor
	 * @param nom nombre del bytecode
	 * @param p entero que indica el parametro
	 */
	public ByteCode(ENUM_BYTECODE nom, int p){
		name = nom;
		param = p;
	}
	/**
	 * Constructor con solo el bytecode
	 * @param nom nombre del bytecode
	 */
	public ByteCode(ENUM_BYTECODE nom){
		name = nom;
		param = -1;
	}
	/**
	 * devuelve el parametro
	 * @return parametro
	 */
	public int getParam(){
		return param;
	}
	/**
	 * Pasa a string la instrucción
	 */
	public String toString(){
		String cadena = "";
		if(param == -1){
			cadena += name.toString();
		}else{
			cadena += name.toString() + " " + param;
		}
			
		return cadena;
	}
	/**
	 * Devuelve la instrucción completa
	 * @return string instruccion completa
	 */
	public String toStringName(){
		String cadena = "";
		cadena = name.toString();
		return cadena;
	}
}
