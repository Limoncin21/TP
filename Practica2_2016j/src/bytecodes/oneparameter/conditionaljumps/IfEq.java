package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;
import cpu.CPU;

public class IfEq extends ConditionalJump {
	/**
	 * const
	 * 
	 * @param n
	 *            numero
	 */
	public IfEq(int n) {
		super(n);
	}

	/**
	 * comprueba que sea ifeq y la crea sino null
	 */
	public ByteCode parse(String[] s) {
		if (s[0].equals("IFEQ"))
			return new IfEq(Integer.parseInt(s[1]));
		else
			return null;
	}

	/**
	 * comprueba que la cima y la subcima sean iguales
	 */
	@Override
	protected boolean compares(int c, int sc, CPU cpu) {
		return (sc == c);
	}

	/**
	 * devuelve ifeq n
	 */
	public String toString() {
		return new String("IFEQ " + n);

	}

}
