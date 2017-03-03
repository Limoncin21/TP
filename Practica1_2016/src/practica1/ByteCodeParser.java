package practica1;

public class ByteCodeParser {
	/**
	 * Constructor vacio
	 */
	public ByteCodeParser(){
		
	}
	/**
	 * Se encarga de parsear y crear su respectiva instrucción
	 * @param line instrucción a analizar
	 * @return el bytecode adecuado
	 */
	public static ByteCode parse(String line){
		ByteCode enumerado =  null;
		String[] cadena = line.split(" ");
		if (cadena[1].equals("PUSH") && cadena.length == 3){
			enumerado = new ByteCode(ENUM_BYTECODE.PUSH, Integer.parseInt(cadena[2]));
		}else if(cadena[1].equals("LOAD") && cadena.length == 3){
			enumerado =  new ByteCode(ENUM_BYTECODE.LOAD, Integer.parseInt(cadena[2]));
		}else if(cadena[1].equals("STORE") && cadena.length == 3){
			enumerado =  new ByteCode(ENUM_BYTECODE.STORE, Integer.parseInt(cadena[2]));
		}else if(cadena[1].equals("ADD") && cadena.length == 2){
			enumerado =  new ByteCode(ENUM_BYTECODE.ADD);
		}else if(cadena[1].equals("SUB") && cadena.length == 2){
			enumerado =  new ByteCode(ENUM_BYTECODE.SUB);
		}else if(cadena[1].equals("MUL") && cadena.length == 2){
			enumerado =  new ByteCode(ENUM_BYTECODE.MUL);
		}else if(cadena[1].equals("DIV") && cadena.length == 2){
			enumerado = new ByteCode(ENUM_BYTECODE.DIV);
		}else if(cadena[1].equals("OUT")&& cadena.length == 2 ){
			enumerado =  new ByteCode(ENUM_BYTECODE.OUT);
		}else if(cadena[1].equals("HALT") && cadena.length == 2){
			enumerado =  new ByteCode(ENUM_BYTECODE.HALT);
		}
		return enumerado;
		
	}
}
