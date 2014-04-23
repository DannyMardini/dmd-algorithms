import java.util.ArrayList;

public class Trie
{
    public static final int HASH_INDEX = 10;
    public class Node
    {
        String data;
        Node[] nodes = new Node[11];    //Digits 0-9 and hash index.

        public Node() 
        {
        }

        public Node(String data) {
            this.data = data;
        }
    }

    Node root;

    public Trie()
    {
        root = new Node();
    }

    public void add(String data) throws Exception
    {
        Node n = root;
        char[] keys = valueToKey(data).toCharArray();

        for(char key : keys) {
            int index = getIndex(key);
            if(n.nodes[index] == null) {
                n.nodes[index] = new Node();
            }
            n = n.nodes[index];
        }

        if(n.data == null) {
            n.data = data.toLowerCase();
        }
        else {
            //If this location has already been taken, add to # list
            while(n.nodes[HASH_INDEX] != null) {
                n = n.nodes[HASH_INDEX];
            }
            n.nodes[HASH_INDEX] = new Node(data);
        }
    }

    public boolean contains(String keyStr) throws Exception
    {
        char[] keys = keyStr.toCharArray();
        return contains(keys);
    }

    public boolean contains(char[] keys) throws Exception
    {
        Node n = root;
        int i;
        int index;

        for(i = 0; i < keys.length - 1; i++) {
            index = getIndex(keys[i]);
            if(n.nodes[index] == null) {
                return false;
            }
            n = n.nodes[index];
        }

        index = getIndex(keys[i]);     //Get last index

        if(n.nodes[index] != null || n.nodes[index].data != null) {
            return true;
        }

        return false;
    }

    public String get(String keyStr) throws Exception
    {
        char[] keys = keyStr.toCharArray();
        return get(keys);
    }

    public String get(char[] keys) throws Exception
    {
        Node n = root;

        for(char key : keys) {
            int index = getIndex(key);
            if(n.nodes[index] == null) {
                return null;
            }
            n = n.nodes[index];
        }

        return n.data;
    }

    public boolean remove(String keyStr) throws Exception
    {
        char[] keys = keyStr.toCharArray();
        return remove(keys);
    }

    public boolean remove(char[] keys) throws Exception
    {
        Node n = root;
        int i;
        int index;

        for(i = 0; i < keys.length - 1; i++) {
            index = getIndex(keys[i]);
            if(n.nodes[index] == null) {
                return false;
            }
            n = n.nodes[index];
        }

        index = getIndex(keys[i]);

        if(n.nodes[index] != null) {
            n.nodes[index] = null;
            return true;
        }

        return false;
    }
    
    public void printTrie() 
    {
        int level = 0;
        ArrayList<Node> curr = new ArrayList<Node>();
        ArrayList<Node> next;
        curr.add(root);

        do {
            next = new ArrayList<Node>();
            System.out.println("Level " + level + " =========");
            for(int i = 0; i < curr.size(); i++) {
                //print list containing current level
                Node n = curr.get(i);
                System.out.println("Node " + n.toString() + ": ");
                if(n.data != null) {
                    System.out.println(" data: " + n.data);
                }
                
                //Build list for next level
                System.out.print("Children: ");
                for(int j = 0; j < n.nodes.length; j++) {
                    if(n.nodes[j] != null) {
                        System.out.print(j + ":" + n.nodes[j].toString() + " ");
                        next.add(n.nodes[j]);
                    }
                }
                System.out.println();
            }
            
            //current level now equal to next
            curr = next;
            level++;
        } while(curr.size() != 0);
    }

    public static String valueToKey(String value) throws Exception
    {
        StringBuilder sb = new StringBuilder();
        char[] c_array = value.toLowerCase().toCharArray();
        for(char c : c_array) {
            switch (c) {
                case 'a':
                case 'b':
                case 'c':
                    sb.append('2');
                    break;
                case 'd':
                case 'e':
                case 'f':
                    sb.append('3');
                    break;
                case 'g':
                case 'h':
                case 'i':
                    sb.append('4');
                    break;
                case 'j':
                case 'k':
                case 'l':
                    sb.append('5');
                    break;
                case 'm':
                case 'n':
                case 'o':
                    sb.append('6');
                    break;
                case 'p':
                case 'q':
                case 'r':
                case 's':
                    sb.append('7');
                    break;
                case 't':
                case 'u':
                case 'v':
                    sb.append('8');
                    break;
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    sb.append('9');
                    break;
                default:
                    throw new Exception("Unknown value, must be key you can enter in keypad.");
            }
        }

        return sb.toString();
    }

    private static int getIndex(char c) throws Exception {
        if(c >= '2' && c <= '9') {
            return (int)c - '0';
        }
        else if (c == '#') {
            return 10;
        }

        throw new Exception("Invalid index " + c);
    }
}
