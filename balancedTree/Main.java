public class Main
{
    static class Height
    {
        int value;
        public Height()
        {
            this.value = 0;
        }

        public Height(int value)
        {
            this.value = value;
        }
    }

    public static boolean isBalanced(Node n, Height h)
    {
        if(n == null) {
            h.value = -1;
            return true;
        }

        Height left = new Height();
        Height right = new Height();

        if(isBalanced(n.left, left) && isBalanced(n.right, right) && (Math.abs(left.value - right.value) <= 1) ) {
            h.value = 1 + Math.max(left.value, right.value);
            System.out.println("Height of Node " + n.data + " is: " + h.value);
            return true;
        }

        System.out.println("Was not balanced at " + n.data);

        return false;
    }

    public static void main(String[] args)
    {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n5;

        Height h = new Height();

        System.out.println("Is tree balanced? " + String.valueOf(isBalanced(n1, h)));
    }
}
