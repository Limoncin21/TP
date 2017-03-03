package cpu;

import main.ByteCodeProgram;
import bytecodes.ByteCode;

public class CPU {
	private Memory mem;
	private OperandStack pila;
	private boolean parada;
	private int programCounter;
	private ByteCodeProgram bcProgram;

	/**
	 * Constructor
	 */
	public CPU(ByteCodeProgram program) {
		bcProgram = program;
		programCounter = 0;
		mem = new Memory();
		pila = new OperandStack();
		parada = false;
	}

	/**
	 * resetea cpu
	 */
	public void reset() {
		mem.reset();
		pila.reset();
		parada = false;
		programCounter = 0;
	}

	/**
	 * ejecuta la cpu
	 * 
	 * @return true
	 */
	public boolean run() {
		boolean ok = true;
		while (!parada && programCounter < bcProgram.getMarco() && ok) {
			ByteCode byteCode = bcProgram.devolverInstruccion(programCounter);
			if(byteCode != null){
			ok = byteCode.execute(this);
			}else{
				ok = false;
			}
		}
		return ok;
	}

	/**
	 * cambia el boolean parada
	 * 
	 * @return true
	 */
	public boolean halt() {
		parada = !parada;
		return true;
	}

	/**
	 * lee el ultimo elemento
	 * 
	 * @return true
	 */
	public boolean out() {
		boolean ok = false;
		//int top = pila.sacarElemento();
		int top = pila.leerUltElemt();
		if (!pila.isEmpty()) {
			System.out.println("Operand stack's top is: " + top);
			ok = true;
		}
		return ok;
	}

	/**
	 * Añades la instruccion de bcProgram al byteCode para usarla en el run de
	 * cpu
	 * 
	 * @param bc
	 *            bytecode
	 * @param pos
	 *            posicion
	 * @return true si hay bytecode false si no
	 */
	public boolean añadirInstruccion(ByteCode bc, int pos) {
		bc = bcProgram.devolverInstruccion(pos);
		if (bc != null)
			return true;
		else
			return false;
	}

	/**
	 * mete elemento en la pila
	 * 
	 * @param n
	 *            numero
	 * @return si se ha podido meter o no el elemento
	 */
	public boolean push(int n) {
		return pila.meterElemento(n);
	}

	/**
	 * saca el ultimo elemento de la pila eliminandolo
	 * 
	 * @return si se ha podido sacar o no
	 */
	public int pop() {
		return pila.sacarElemento();
	}

	/**
	 * lee el ultimo elemento de la pila
	 * 
	 * @return si se ha podido leer o no
	 */
	public int readPila() {
		return pila.leerUltElemt();
	}

	/**
	 * lee de memoria
	 * 
	 * @param n
	 *            numero
	 * @return si se ha podido leer o no
	 */
	public int readMem(int n) {
		return mem.read(n);
	}
	public boolean load (int pos){
		boolean ok = false;
		int n = readMem(pos);
		if (!mem.isEmpty(pos)){
			ok = push(n);
		}
		return ok;
	}
	/**
	 * salta el contador del programa a la instruccion N del goto
	 * 
	 * @param n
	 *            numero
	 * @return si se ha podido hacer el salto
	 */
	public boolean jump(int n) {
		if (n < bcProgram.getMarco()) {
			programCounter = n;
			return true;
		} else
			return false;
	}

	/**
	 * Suma 1 al contador
	 */
	public void next() {
		programCounter++;
	}

	/**
	 * pila vacia
	 * 
	 * @return si esta vacia true
	 */
	public boolean emptyStack() {
		return pila.isEmpty();
	}

	/**
	 * Escribe en la pos de mem un valor
	 * 
	 * @param pos
	 *            posicion
	 * @param value
	 *            valor
	 * @return si se ha podido escribir
	 */
	public boolean write(int pos) {
		boolean ok = false;
		if (!pila.isEmpty()){
			ok = mem.write(pos, pop());
		}
		return ok;
	}

	/**
	 * devuelve estado de la cpu la mem y la pila
	 */
	public String toString() {
		String estado = "Estado de la CPU: "
				+ System.getProperty("line.separator");
		estado += "Memoria: " + mem.toString();
		estado += "Pila: " + pila.toString();
		estado += System.getProperty("line.separator");
		return estado;
	}

}
