class If1 extends Cond
{
	Expr expr;
	Statement statement;

	If1(Expr e, Statement s)
	{
		expr = e;
		statement = s;
	}
	
	void printParseTree(String indent)
	{
		String indent2 = indent + "  ";

		super.printParseTree(indent);
		IO.displayln(indent2 + indent2.length() + " if");
		expr.printParseTree(indent2);
		statement.printParseTree(indent2);
	}

	void emitInstructions()
	{
		Compiler.ifNum++;
		expr.emitInstructions();
		IO.displayln(Compiler.indent + "ifF goto " + Compiler.ifNum);
		statement.emitInstructions();
		IO.displayln(Compiler.ifNum+":");
	}	
}