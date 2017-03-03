package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

public class Div extends Arithmetics {

	/**
	 * Comprueba que sea div y si es asi la crea
	 */
	@Override
	protected ByteCode parseOperacion(String s) {
		if (s.equals("DIV"))
			return new Div();
		else
			return null;
	}

	/**
	 * operacion de la division
	 */
	@Override
	protected boolean operacion(int c, int sc, CPU cpu) {
		if (c != 0) {
			int div = sc / c;
			return cpu.push(div);
		} else {
			return false;
		}

	}

	/**
	 * devuelve DIV
	 */
	public String toString() {
		return new String ("DIV");
	}
}
