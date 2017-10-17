class Id extends Primary
{
	String id;

	Id(String ident)
	{
		id = ident;
	}

	void printParseTree(String indent)
	{
		super.printParseTree(indent);
		IO.displayln(" " + id);
	}
	
	void emitInstructions()
	{
		Integer varNum = Compiler.varMap.get(id);
		if ( varNum == null ) // This is the first time "id" is seen.
		{
			varNum = Compiler.varNum++; // generate a new sequential number
			Compiler.varMap.put(id, varNum);
		}
		IO.displayln(Compiler.indent + "push #" + varNum);
	}
}