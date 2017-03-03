package practica1;

import java.util.Scanner;

public class Engine {
	private ByteCodeProgram program;// representa el programa actual
	private boolean end;// controla el final del bucle de ejecuccion
	private static Scanner in;// entrada por teclado

	/**
	 * Constructor
	 * @param in scanner
	 */
	@SuppressWarnings("static-access")
	public Engine(Scanner in) {
		this.in = in;
		this.program = new ByteCodeProgram();
		this.end = false;
	}

	/**
	 * Comienza con la ejecucion del programa
	 */
	public void start() {
		while (!end) {
			Command command;
			command = CommandParser.parse(pedirComandos());
			if (command == null) {
				System.out.println("Error: Ejecucion incorrecta del comando");
			} else {
				System.out.print("Comienza la ejecucion de " + command.toString());
				boolean ex;
				ex = command.execute(this);
				if (!ex) {
					System.out.println("Error: Ejecucion incorrecta del comando");
				} else {

				}
			}
		}
		System.out.println("Fin de la ejecucion...");
	}

	/**
	 * Pide la instrucción al completo
	 * @return la instrucción
	 */
	private String pedirComandos() {
		System.out.print(">");
		String line = in.nextLine();
		String palabrasMayus;
		palabrasMayus = line.toUpperCase();
		return palabrasMayus;
	}

	/**
	 * Muestra el programa almacenado
	 */
	private void mostrarProgramaAlmacenado() {
		System.out.println("Programa almacenado: ");
		System.out.println(program.toString());
	}

	/**
	 * Ejecuta help
	 * @return true
	 */
	public boolean executeHELP() {
		boolean ok = false;
		if (showHelp()) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Ejecuta quit
	 * @return true
	 */
	public boolean executeQUIT() {
		boolean ok = false;
		if (endExecution()) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Ejecuta el run
	 * @return true si se ha iniciado el run
	 */
	public boolean executeRUN() {
		boolean ok = false;
		if (startExecution()) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Ejecuta el reset
	 * @return true
	 */
	public boolean executeRESET() {
		boolean ok = false;
		if (resetProgram()) {
			ok = true;
		}
		return ok;
	}

	/**
	 * Ejecuta el replace
	 * @param replace posicion a reemplazar
	 * @return true si se ha reemplazado
	 */
	public boolean executeREPLACE(int replace) {
		System.out.println();
		boolean ok = false;
		if (replace <= program.getMarco()) {
			if (replaceBCInstruction(replace)) {
				ok = true;
			}
		}
		return ok;
	}

	/**
	 * Ejecuta una nueva instrucción
	 * @param instr byteCode
	 * @return true si se ha podido ejecutar una nueva instrucción
	 */
	public boolean executeNEWINST(ByteCode instr) {
		boolean ok = false;
		if (addByteCodeInstruction(instr)) {
			ok = true;
			int i = -1;
			System.out.println(" " + program.toString1(i));
		}
		mostrarProgramaAlmacenado();
		return ok;
	}

	/**
	 * Añade un nuevo byteCode
	 * @param instr ByteCode
	 * @return true
	 */
	public boolean addByteCodeInstruction(ByteCode instr) {
		program.añadirByteCode(instr);
		return true;
	}

	/**
	 * Empieza la ejecución de la CPU
	 * @return true
	 */
	public boolean startExecution() {
		CPU cpu = new CPU();
		boolean parada = false;
		System.out.println();
		for (int i = 0; i < program.getMarco(); i++) {
			if (!parada) {
				System.out.println("El estado de la maquina tras ejecutar el bytecode " + program.toString1(i) + "es: \n");
				parada = cpu.execute(program.devolverInstruccion(i));
			}
		}
		mostrarProgramaAlmacenado();
		return true;
	}

	/**
	 * Reinicia el programa
	 * @return true
	 */
	public boolean resetProgram() {
		program.vaciarArray();
		System.out.println();
		return true;
	}

	/**
	 * Reemplaza si es posible una instrucción que este ne la posición replace por otra
	 * @param replace posición
	 * @return true si se han intercambiado las instrucciones
	 */
	public boolean replaceBCInstruction(int replace) {
		boolean valido = false;
		if (replace <= program.getMarco()) {
			System.out.print("Nueva instruccion : ");
			String line = in.nextLine();
			String palabrasMayus;
			palabrasMayus = line.toUpperCase();
			palabrasMayus = "NEWINST " + palabrasMayus;
			ByteCode byteCode = ByteCodeParser.parse(palabrasMayus);
			if (byteCode != null) {
				program.colocarInstruccion(byteCode, replace);
				mostrarProgramaAlmacenado();
				valido = true;
			} else {
				System.out.println("Error: Ejecucion incorrecta del comando");
			}
		} else {
			System.out.println(" " + replace);
			System.out.println("Error: Ejecucion incorrecta del comando");
		}
		return valido;
	}

	/**
	 * Muestra el menú de ayuda
	 * @return true
	 */
	public boolean showHelp() {
		System.out.println("HELP: Muestra esta ayuda");
		System.out.println("QUIT: Cierra la aplicacion");
		System.out.println("RUN: Ejecuta eel programa");
		System.out.println("NEWINST BYTECODE: Introduce una nueva instruccion al programa");
		System.out.println("RESET: Vacia el programa actual");
		System.out.println("REPLACE N: Reemplaza la instruccion N por la solicitada al usurario");
		return true;
	}

	/**
	 * Termina la ejecución
	 * @return true;
	 */
	public boolean endExecution() {
		end = true;
		return true;

	}
}
