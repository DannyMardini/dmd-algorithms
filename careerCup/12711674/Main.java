public class Main
{

    public static class List
    {
        Node head;
        Node tail;
        int count;

        public List()
        {
            head = null;
            tail = null;
            count = 0;
        }

        public void appendToHead(Node n)
        {
            if(head == null)
            {
                head = n;
                tail = head;
            }
            else
            {
                n.right = head;
                head.left = n;
                head = n;
            }
        }

        public void appendToTail(Node n)
        {
            if(tail == null)
            {
                head = n;
                tail = head;
            }
            else {
                tail.right = n;
                n.left = tail;
                tail = n;
            }
        }

        public static List mergeLists(List leftList, List rightList)
        {
            leftList.tail.right = rightList.head;
            rightList.head.left = leftList.tail;

            leftList.tail = rightList.tail;

            return leftList;
        }
    }

    public static class Node
    {
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List flatten(Node root)
    {
        if(root.left == null && root.right == null) {
            List newList = new List();
            newList.appendToHead(root);
            return newList;
        }

        List leftList = flatten(root.left);
        List rightList = flatten(root.right);

        leftList.appendToTail(root);

        List mergedList = List.mergeLists(leftList, rightList);

        return mergedList;
    }

    public static void findPairsSum(Node root, int n)
    {
        List list = flatten(root);

        Node head = list.head;
        Node tail = list.tail;

        while(head != tail && head != tail.right){
            int sum = head.data + tail.data;

            if(sum > n){
                tail = tail.left;
            }
            else if(sum < n) {
                head = head.right;
            }
            else {
                System.out.println("Pair: " + head.data + ", " + tail.data);
                tail = tail.left;
                head = head.right;
            }
        }
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n4.left = n2;
        n4.right = n6;

        n2.left = n1;
        n2.right = n3;

        n6.left = n5;
        n6.right = n7;

        findPairsSum(n4, 8);
    }
}
