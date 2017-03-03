package commands;

import main.Engine;

public class Reset extends Command {

	/**
	 * ejecuta reset
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.resetProgram();
	}

	/**
	 * comprueba comando reset lo crea sino null
	 */
	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RESET"))
			return new Reset();
		else 
		return null;
	}

	/**
	 * muestra ayuda reset
	 */
	@Override
	public String textHelp() {
		return "RESET: Vacia el programa actual";
	}
	
	/**
	 * devuelve reset
	 */
	public String toString(){
		return new String ("RESET");
	}

}
