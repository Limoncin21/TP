package commands;

import main.Engine;

public class Quit extends Command {

	/**
	 * ejecuta quit
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.endExecution();
	}

	/**
	 * comprueba comando quit lo crea sino null
	 */
	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase("QUIT"))
			return new Quit();
		else
		return null;
	}

	/**
	 * muestra ayuda quit
	 */
	@Override
	public String textHelp() {
		return "QUIT: Cierra el programa actual";
	}
	
	/**
	 * devuelve quit
	 */
	public String toString(){
		return new String ("QUIT");
	}
}
