package bytecodes;

import cpu.CPU;

public class Out extends ByteCode {

	/**
	 * ejecuta Out
	 */
	@Override
	public boolean execute(CPU cpu) {
		cpu.next();
		return cpu.out();
	}

	/**
	 * Comprueba si es OUT
	 */
	@Override
	public ByteCode parse(String[] s) {
		if (s[0] == "OUT") {
			return new Out();
		} else
			return null;
	}

	/**
	 * Devuelve OUT
	 */
	public String toString() {
		return new String("OUT");
	}

}
