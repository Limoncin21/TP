package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class Push extends ByteCodesOneParameter{
	private int n;
	
	/**
	 * const
	 * @param n numero
	 */
	public Push(int n){
		this.n = n;
	}
	
	/**
	 * comprueba que sea la inst push y la crea sino null
	 */
	@Override
	protected ByteCode parseOneParameter(String[] s) {
		if (s[0].equals("PUSH")){
			n = Integer.parseInt(s[1]);
			return new Push(n);
		}else
			return null;
	}
	
	/**
	 * ejecuta push
	 */
	public boolean execute (CPU cpu){
		cpu.next();
		return cpu.push(n);
	}
	
	/**
	 * devuelve push n
	 */
	public String toString(){
		return new String ("PUSH " + n);
	}
}
