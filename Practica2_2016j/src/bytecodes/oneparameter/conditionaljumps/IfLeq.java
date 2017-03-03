package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;
import cpu.CPU;

public class IfLeq extends ConditionalJump {

	/**
	 * const
	 * 
	 * @param n
	 *            numero
	 */
	public IfLeq(int n) {
		super(n);
	}

	/**
	 * comprueba la subcima sea menor o igual que la cima
	 */
	@Override
	protected boolean compares(int c, int sc, CPU cpu) {
		return (sc <= c);
	}

	/**
	 * comprueba que sea ifleq y la crea sino null
	 */
	@Override
	public ByteCode parse(String[] s) {
		if (s[0].equals("IFLEQ"))
			return new IfLeq(Integer.parseInt(s[1]));
		else
			return null;
	}

	/**
	 * devuelve ifleq n
	 */
	public String toString() {
		return new String("IFLEQ " + n);
	}

}
