class WhileLoop extends Statement
{
	Expr expr;
	Statement statement;

	WhileLoop(Expr e, Statement s)
	{
		expr = e;
		statement = s;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		String indent2 = indent + "  ";
		
		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " <while loop>");
		IO.displayln(indent2 + indent2.length() + " while");
		expr.printParseTree(indent2);
		statement.printParseTree(indent2);
	}

	void emitInstructions()
	{
		Compiler.ifNum++;
		IO.displayln(Compiler.ifNum+":");
		int ls = Compiler.ifNum;
		expr.emitInstructions();
		
		Compiler.ifNum++;
		int st = Compiler.ifNum;
		Compiler.st.add(Compiler.ifNum);
		IO.displayln(Compiler.indent + "ifF goto " + Compiler.ifNum);	
		statement.emitInstructions();
		
		IO.displayln(Compiler.indent + "goto " + ls);
		IO.displayln(Compiler.st.pop()+":");
		

	}	
}
