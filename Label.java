class Label
{
	int val;

	Label(int i)
	{
		val = i;
	}

	void printParseTree()
	{
		IO.displayln(" " + val);
	}
	
	void emitInstructions(){
		IO.displayln("" + (val+1));
	}
}