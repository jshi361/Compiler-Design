class LabeledCase extends Case
{
	Label label;
	// SList sList; inherited from Case

	LabeledCase(Label l, SList sl)
	{
		label = l;
		sList = sl;
	}

	void printParseTree(String indent)
	{
		String indent1 = indent + " ";

		IO.display(indent + indent.length() + " case :");
		label.printParseTree();
		sList.printParseTree(indent1);
	}

	@Override
	void emitInstructions() {
		sList.emitInstructions();
		IO.displayln(Compiler.indent + "goto " + 1 );
		label.emitInstructions();

	}
}