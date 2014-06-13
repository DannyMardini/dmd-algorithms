public class Main
{
    public static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
        }
    }

    public static Node makeList()
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;
    }

    public static Node kthToLast(Node list, int k)
    {
        Node n1 = list;
        Node n2 = list;

        for(int i = k; i > 0; i--)
        {
            n2 = n2.next;
        }

        while(n2.next != null)
        {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }

    public static void main(String[] args)
    {
        Node list = makeList();
        System.out.println("4nd to last element in the list: " + kthToLast(list, 4).data);
    }
}
