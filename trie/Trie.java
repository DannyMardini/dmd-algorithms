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

    public void add(String data)
    {
        Node n = root;
        char[] keys = data.toCharArray();

        for(char key : keys) {
            int index = getIndex(key);
            if(n.nodes[index] == null) {
                n.nodes[index] = new Node();
            }
            n = n.nodes[index];
        }

        if(n.data == null) {
            n.data = data;
        }
        else {
            //If this location has already been taken, add to # list
            while(n[HASH_INDEX] != null) {
                n = n[HASH_INDEX];
            }
            n[HASH_INDEX] = new Node(data);
        }
    }

    public boolean contains(String keyStr)
    {
        char[] keys = keyStr.toCharArray();
        return contains(keys);
    }

    public boolean contains(char[] keys)
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

    public String get(String keyStr)
    {
        char[] keys = keyStr.toCharArray();
        return get(keys);
    }

    public String get(char[] keys)
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

    public boolean remove(String keyStr)
    {
        char[] keys = keyStr.toCharArray();
        return remove(keys);
    }

    public boolean remove(char[] keys)
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

    public static String valueToKey(String value)
    {
        StringBuilder sb = new StringBuilder();
        value.toLowerCase().toCharArray();
    }

    private static int getIndex(char c) {
        if(c >= '2' && c <= '9') {
            return (int)c - '0';
        }
        else if (c == '#') {
            return 10;
        }

        throw new Exception("Invalid index");
    }
}
