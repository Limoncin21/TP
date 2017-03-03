package cpu;

public class OperandStack {
	private int[] stack;
	public static int MAX_STACK = 5;
	private int marcoPila;

	/**
	 * Constructor
	 */
	public OperandStack() {
		stack = new int[MAX_STACK];
		marcoPila = 0;
	}

	/**
	 * mete un elemento en el final de la pila
	 * 
	 * @param n
	 *            entero que meto
	 */
	public boolean meterElemento(int n) {
		boolean ok = false;
		if (marcoPila >= MAX_STACK) {
			MAX_STACK = n + 50;
			stack = new int[MAX_STACK];
		}
		if (marcoPila < MAX_STACK) {
			stack[marcoPila] = n;
			marcoPila++;
			ok = true;
		}
		return ok;
	}

	/**
	 * comprueba si esta vacia
	 * 
	 * @return si esta vacia o no
	 */
	public boolean isEmpty() {
		return (this.marcoPila == 0);
	}

	/**
	 * lee el ultimo elemento
	 * 
	 * @return devuelve el ultimo elemento de stack
	 */
	public int leerUltElemt() {
		int n;
		n = stack[marcoPila - 1];
		return n;
	}

	/**
	 * resetea el marco de la pila
	 */
	public void reset() {
		marcoPila = 0;
	}

	/**
	 * Saca el elemento del final
	 * 
	 * @return el entero del final de stack
	 */
	public int sacarElemento() {
		int n;
		n = stack[marcoPila - 1];
		marcoPila--;
		return n;
	}

	/**
	 * Devuelve el string
	 */
	public String toString() {
		String cadena = "";
		if (marcoPila == 0) {
			cadena = "<vacia>";
		} else {
			for (int i = 0; i < marcoPila; i++)
				cadena += stack[i] + " ";
		}
		return cadena;
	}
}
