package practica1;

public class Command {
	private ENUM_COMANDO command;//comando ejecutar
	private ByteCode instruction;//toma valor cuando se hace referencua al comando  NEWINST
	private int replace;//hace referencia al comando REPLACE
	
	/**
	 * Constructor
	 * @param c comando
	 * @param i byteCode
	 */
	public Command(ENUM_COMANDO c, ByteCode i){
		command = c;
		instruction = i;
	}
	/**
	 * Constructor
	 * @param c comando
	 * @param r posición
	 */
	public Command(ENUM_COMANDO c, int r){
		command = c;
		replace = r;
	}
	/**
	 * Ejecuta el comando
	 * @param engine engine
	 * @return boolean a false si no es ningún comando sino true
	 */
	public boolean execute (Engine engine){
		boolean ok = false;
		if (command == command.HELP){
			ok = engine.executeHELP();
		}else if(command == command.QUIT){
			ok = engine.executeQUIT();
		}else if(command == command.NEWINST){
			ok = engine.executeNEWINST(instruction);
		}else if(command == command.RUN){
			ok = engine.executeRUN();
		}else if(command == command.REPLACE){
			ok = engine.executeREPLACE(replace);
		}else if(command == command.RESET){
			ok = engine.executeRESET();
		}
		return ok;
	}
	/**
	 * Devuelve un string
	 */
	public String toString() {
		String cadena = "";
			cadena = command.toString();
		return cadena;
	}
	
}
