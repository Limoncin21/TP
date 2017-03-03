package commands;

import main.Engine;

public class Replace extends Command {
	private int n;
	
	/**
	 * const
	 * @param n numero
	 */
	public Replace(int n){
		this.n = n;
	}
	
	/**
	 * ejecuta replace
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.executeREPLACE(this.n);
	}

	/**
	 * comprueba comando replace lo crea sino null
	 */
	@Override
	public Command parse(String[] s) {
		if(s.length == 2 && s[0].equalsIgnoreCase("REPLACE")){
			this.n = Integer.parseInt(s[1]);
			return new Replace(this.n);
		}else
		return null;
	}

	/**
	 * muestra ayuda replace
	 */
	@Override
	public String textHelp() {
		return "REPLACE: Sustituye una instruccion ";
	}
	
	/**
	 * devuelve replace n
	 */
	public String toString(){
		return new String ("REPLACE " + n);
	}

}
