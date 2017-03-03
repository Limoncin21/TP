package practica1;

public class CPU {
	private Memory mem;
	private OperandStack pila;
	private boolean parada;

	/**
	 * Constructor
	 */
	public CPU() {
		mem = new Memory();
		pila = new OperandStack();
		parada = false;
	}

	/**
	 * Ejecuta las instrucciones
	 * @param instr instrucción 
	 * @return true si se ha podudo ejecutar alguna instrucción
	 */
	public boolean execute(ByteCode instr) {
		if (instr.toStringName().equals("PUSH")) {
			pila.meterElemento(instr.getParam());
		} else if (instr.toStringName().equals("LOAD")) {
			if (mem.getMarcoMemoria() == 0) {
				parada = true;
				System.out.println("Error: Ejecuccion incorrecta del comando \n");
			} else {
				if (instr.getParam() > mem.getMarcoMemoria()){
					System.out.println("Stack full!!");
					parada = true;
				}else{
				pila.meterElemento(mem.read(instr.getParam()));
				}
			}
		} else if (instr.toStringName().equals("STORE")) {
			mem.write(instr.getParam(), pila.sacarElemento());
		} else if (instr.toStringName().equals("ADD")) {
			parada = !pila.operacion("add");
		} else if (instr.toStringName().equals("SUB")) {
			parada = !pila.operacion("sub");
		} else if (instr.toStringName().equals("MUL")) {
			parada = !pila.operacion("mul");
		} else if (instr.toStringName().equals("DIV")) {
			parada = !pila.operacion("div");
			if(parada == true)
				System.out.println("Error: Ejecuccion incorrecta del comando \n");
		} else if (instr.toStringName().equals("OUT")) {
			System.out.println("El ultimo elemento de la pila es: " + pila.leerUltElemt());
		} else if (instr.toStringName().equals("HALT")) {
			System.out.println("Se ha parado la maquina!!");
			parada = true;
		} else {
			parada = true;
			System.out.println("Error: Ejecuccion incorrecta del comando \n");
		}
		if (!parada) {
			mostrarEstadoCPU(instr);
		}
		return parada;
	}

	/**
	 * Muestra el estado de la cpu
	 * @param instr byteCode
	 */
	private void mostrarEstadoCPU(ByteCode instr) {
		System.out.println("Estado de la CPU: ");
		System.out.println("Memoria: " + mem.toString(instr.getParam()));
		System.out.println("Pila: " + pila.toString());
		System.out.println();
	}
}
