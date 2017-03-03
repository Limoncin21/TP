package practica1;

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
	 * @param n entero que meto
	 */
	public void meterElemento(int n) {
		if (marcoPila < MAX_STACK) {
			stack[marcoPila] = n;
			marcoPila++;
		}
	}
	/**
	 * lee el ultimo elemento
	 * @return devuelve el ultimo elemento de stack
	 */
	public int leerUltElemt(){
		int n;
		n = stack[marcoPila - 1];
		return n;
	}
	/**
	 * Saca el elemento del final
	 * @return el entero del final de stack
	 */
	public int sacarElemento() {
		int n;
		n = stack[marcoPila - 1];
		marcoPila--;
		return n;
	}
	
	/**
	 * Se encarga de realizar la operación
	 * @param op operando
	 * @return true si es posible realizar la operación
	 */
	public boolean operacion(String op) {
		int subCima, cima, resultado = -1;
		boolean valido = false;
		if (marcoPila >= 2) {
			subCima = stack[marcoPila - 2];
			cima = stack[marcoPila - 1];
			if (op.equals("add"))
				resultado = subCima + cima;
			else if (op.equals("sub"))
				resultado = subCima - cima;
			else if (op.equals("mul"))
				resultado = subCima * cima;
			else if (op.equals("div") && cima != 0)
				resultado = subCima / cima;
			if (op.equals("div") && cima == 0) {
				valido = false;
			} else {
				marcoPila--;
				stack[marcoPila - 1] = resultado;
				valido = true;
			}
		}
		return valido;
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
