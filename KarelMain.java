import lang.karel.*;

public class KarelMain
{
    public static void main(String[] args)
    {
        try
        {
            // parsing
            Program program = Karel_parser.parseProgram();
            // pretty-printing
            System.out.println(program);
            // executing: evaluating anonymous function S〚program〛()
            // Parse the program
            // Type-checking
            Program_Exec.operation(program).apply();

            //Program_.operation(program).apply();
            //Program_.operation(program).apply();	// operational
        }
        catch(Exception e)
        {
            // type-checking errors are caught here
            System.out.println(e.getMessage());
        }
    }
}