package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

public class Mul extends Arithmetics {

	/**
	 * Comprueba que sea la operacion mul y si es asi la crea
	 */
	@Override
	protected ByteCode parseOperacion(String s) {
		if (s.equals("MUL"))
			return new Mul();
		else
			return null;
	}

	/**
	 * operacion de la multiplicacion
	 */
	@Override
	protected boolean operacion(int c, int sc, CPU cpu) {
		int mul = sc * c;
		return cpu.push(mul);
	}

	/**
	 * devuelve MUL
	 */
	public String toString() {
		return new String("MUL");
	}
}
