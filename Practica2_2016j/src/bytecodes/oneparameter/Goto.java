package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class Goto extends ByteCodesOneParameter{
	private int n;
	
	/**
	 * contsructor
	 * @param n numero
	 */
	public Goto (int n){
		this.n = n;
	}
	
	/**
	 * comprueba que sea la inst goto y la crea sino null
	 */
	@Override
	protected ByteCode parseOneParameter(String[] s) {
		if (s[0].equals("GOTO")){
			n = Integer.parseInt(s[1]);
			return new Goto(n);
		}else
			return null;
	}
	
	/**
	 * ejecuta salto a n
	 */
	public boolean execute (CPU cpu){
		return cpu.jump(n);
	
	}
	
	/**
	 * devuelve GOTO a N
	 */
	public String toString(){
		return new String ("GOTO " + n);
	}
}
