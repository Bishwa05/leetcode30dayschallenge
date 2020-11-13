package nov.week2;

public class PopulatingNextRightPointersInEachNode
{
    public Node connect(Node root) {
        if(root == null || root.left == null){
            return root;
        }

        root.left.next = root.right;
        if(root.next != null){
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);

        return root;
    }

    public static void main(String arg[]){
        Node root = new Node(1);
        Node left1 = new Node(2);
        Node right1 = new Node(3);
        Node left11 = new Node(4);
        Node right11 = new Node(5);
        Node left21 = new Node(6);
        Node right22 = new Node(7);
        root.left = left1;
        root.right = right1;
        left1.left = left11;
        left1.right = right11;
        right1.left = left21;
        right1.right = right22;

        PopulatingNextRightPointersInEachNode p = new PopulatingNextRightPointersInEachNode();
        System.out.println(p.connect(root));
        System.out.println(root);


    }
}
