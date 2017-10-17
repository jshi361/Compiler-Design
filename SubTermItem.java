class SubTermItem extends TermItem

// Represents "- <term>"

{
	// Term term; inherited from TermItem

	SubTermItem(Term t)
	{
		term = t;
	}

	void printParseTree(String indent)
	{
		IO.displayln(indent + indent.length() + " -");
		term.printParseTree(indent);
	}

	void emitInstructions()
	{
		term.emitInstructions();
		IO.displayln(Compiler.indent + "sub");
	}
}