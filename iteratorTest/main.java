import java.util.LinkedList;
import java.util.Iterator;

public class main
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<String>();
        list.add("Hello");
        list.add("There");
        list.add("How");
        list.add("are");
        list.add("you");
        list.add("doing?");

        Iterator<String> it = list.listIterator(0);

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
