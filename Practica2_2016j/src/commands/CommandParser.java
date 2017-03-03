package commands;

public class CommandParser {
	/**
	 * los comandos creados
	 */
	private final static Command[] commands = { new Help(), new Quit(), new Reset(), new Replace(0), new Run(),
			new AddProgram() };

	/**
	 * muestra ayuda
	 */
	public static void showHelp() {
		System.out.println("POSIBLES COMANDOS: ");
		for (int i = 0; i < commands.length; i++) {
			System.out.println(commands[i].textHelp());
		}
	}

	/**
	 * parsea el comando
	 * @param line comando
	 * @return command
	 */
	public static Command parse(String line) {
		Command Command = null;
		String[] cadena;
		cadena = line.split(" ");
		if (cadena.length <= 2) {
			for (int i = 0; i < commands.length; i++) {
				Command = commands[i].parse(cadena);
				if (Command != null)
					return Command;
			}
		}
		return null;
	}
}
