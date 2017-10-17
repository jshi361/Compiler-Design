class Bool extends Primary
{
	boolean val;

	Bool(boolean b)
	{
		val = b;
	}
	
	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		IO.displayln(" " + val);
	}

	void emitInstructions()
	{
		IO.displayln(Compiler.indent + "push  "+val);
	}
}