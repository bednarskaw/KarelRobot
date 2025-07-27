import lang.karel.*;

public class KarelMain
{
    public static void main(String[] args)
    {
        try
        {
            Program program = Karel_parser.parseProgram();
            System.out.println(program);
            Program_Exec.operation(program).apply();

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}