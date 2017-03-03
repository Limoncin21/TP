package bytecodes;

import cpu.CPU;

public abstract class ByteCode {
	abstract public boolean execute(CPU cpu);
	abstract public ByteCode parse(String[] s);
}
