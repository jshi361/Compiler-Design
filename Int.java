class Int extends Primary
{
	int val;

	Int(int i)
	{
		val = i;
	}

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		IO.displayln(" " + val);
	}
	
	void emitInstructions()
	{
		IO.displayln(Compiler.indent + "push " + val);
	}
}