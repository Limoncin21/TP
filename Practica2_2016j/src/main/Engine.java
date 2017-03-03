package main;

import java.util.Scanner;

import bytecodes.ByteCode;
import bytecodes.ByteCodeParser;
import commands.Command;
import commands.CommandParser;
import cpu.CPU;

public class Engine {
	private ByteCodeProgram program;// representa el programa actual
	private boolean end;// controla el final del bucle de ejecuccion
	private static Scanner in;// entrada por teclado
	private CPU cpu;
	/**
	 * Constructor
	 * 
	 * @param in
	 *            scanner
	 */
	@SuppressWarnings("static-access")
	public Engine(Scanner in) {
		this.in = in;
		this.program = new ByteCodeProgram();
		this.cpu = new CPU(this.program);
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
				System.out.println("Comienza la ejecucion de " + command.toString() + System.getProperty("line.separator"));
				boolean ex;
				ex = command.execute(this);
				if (ex){
					System.out.println(this.program);
				}else{
					System.out.println("Error: Ejecucion incorrecta del comando");
				}
			}
		}
		System.out.println("Fin de la ejecucion...");
	}

	/**
	 * Pide la instrucción al completo
	 * 
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
	 * Bucle para parsear los bytecode recibidos
	 * @return si se ha realizado correctamente
	 */

	public boolean readByteCodePrgram() {
		program.vaciarArray();
		cpu.reset();
		System.out.println("Introduce el bytecode. Una instruccion por linea: ");
		ByteCode byteCode = null;
		String[] cadena;
		boolean ok = true;
		String line = in.nextLine().toUpperCase();
		cadena = line.split(" ");
		while (!cadena[0].equals("END") && ok) {
			byteCode = ByteCodeParser.parse(cadena);
			if (byteCode != null) {
				program.añadirByteCode(byteCode);
				line = in.nextLine().toUpperCase();
				cadena = line.split(" ");
			} else {
				ok = false;
			}
		}
		return ok;
	}
	/**
	 * Ejecuta help
	 * 
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
	 * 
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
	 * 
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
	 * 
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
	 * 
	 * @param replace
	 *            posicion a reemplazar
	 * @return true si se ha reemplazado
	 */
	public boolean executeREPLACE(int replace) {
		boolean ok = false;
		if (replace <= program.getMarco() && replace >= 0) {
			System.out.print("Nueva instruccion: ");
			String line = in.nextLine().toUpperCase();
			String[] cadena = line.split(" ");
			ByteCode bytecode = ByteCodeParser.parse(cadena);
			ok = this.program.replace(replace, bytecode);
		}
		return ok;
	}

	/**
	 * Empieza la ejecución de la CPU
	 * 
	 * @return true
	 */
	public boolean startExecution() {
		
		boolean parada;
		parada = cpu.run();
		if (parada){
			System.out.println("El estado de la maquina tras ejecutar el programa es: " +  System.getProperty("line.separator"));
			System.out.println(this.cpu);
		}
		return parada;
	}

	/**
	 * Reinicia el programa
	 * 
	 * @return true
	 */
	public boolean resetProgram() {
		program.vaciarArray();
		cpu.reset();
		System.out.println();
		return true;
	}

	/**
	 * Muestra el menú de ayuda
	 * 
	 * @return true
	 */
	public boolean showHelp() {
		CommandParser.showHelp();
		return true;
	}

	/**
	 * Termina la ejecución
	 * 
	 * @return true;
	 */
	public boolean endExecution() {
		end = true;
		return true;

	}
}
