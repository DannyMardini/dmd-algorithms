class BiNode {
    BiNode n1;
    BiNode n2;
    int data;
    public BiNode(int d) {
        this.data = d;
    }

    public static BiNode build5() {
        BiNode n1 = new BiNode(1);
        BiNode n2 = new BiNode(2);
        BiNode n3 = new BiNode(3);
        BiNode n5 = new BiNode(5);
        BiNode n10 = new BiNode(10);
        BiNode n7 = new BiNode(7);
        BiNode n12 = new BiNode(12);

        n5.n1 = n2;
        n5.n2 = n10;
        n2.n1 = n1;
        n2.n2 = n3;
        n10.n1 = n7;
        n10.n2 = n12;

        return n5;
    }

    public static BiNode flatten(BiNode root) {
        if(root == null) {
            return null;
        }
        if(root.n1 == null && root.n2 == null) {
            return root;
        }
        if(root.n1 != null) {
            BiNode n = flatten(root.n1);
            while(n.n2 != null) {
                n = n.n2;
            }
            root.n1 = n;
            n.n2 = root;
        }
        if(root.n2 != null) {
            BiNode n = flatten(root.n2);
            while(n.n1 != null) {
                n = n.n1;
            }
            root.n2 = n;
            n.n1 = root;
        }
        return root;
    }
}

