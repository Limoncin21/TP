package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public abstract class ByteCodesOneParameter extends ByteCode{
	
	/**
	 * metodo abstracto
	 * @param s cadena de strings
	 * @return bytecode
	 */
	protected abstract ByteCode parseOneParameter(String[]s);
	
	/**
	 * ejecuta la cpu
	 */
	@Override
	public boolean execute(CPU cpu) {
		boolean ok;
		ok = this.execute(cpu);
		return ok;
	}

	/**
	 * comprueba que tenga una long de dos
	 */
	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 2)
			return this.parseOneParameter(s);
		else
			return null;
	}
}
