package main;

import bytecodes.ByteCode;

public class ByteCodeProgram {
	private ByteCode[] program;// array byteCode
	private int marco;
	public static int MAX_INSTR = 20;

	/**
	 * Constructor Inicializa el progrma y pone el marco a 0
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
	public void vaciarArray() {
		for (int i = 0; i < marco; i++) {
			program[i] = null;
		}
		marco = 0;
	}

	/**
	 * Añade un nuevo byteCode y aumenta el marco
	 * 
	 * @param byteCode
	 *            el byteCode
	 */
	public void añadirByteCode(ByteCode byteCode) {
		if (marco == MAX_INSTR) {
			MAX_INSTR = marco + 10;
			this.redimensionar();
		}
		program[marco] = byteCode;
		marco++;
	}

	/**
	 * redimensiona con un medio del max de inst
	 */
	private void redimensionar() {
		int newDim = MAX_INSTR + MAX_INSTR / 2;
		ByteCode[] newProgram = new ByteCode[newDim];
		for (int i = 0; i < newDim; i++) {
			if (i < marco) {
				newProgram[i] = this.program[i];
			} else {
				newProgram[i] = null;
			}
		}
		this.program = newProgram;
		MAX_INSTR = newDim;
	}

	/**
	 * comprueba si se puede hacer replace
	 * 
	 * @param pos
	 *            posicion
	 * @param bytecode
	 *            bytecode
	 * @return se ha podido hacer replace correctamente (en caso afirmatiovo lo
	 *         reemplaza)
	 */
	public boolean replace(int pos, ByteCode bytecode) {
		boolean ok = false;
		if (pos >= 0 && pos < marco && bytecode != null) {
			program[pos] = bytecode;
			ok = true;
		}
		return ok;
	}

	/**
	 * Devuelva la instrucción de la posición n
	 * 
	 * @param n
	 *            posición
	 * @return byteCode
	 */
	public ByteCode devolverInstruccion(int n) {
		if (n >= 0 && n < MAX_INSTR && program[n] != null) {
			ByteCode byteCode = program[n];
			return byteCode;
		} else {
			return null;
		}
	}

	/**
	 * Devuelve el marco
	 * 
	 * @return marco
	 */
	public int getMarco() {
		return this.marco;
	}

	/**
	 * Devuelve todos las instrucciones de program(array de byteCode's)
	 */
	public String toString() {
		String cadena = "Programa almacenado:" + System.getProperty("line.separator");
		for (int i = 0; i < marco; i++) {
			cadena += i + ": " + program[i].toString() + System.getProperty("line.separator");
		}
		return cadena;
	}
}
