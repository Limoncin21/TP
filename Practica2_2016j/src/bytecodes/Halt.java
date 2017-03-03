package bytecodes;

import cpu.CPU;

public class Halt extends ByteCode {

	/**
	 * ejecuta halt
	 */
	@Override
	public boolean execute(CPU cpu) {
		cpu.next();
		return cpu.halt();
	}

	/**
	 * comprueba si es halt
	 */
	@Override
	public ByteCode parse(String[] s) {
		if (s[0] == "HALT") {
			return new Halt();
		} else
			return null;
	}

	/**
	 * devuelve HALT
	 */
	public String toString() {
		return new String("HALT");
	}
}
