class Switch extends Statement
{
	Expr expr;
	CaseList caseList;

	Switch(Expr e, CaseList cl)
	{
		expr = e;
		caseList = cl;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";
		String indent2 = indent + "  ";
		
		super.printParseTree(indent);
		IO.displayln(indent1 + indent1.length() + " <switch>");
		IO.displayln(indent2 + indent2.length() + " switch");
		expr.printParseTree(indent2);
		caseList.printParseTree(indent2);
	}

	void emitInstructions()
	{
		Compiler.ifNum++;
		int n = Compiler.ifNum;
		Compiler.ifNum++;	
		expr.emitInstructions();
		IO.displayln(Compiler.indent + "ifF goto " + Compiler.ifNum);
		caseList.emitInstructions();
		IO.displayln("1:");

	}	
}
