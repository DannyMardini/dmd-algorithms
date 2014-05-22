import java.util.Hashtable;
import java.util.Enumeration;
import java.util.ListIterator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main
{
    public static void practiceHashtable()
    {
        Hashtable<Integer, String> hash = new Hashtable<Integer, String>();
        hash.put(new Integer(1), "Hello there!");
        hash.put(new Integer(2), "Hello");
        hash.put(new Integer(5), "What is going on?");

        StringBuffer sb = new StringBuffer();
        sb.append("Keys:\n");

        Enumeration<Integer> keys = hash.keys();
        while(keys.hasMoreElements()) {
            Integer key = keys.nextElement();
            sb.append(key);
            sb.append(" ");
        }
        sb.append("\n");
        System.out.println(sb.toString());
        sb.delete(0, sb.length());

        sb.append("Elements:\n");
        Enumeration<String> values = hash.elements();
        while(values.hasMoreElements()) {
            String s = values.nextElement();
            sb.append(s);
            sb.append("\n");
        }
        System.out.println(sb.toString());

        System.out.println("Does hashtable contain key 0? " + String.valueOf(hash.containsKey(new Integer(0))));
        System.out.println("Does hashtable contain key 1? " + String.valueOf(hash.containsKey(new Integer(1))));

        System.out.println("Does hashtable contain value asdf? " + String.valueOf(hash.containsValue("asdf")));
        System.out.println("Does hashtable contain value Hello? " + String.valueOf(hash.containsValue("Hello")));
        System.out.println("Removing Hello...");
        hash.remove(new Integer(2));
        System.out.println("Does hashtable contain value Hello? " + String.valueOf(hash.containsValue("Hello")));

    }

    public static void printList(LinkedList<Integer> list) {
        StringBuffer sb = new StringBuffer();
        Iterator<Integer> i = list.listIterator();

        while(i.hasNext())
        {
            sb.append(i.next());
            sb.append(" ");
        }

        System.out.println(sb.toString());
    }

    public static boolean isPalindrome(LinkedList<Integer> list)
    {
        Iterator<Integer> runner;
        Iterator<Integer> i;

        runner = list.listIterator();
        i = list.listIterator();

        while(runner.hasNext())
        {
            i.next();
            runner.next();
            if(runner.hasNext())
            {
                runner.next();
            }
        }

        //if odd, increment i by one, that is where we want to check for palindrome.
        if(list.size()%2 == 1) {
            i.next();
        }

        Stack<Integer> s = new Stack<Integer>();

        //Add all elements from i to end to stack
        while(i.hasNext())
        {
            s.push(i.next());
        }
        
        //Check to see if all elements in beginning of list match those found in stack
        //set i back to beginning of list.
        i = list.listIterator();
        while(i.hasNext() && s.size() > 0) {
            if(i.next() == s.peek()) {
                s.pop();
            }
        }

        if(s.size() == 0)
        {
            return true;
        }

        return false;
    }

    public static void practiceLinkedlist()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(new Integer(1));
        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(3));
        list.add(new Integer(1));

        /*
        Integer n = list.get(1);
        System.out.println("Integer at index 1: " + n);
        list.add(1, new Integer(7));
        n = list.get(1);

        System.out.println("Integer at index 1: " + n);
        */

        printList(list);
        System.out.println("is Palindrome? " + String.valueOf(isPalindrome(list)));
        
        list.add(new Integer(5));
        
        printList(list);
        System.out.println("is Palindrome? " + String.valueOf(isPalindrome(list)));
    }

    public static void practiceBinarytree()
    {
    }

    public static void practiceStack()
    {
        Stack<Integer> s = new Stack<Integer>();

        s.push(new Integer(5));
        s.push(new Integer(4));
        s.push(new Integer(3));

        System.out.println("Stack elements:");
        while(s.size() > 0)
        {
            System.out.println(s.pop());
        }
    }
    
    public static void practiceQueue()
    {
    }

    public static void practiceArraylist()
    {
    }

    public static void main(String[] args)
    {
        practiceHashtable();
        //practiceLinkedlist();
        //practiceBinarytree();
        //practiceStack();
        practiceQueue();
        practiceArraylist();
    }
}
