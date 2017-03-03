package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

public class Add extends Arithmetics {

	/**
	 * operacion de suma
	 */
	protected boolean operacion(int c, int sc, CPU cpu) {
		int suma = sc + c;
		return cpu.push(suma);
	}

	/**
	 * Comprueba que sea add y la crea
	 */
	@Override
	protected ByteCode parseOperacion(String s) {
		if (s.equals("ADD"))
			return new Add();
		else
			return null;
	}

	/**
	 * devuelve ADD
	 */
	public String toString() {
		return new String("ADD");
	}
}
