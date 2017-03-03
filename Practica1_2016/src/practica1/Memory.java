package practica1;

public class Memory {
	private Integer[] memory;
	private int marcoMemoria;
	private int maxMemoria;

	/**
	 * Constructor
	 */
	public Memory() {
		maxMemoria = 50;
		memory = new Integer[maxMemoria];
		marcoMemoria = 0;
	}

	/**
	 * Escribe el valor en la posición pos
	 * @param pos posición
	 * @param value valor
	 * @return true
	 */
	public boolean write(int pos, int value) {
		if (pos > maxMemoria){
			maxMemoria = pos + 100;
			memory = new Integer[maxMemoria];
		}
		memory[pos] = value;
		marcoMemoria++;
		return true;
	}

	/**
	 * lee el dato de mem en la posicion pos
	 * @param pos posicion
	 * @return devuelve el dato de memoria de la posicion pos
	 */
	public int read(int pos){
		return memory[pos];
	}
	/**
	 * Devuelve el marco de memoria
	 * @return marco
	 */
	public int getMarcoMemoria(){
		return marcoMemoria;
	}
	/**
	 * Devuelve el string
	 * @param pos posición
	 * @return el string
	 */
	public String toString(int pos) {
		String cadena = "";
		if (marcoMemoria == 0) {
			cadena = "<vacia>";
		} else {
			for (int i = 0; i <= pos; i++)
				if (memory[i] != null)
					cadena += "[" + i + "]:" + memory[i] + " ";
		}
		return cadena;
	}
}
