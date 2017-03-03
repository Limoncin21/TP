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
	 * Vac�a el array de byteCode's y pone el marco a 0
	 */
	public void vaciarArray(){
		for(int i = 0; i < marco; i++){
			program[i] = null;
		}
		marco = 0;
	}
	/**
	 * A�ade un nuevo byteCode y aumenta el marco
	 * @param byteCode el byteCode
	 */
	public void a�adirByteCode(ByteCode byteCode) {
		if(marco >= MAX_INSTR){
				System.out.print(" --> Program full!! You can't add this instruction: ");
		}else{
			program[marco] = byteCode;
			marco++;
		}
	}
	/**
	 * Si el array no esta completo se a�ade una instrucci�n en la posicion n
	 * @param byteCode instrucci�n
	 * @param n posici�n
	 */
	
	public void colocarInstruccion(ByteCode byteCode, int n) {
		if (n < MAX_INSTR)
			program[n] = byteCode;
	}

	/**
	 * Devuelva la instrucci�n de la posici�n n
	 * @param n posici�n
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
