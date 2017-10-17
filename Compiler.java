import java.util.*;

public abstract class Compiler extends Parser
{
	public static final String indent = "\t";

	public static int varNum = 0; // sequential number of variables
	public static HashMap<String,Integer> varMap = new HashMap<String,Integer>(); // stores sequential numbers of variables
	
	public static Stack<Integer> st = new Stack();
	public static int ifNum = 0;
	
	public static void main(String argv[])
	{
		// argv[0]: input file containing a statement
		// argv[1]: output file containing instruction stream or error messages

		setIO( argv[0], argv[1] );
		setLex();
		
		getToken();
		Statement statement = statement(); // build a parse tree		                    
		if ( ! t.isEmpty() )
			displayln(t + "  -- unexpected symbol");
		else if ( ! syntaxErrorFound )
			statement.emitInstructions();

		closeIO();
	}
}