class Main
{
    /*
    public static void printStats(Node n, String name)
    {
        //System.out.println(name + " maxValue: " + Node.maxValue(n) + " minValue: " + Node.minValue(n));
        System.out.println(name + " pre order: ");
        Node.printPreOrder(n);
        System.out.println();
        
        System.out.println(name + " post order: ");
        Node.printPostOrder(n);
        System.out.println();
        
        System.out.println(name + " in order: ");
        Node.printInOrder(n);
        System.out.println();
    }
    */

    public static void main(String[] args)
    {
        BiNode end = null;
        BiNode n = BiNode.build5();
        n = BiNode.flatten(n);
        while(n.n1 != null) {
            n = n.n1;
        }

        while(n != null) {
            if(n.n2 == null) {
                end = n;
            }
            System.out.print(n.data + " ");
            n = n.n2;
        }
        System.out.println();

        n = end;
        while(n != null) {
            System.out.print(n.data + " ");
            n = n.n1;
        }
        System.out.println("Done!");
    }
}
