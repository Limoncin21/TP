package commands;

import main.Engine;

public abstract class Command {
	/**
	 * metodo abstracto
	 * @param engine engine
	 * @return si se ha ejecutado correctamente
	 */
	abstract public boolean execute(Engine engine);
	
	/**
	 * comprueba la cadena de string
	 * @param s cadena de string
	 * @return command
	 */
	abstract public Command parse(String[] s);
	
	/**
	 * texto de ayuda
	 * @return string
	 */
	abstract public String textHelp();
}
