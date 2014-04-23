public class Trie
{
    public class Node
    {
        String data;
        Node[] edges = new Node[10];

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

    public void insert(
}
