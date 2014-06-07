import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;

public class Main
{
    public static Queue<Integer> maxConcat(int[] a)
    {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>(10, new MyComparator());
        for(int n : a)
        {
            p.add(new Integer(n));
        }

        return p;
    }

    public static void main(String[] args)
    {
        int[] a = {9, 94, 4, 14, 1};
        Queue<Integer> q = maxConcat(a);
        Iterator<Integer> i = q.iterator();

        System.out.println("max:");
        while(i.hasNext())
        {
            Integer n = i.next();
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
