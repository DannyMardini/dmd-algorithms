public class Trie
{
    public class Node
    {
        String data;
        Node[] nodes = new Node[10];

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

    public void add(String key, String data)
    {
        Node n = root;
        char[] keys = key.toCharArray();

        for(char key : keys) {
            int index = Node.getIndex(key);
            if(n[index] == null) {
                n[index] = new Node();
            }
            n = n[index];
        }

        if(n.data == null) {
            n.data = data;
        }
        else {
            //If this location has already been taken, add to # list
            n.addToHashList(data);
        }
    }

    public String get(String key)
    {
        Node n = root;
        char[] keys = key.toCharArray();

        for(char key : keys) {

    }
}
