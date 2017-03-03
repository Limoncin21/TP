package practica1;

public class ByteCodeProgram {
	private ByteCode[] program;// array byteCode
	private int marco;
	public static int MAX_INSTR = 20;

	/**
	 * Constructor
	 * Inicializa el progrma y pone el marco a 0
	 */
	public ByteCodeProgram() {
		inicializarProgram();
		marco = 0;
	}

	/**
	 * Crea el array de byteCode's
	 */
	public void inicializarProgram() {
		program = new ByteCode[MAX_INSTR];
	}
	/**
	 * Vacía el array de byteCode's y pone el marco a 0
	 */
	public void vaciarArray(){
		for(int i = 0; i < marco; i++){
			program[i] = null;
		}
		marco = 0;
	}
	/**
	 * Añade un nuevo byteCode y aumenta el marco
	 * @param byteCode el byteCode
	 */
	public void añadirByteCode(ByteCode byteCode) {
		if(marco >= MAX_INSTR){
				System.out.print(" --> Program full!! You can't add this instruction: ");
		}else{
			program[marco] = byteCode;
			marco++;
		}
	}
	/**
	 * Si el array no esta completo se añade una instrucción en la posicion n
	 * @param byteCode instrucción
	 * @param n posición
	 */
	
	public void colocarInstruccion(ByteCode byteCode, int n) {
		if (n < MAX_INSTR)
			program[n] = byteCode;
	}

	/**
	 * Devuelva la instrucción de la posición n
	 * @param n posición
	 * @return byteCode
	 */
	public ByteCode devolverInstruccion(int n) {
		ByteCode byteCode = program[n];
		return byteCode;
	}
	/**
	 * Devuelve el marco
	 * @return marco
	 */
	public int getMarco(){
		return this.marco;
	}
	/**
	 * Devuelve todos las instrucciones de program(array de byteCode's)
	 */
	public String toString() {
		String cadena = "";
		for (int i = 0; i < marco; i++) {
			cadena += i + ": " +program[i].toString() + "\n";
		}
		return cadena;
	}
	/**
	 * 
	 * @param n
	 * @return
	 */
	public String toString1(int n) {
		String cadena = "";
		if (n == -1)
			cadena = program[marco-1].toString() + " ";
		else
			cadena = program[n].toString() + " ";
		return cadena;
	}
}
