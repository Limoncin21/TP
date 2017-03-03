package commands;

import main.Engine;

public class Run extends Command {

	/**
	 * ejecuta run
	 */
	@Override
	public boolean execute(Engine engine) {
		// TODO Auto-generated method stub
		return engine.executeRUN();
	}

	/**
	 * comprueba comando run lo crea sino null
	 */
	@Override
	public Command parse(String[] s) {
		if (s.length == 1 && s[0].equalsIgnoreCase("RUN"))
			return new Run();
		else 
		return null;
	}

	/**
	 * muestra ayuda run
	 */
	@Override
	public String textHelp() {
		return "RUN: Ejecuta el programa actual ";
	}
	
	/**
	 * devuelve string run
	 */
	public String toString(){
		return new String ("RUN");
	}
}
