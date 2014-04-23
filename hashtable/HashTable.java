import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Exception;

class HashTable
{
    public class Node {
        String data;
        Node next;

        public Node(String value)
        {
            this.data = value;
        }

        public boolean contains(String value)
        {
            Node n = this;
            while(n != null) {
                if(n.data.equals(value)) {
                    return true;
                }
                n = n.next;
            }

            return false;
        }

        public void append(String value)
        {
            Node n = this;

            while(n.next != null) {
                n = n.next;
            }

            n.next = new Node(value);
        }
    }

    private static final int INITIAL_CAPACITY = 10000;
    private Node[] nodes;
    private int size;
    private int capacity;

    public HashTable()
    {
        capacity = INITIAL_CAPACITY;
        size = 0;
        nodes = new Node[capacity];
    }

    public int size()
    {
        return this.size;
    }

    public int capacity()
    {
        return this.capacity;
    }

    private int hashItem(String key)
    {
        int sum = 0;
        char[] c_array = key.toCharArray();
        for(char c : c_array) {
            sum += c;
        }

        return sum % capacity;
    }

    public void put(String value)
    {
        int bucket = hashItem(value);
        
        if(nodes[bucket] == null) {
            nodes[bucket] = new Node(value);
        }
        else {
            nodes[bucket].append(value);
        }
    }

    public void readFile(String filename)
    {
        String word;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            
            while((word = reader.readLine()) != null)
            {
                this.put(word);
            }
        }
        catch(Exception e) {
            System.out.println("Error encountered while reading file: " + e.getMessage());
        }
    }

    public boolean contains(String value)
    {
        int bucket = hashItem(value);

        if(nodes[bucket] != null) {
            if(nodes[bucket].data.equals(value)) {
                return true;
            } else {
                return nodes[bucket].contains(value);
            }
        }

        return false;
    }
}
