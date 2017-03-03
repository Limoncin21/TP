package bytecodes;

import bytecodes.arithmetics.*;
import bytecodes.oneparameter.*;
import bytecodes.oneparameter.conditionaljumps.*;

public class ByteCodeParser {
	private final static ByteCode[] byteCode = { new Halt(), new Out(), new Add(), new Div(), new Mul(), new Sub(),
			 new Push(0), new Goto(0), new Load(0), new Store(0), new IfEq(0), new IfLe(0), new IfLeq(0), new IfNeq(0) };

	public static void showHelp() {

	}

	/**
	 * Parsea la cadena de string
	 * @param cadena array de string
	 * @return bytecode parseado
	 */
	public static ByteCode parse(String[] cadena) {
		ByteCode enumerado = null;
		if (cadena.length <= 2) {
			if (cadena[0].equals("OUT")) {
				return byteCode[1];
			} else if (cadena[0].equals("HALT")) {
				return byteCode[0];
			}
			for (int i = 0; i < byteCode.length; i++) {
				enumerado = byteCode[i].parse(cadena);
				if (enumerado != null)
					return enumerado;
			}
		}
		return null;
	}
}
