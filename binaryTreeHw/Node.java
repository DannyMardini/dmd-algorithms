/*
 * Notes
 * 1. Must initialize data instances of structures before using them!
 */

import java.util.LinkedList;

public class Node
{
    int data;
    Node p; //parent
    Node left;
    Node right;

    public Node(int data)
    {
        this.data = data;
    }

    public static void insert(Node n, int data)
    {
        boolean inserted = false;
        while(!inserted) {
            if( data > n.data ) {
                if( n.right == null ) {
                    n.right = new Node(data);
                    inserted = true;
                } else {
                    n = n.right;
                }
            } else {
                if( n.left == null ) {
                    n.left = new Node(data);
                    inserted = true;
                } else {
                    n = n.left;
                }
            }
        }
    }

    public static Node build5() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n5 = new Node(5);
        Node n10 = new Node(10);
        Node n7 = new node(7);
        Node n12 = new node(12);

        return n5;
    }

    public static Node build123()
    {
        Node n = new Node(2);
        n.left = new Node(1);
        n.right = new Node(3);

        return n;
    }

    public static int size(Node n)
    {
        if(n == null) {
            return 0;
        }

        return 1 + size(n.left) + size(n.right);
    }

    static class Height {
        int value = 0;
    }

    public static int maxValue(Node n) {
        while(n.right != null) {
            n = n.right;
        }

        return n.data;
    }

    public static int minValue(Node n) {
        while(n.left != null) {
            n = n.left;
        }

        return n.data;
    }

    public static boolean isBalanced(Node n) {
        Height h = new Height();
        return isBalanced(n, h);
    }

    private static boolean isBalanced(Node n, Height h) {
        if(n == null) {
            return true;
        }
        Height hLeft = new Height();
        Height hRight = new Height();

        boolean balancedL = isBalanced(n.left, hLeft);
        boolean balancedR = isBalanced(n.right, hRight);
        h.value = Math.max(hLeft.value, hRight.value) + 1;
        int diff = Math.abs(hLeft.value - hRight.value);
        if(diff <= 1 && balancedL == true && balancedR == true) {
            return true;
        }

        return false;
    }

    public static int maxDepth(Node n) {
        if(n.left == null && n.right == null ) { //if leaf node return 0
            return 0;
        }

        int left = (n.left != null) ? maxDepth(n.left) : 0;
        int right = (n.right != null) ? maxDepth(n.right) : 0;

        return Math.max(left, right) + 1;
    }

    public static void printPostOrder(Node n) {
        if(n == null) {
            return;
        }

        printPostOrder(n.left);
        printPostOrder(n.right);
        System.out.print(n.data + " ");
    }

    public static void printPreOrder(Node n) {
        if(n == null) {
            return;
        }

        System.out.print(n.data + " ");
        printPreOrder(n.left);
        printPreOrder(n.right);
    }

    public static void printInOrder(Node n) {
        if(n == null) {
            return;
        }

        printInOrder(n.left);
        System.out.print(n.data + " ");
        printInOrder(n.right);
    }

    public static void printList(Node n)
    {
        int level = 0;
        double count = 0;
        StringBuilder sb = new StringBuilder();
        LinkedList<Node> toVisit = new LinkedList<Node>();
        toVisit.add(n);

        while(toVisit.isEmpty() == false) {
            Node curr = toVisit.removeFirst();
            
            if(curr.left != null) {
                toVisit.add(curr.left);
            }
            
            if(curr.right != null) {
                toVisit.add(curr.right);
            }

            int currLevel = (int)Math.ceil(count++ / 2);
            if(currLevel > level) {
                sb.append("\n");
                level = currLevel;
            }
            sb.append(curr.data);
            sb.append(" ");
        }
        
        System.out.println(sb.toString());
    }

    public static Node buildAncestorTree() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n6.left = n4;
        n6.right = n7;
        n4.p = n7.p = n6;

        n4.left = n5;
        n4.right = n3;
        n5.p = n3.p = n4;

        n3.right = n2;
        n2.p = n3;

        n2.left = n1;
        n1.p = n2;

        return n6;
    }

    public static Node findNode(Node n, int d) {
        if(n == null) {
            return null;
        }

        if(n.data == d) {
            return n;
        }

        Node curr = findNode(n.left, d);
        if(curr != null) {
            return curr;
        }

        curr = findNode(n.right, d);
        if(curr != null) {
            return curr;
        }

        return null;
    }

    public static Node commonAncestor(Node n1, Node n2) {
        Node prev = null;
        while(n1 != null) {
            if(n1 == n2) {
                return n1;
            }
            if(n1.left != prev) {
                if(DFS(n1.left, n2)) {
                    return n1;
                }
            }
            if(n1.right != prev) {
                if(DFS(n1.right, n2)) { 
                    return n1;
                }
            }
            prev = n1;
            n1 = n1.p;
        }
        return n1;
    }

    public static boolean DFS(Node n1, Node n2) {
        if(n1 == null || n2 == null) {
            return false;
        }

        if(n1 == n2 || DFS(n1.left, n2) || DFS(n1.right, n2)) {
            return true;
        }

        return false;
    }
}
