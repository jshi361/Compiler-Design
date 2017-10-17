class Assign
{
	String id; // variable on the left side
	Expr expr; // expression on the right side

	Assign(String s, Expr e)
	{
		id = s;
		expr = e;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";

		IO.displayln(indent + indent.length() + " <assign>");
		IO.displayln(indent1 + indent1.length() + " " + id);
		IO.displayln(indent1 + indent1.length() + " =");
		expr.printParseTree(indent1);
	}
	
	void emitInstructions()
	{
//		IO.displayln(Compiler.indent + "push #" + id );
		expr.emitInstructions();
		
	}	
	
	
	
/*	void emitInstructions()
	{
		expr.emitInstructions();

		Integer varNum = Compiler.varMap.get(id);
		if ( varNum == null ) // This is the first time "id" is seen.
		{
			varNum = Compiler.varNum++; // generate a new sequential number
			Compiler.varMap.put(id, varNum);
		}		
		IO.displayln(Compiler.indent + "pop #" + varNum);
	}*/
}