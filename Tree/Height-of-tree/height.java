
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class heightOfTree {
    public static Node insert(Node root, int data){
        Node temp = new Node(data);
        if(root==null) {
            root = temp;
            return root;
        }else if(root.data <= data) root.right = insert(root.right, data); else root.left = insert(root.left, data);
        return root;
    }

    public static void print(Node root){
        if(root==null) return;
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }

    public static int calculateHeight(Node root){
        if(root==null) return 0;
        return Math.max(calculateHeight(root.left), calculateHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            root = insert(root, sc.nextInt());
        }
        int height = calculateHeight(root);
        System.out.println("The height of the given tree is: "+ height);
    }
}
