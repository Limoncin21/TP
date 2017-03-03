package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

public class Sub extends Arithmetics {

	/**
	 * Comprueba que sea sub y si es asim lo crea
	 */
	@Override
	protected ByteCode parseOperacion(String s) {
		if (s.equals("SUB"))
			return new Sub();
		else
			return null;
	}

	/**
	 * operacion de resta
	 */
	@Override
	protected boolean operacion(int c, int sc, CPU cpu) {
		int sub = sc - c;
		return cpu.push(sub);
	}

	/**
	 * devuelve SUB
	 */
	public String toString() {
		return new String("SUB");
	}
}
