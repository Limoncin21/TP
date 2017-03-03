package bytecodes.arithmetics;

import bytecodes.ByteCode;
import cpu.CPU;

public abstract class Arithmetics extends ByteCode {
	
	/**
	 * constructor vacío
	 */
	public Arithmetics() {
	}
	
	/**
	 * Metodo abstracto para ver que instruccion aritmetica es mediante el parse
	 * @param s string
	 * @return bytecode de arithmetics 
	 */
	protected abstract ByteCode parseOperacion(String s);

	/**
	 * Metodo abstracto que realizara la operacion que le corresponda
	 * @param c cima
	 * @param sc subcima
	 * @param cpu cpu
	 * @return true si se ha realizado la operacion
	 */
	protected abstract boolean operacion(int c, int sc, CPU cpu);

	/**
	 * Ejecuta la operación arithmetic adecuada
	 */
	@Override
	public boolean execute(CPU cpu) {
		boolean ok = false;
		int cima, subCima;
		if (!cpu.emptyStack()){
			cima = cpu.pop();
			if (!cpu.emptyStack()){
				subCima = cpu.pop();
				cpu.next();
				ok = this.operacion(cima, subCima, cpu);
			}else{
				cpu.push(cima);
			}
		}
		return ok;
	}

	/**
	 * compreuba que sea una inst aritmetica es decir que su long sea uno
	 */
	@Override
	public ByteCode parse(String[] s) {
		if (s.length == 1)
			return this.parseOperacion(s[0]);
		else
			return null;
	}

}
