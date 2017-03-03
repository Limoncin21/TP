package commands;

import main.Engine;

public class AddProgram extends Command {

	/**
	 * ejecuta lectura de bytecode
	 */
	@Override
	public boolean execute(Engine engine) {
		return engine.readByteCodePrgram();
	}

	/**
	 * comprueba que sea una inst de bytecode correcta
	 */
	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("BYTECODE"))
			return new AddProgram();
		else 
		return null;
	}

	/**
	 * texto de ayuda
	 */
	@Override
	public String textHelp() {
		return "BYTECODE: Añade una nueva instruccion" + System.getProperty("line.separator");
	}
	
	/**
	 * devuelve bytecode
	 */
	public String toString(){
		return "BYTECODE";
	}
}
