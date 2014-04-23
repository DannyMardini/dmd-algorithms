import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main
{
    public static void console(Trie t)
    {
        Scanner scanner = new Scanner(System.in);
        String input = null;
        while(true)
        {
            System.out.println("Enter \"exit\" to quit.");
            System.out.println("Enter Key sequence (or \"#\" for next word):");
            System.out.print("> ");
            input = scanner.nextLine();
            if(input.equals("exit")) {
                break;
            }
            try {
                String out = t.get(input);
                if(out == null) {
                    System.out.println("Not found in current dictionary");
                }
                else {
                    System.out.println("\'" + out + "\'");
                }
            }
            catch(Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args)
    {
        if(args.length < 1) {
            System.out.println("Please give me a filename to use as a dictionary");
            return;
        }

        Trie t = new Trie();
        String filename = args[0];

        try 
        {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(filename));

            while((line = reader.readLine()) != null) 
            {
                t.add(line);
            }
        }
        catch(Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        console(t);
    }
}
