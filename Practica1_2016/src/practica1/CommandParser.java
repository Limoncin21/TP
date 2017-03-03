package practica1;

public class CommandParser {
	ENUM_COMANDO enumerado;

	/**
	 * Parsea el comando para saber cual es
	 * @param line comando 
	 * @return comando
	 */
	public static Command parse(String line) {
		Command Command = null;
		String[] cadena = line.split(" ");
		if (cadena[0].equals("HELP") && cadena.length == 1) {
			Command = new Command(ENUM_COMANDO.HELP, null);
		} else if (cadena[0].equals("QUIT") && cadena.length == 1) {
			Command = new Command(ENUM_COMANDO.QUIT, null);
		} else if (cadena[0].equals("NEWINST") && (cadena.length == 3 || cadena.length == 2)) {
			ByteCode byteCode = ByteCodeParser.parse(line);
			if (byteCode != null) {
				Command = new Command(ENUM_COMANDO.NEWINST, byteCode);
			}
		} else if (cadena[0].equals("RUN") && cadena.length == 1) {
			Command = new Command(ENUM_COMANDO.RUN, null);
		} else if (cadena[0].equals("RESET") && cadena.length == 1) {
			Command = new Command(ENUM_COMANDO.RESET, null);
		} else if (cadena[0].equals("REPLACE") && cadena.length == 2) {
			Command = new Command(ENUM_COMANDO.REPLACE, Integer.parseInt(cadena[1]));
		}
		return Command;
	}
}
