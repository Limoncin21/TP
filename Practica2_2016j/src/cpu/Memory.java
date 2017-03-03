package cpu;

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
	 * 
	 * @param pos
	 *            posición
	 * @param value
	 *            valor
	 * @return true
	 */
	public boolean write(int pos, int value) {
		if (pos > maxMemoria) {
			maxMemoria = pos + 100;
			redimensionar();
		}
		memory[pos] = value;
		marcoMemoria++;
		return true;
	}
	/**
	 * Comprueba si una posicion de memoria esta vacia
	 * @param pos
	 * @return devuelve true si esta vacia, false en caso contrario
	 */
	public boolean isEmpty(int pos){
		if (pos >= 0 && pos < maxMemoria){
		return memory[pos] == null;
		}else{
			return true;
		}
	}

	/**
	 * redimensiona con mas 1/2 MAXMEMORIA
	 */
	private void redimensionar() {
		int newDim = maxMemoria + maxMemoria / 2;
		Integer[] newMemory = new Integer[newDim];
		for (int i = 0; i < newDim; i++) {
			if (i < marcoMemoria) {
				newMemory[i] = this.memory[i];
			} else {
				newMemory[i] = null;
			}
		}
		this.memory = newMemory;
		maxMemoria = newDim;
	}

	private void redimensionar(int pos) {
		Integer[] newMemory = new Integer[pos+1];
		for (int i = 0; i < pos + 1; i++){
			if (i < maxMemoria){
				newMemory[i] = memory [i];
			}
			else{
				newMemory[i] =  null;
			}
		}
		this.memory = newMemory;
		maxMemoria = pos+1;
	}
	/**
	 * lee el dato de mem en la posicion pos
	 * 
	 * @param pos
	 *            posicion
	 * @return devuelve el dato de memoria de la posicion pos
	 */
	public int read(int pos) {
		int value = 0;
		if (pos >= maxMemoria){
			redimensionar(pos);
		}
		if (pos >= 0 && pos < maxMemoria && memory[pos] != null){
			value = memory[pos].intValue();
		}
		return value;
	}
	/**
	 * Devuelve el string
	 * 
	 * @param pos
	 *            posición
	 * @return el string
	 */
	public String toString() {
		String cadena = "";
		if (marcoMemoria == 0) {
			cadena = "<vacia>" + System.getProperty("line.separator");
		} else {
			for (int i = 0; i < maxMemoria; i++)
				if (this.memory[i] != null)
					cadena += "[" + i + "]:" + this.memory[i].intValue() + " ";
		}
		cadena += System.getProperty("line.separator");
		return cadena;
	}

	/**
	 * resetea la memoria
	 */
	public void reset() {
		for (int i = 0; i < maxMemoria; i++) {
			if (memory[i] != null) {
				memory[i] = null;
				marcoMemoria--;
			}
		}
	}
}
