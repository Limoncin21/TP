package bytecodes.oneparameter;

import bytecodes.ByteCode;
import cpu.CPU;

public class Store extends ByteCodesOneParameter{
	private int n;
	
	/**
	 * const
	 * @param n numero
	 */
	public Store(int n){
		this.n = n;
	}
	
	/**
	 * comprueba que sea la inst store y la crea sino null
	 */
	@Override
	protected ByteCode parseOneParameter(String[] s) {
		if (s[0].equals("STORE")){
			n = Integer.parseInt(s[1]);
			return new Store(n);
		}else
			return null;
	}
	
	/**
	 * ejecuta store
	 */
	public boolean execute (CPU cpu){
		cpu.next();
		return cpu.write(n);
	}
	
	/**
	 * devuelve store n
	 */
	public String toString(){
		return new String ("STORE " + n);
	}

}
