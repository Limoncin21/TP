package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class Load extends ByteCodesOneParameter {
	private int n;
	
	/**
	 * constructor
	 * @param n numero
	 */
	public Load(int n) {
		this.n = n;
	}

	/**
	 * comprueba que sea la inst load y la crea sino null
	 */
	@Override
	protected ByteCode parseOneParameter(String[] s) {
		if (s[0].equals("LOAD")){
			n = Integer.parseInt(s[1]);
			return new Load(n);
		}else
			return null;
	}

	/**
	 * ejecuta load
	 */
	public boolean execute(CPU cpu) {
		cpu.next();
		return cpu.load(n);
	}

	/**
	 * devuelve load n
	 */
	public String toString() {
		return new String ("LOAD " + n);
	}
}
