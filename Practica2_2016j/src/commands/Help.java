package commands;

import main.Engine;

public class Help extends Command {

	/**
	 * ejecuta ayuda
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.showHelp();
	}

	/**
	 * comprueba comando help lo crea sino null
	 */
	@Override
	public Command parse(String[] s) {
		if(s.length == 1 && s[0].equalsIgnoreCase("HELP"))
			return new Help();
		else
		return null;
	}

	/**
	 * muestra ayuda help
	 */
	@Override
	public String textHelp() {
		return "HELP: Muestra la lista de comandos";
	}
	
	/**
	 * devuelve help
	 */
	public String toString(){
		return new String ("HELP");
	}
}
