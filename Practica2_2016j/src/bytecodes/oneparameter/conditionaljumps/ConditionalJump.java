package bytecodes.oneparameter.conditionaljumps;

import bytecodes.ByteCode;
import cpu.CPU;

public abstract class ConditionalJump extends ByteCode {
	protected int n;

	/**
	 * const
	 * 
	 * @param n
	 *            numero
	 */
	public ConditionalJump(int n) {
		this.n = n;
	}

	/**
	 * ejecuta el salto condicional si se puede
	 */
	@Override
	public boolean execute(CPU cpu) {
		boolean ok = false;
		int cima, subCima;
		if (!cpu.emptyStack()) {
			cima = cpu.pop();
			if (!cpu.emptyStack()) {
				subCima = cpu.pop();
				if (!compares(cima, subCima, cpu)) {
					ok = cpu.jump(n);
				} else {
					cpu.next();
					ok = true;
				}

			} else {
				cpu.push(cima);
			}
		}
		return ok;
	}

	/**
	 * metodo abstracto
	 * 
	 * @param c
	 *            cima
	 * @param sc
	 *            subcima
	 * @param cpu
	 *            cpu
	 * @return si se ha podido hacer
	 */
	protected abstract boolean compares(int c, int sc, CPU cpu);
}
