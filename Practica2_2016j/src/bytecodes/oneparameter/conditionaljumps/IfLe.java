package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;
import cpu.CPU;

public class IfLe extends ConditionalJump {

	/**
	 * const
	 * 
	 * @param n
	 *            numero
	 */
	public IfLe(int n) {
		super(n);
	}

	/**
	 * comprueba que la cima sea mayor que la subcima
	 */
	@Override
	protected boolean compares(int c, int sc, CPU cpu) {
		return (sc < c);
	}

	/**
	 * comprueba que sea ifle y la crea sino null
	 */
	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equals("IFLE"))
			return new IfLe(Integer.parseInt(s[1]));
		else
			return null;
	}

	/**
	 * devuelve ifle n
	 */
	public String toString() {
		return new String("IFLE " + n);
	}
}
