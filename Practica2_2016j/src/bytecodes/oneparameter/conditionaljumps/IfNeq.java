package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;
import cpu.CPU;

public class IfNeq extends ConditionalJump {

	/**
	 * const
	 * 
	 * @param n
	 *            numero
	 */
	public IfNeq(int n) {
		super(n);
	}

	/**
	 * comprueba que la subcima sea distinta de la cima
	 */
	@Override
	protected boolean compares(int c, int sc, CPU cpu) {
		return (sc != c);
	}

	/**
	 * comprueba que sea ifneq y la crea sino null
	 */
	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equals("IFNEQ"))
			return new IfNeq(Integer.parseInt(s[1]));
		else
			return null;
	}

	/**
	 * devuelve ifneq n
	 */
	public String toString() {
		return new String("IFNEQ " + n);
	}
}
