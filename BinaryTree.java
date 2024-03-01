import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;
    BinaryTree(int value){
        this.value=value;
    }
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(10);
        root.left= new BinaryTree(15);
        root.right= new BinaryTree(20);
        root.left.left= new BinaryTree(30);
        root.right.left= new BinaryTree(40);
        root.right.left.left=new BinaryTree(60);
        root.right.left.right=new BinaryTree(70);
        root.right.right=new BinaryTree(50);

        System.out.println("level order: ");
        levelOrder(root);
        System.out.println();
        System.out.println("in order");
        System.out.println();
        inOrder(root);
        System.out.println("pre order");
        preOrder(root);
        System.out.println();
        System.out.println("size is: :"+ getSize(root));
        int max = getMax(root);
        System.out.println("max value is: "+ max);
    }


    public static void levelOrder(BinaryTree root){
        if (root == null) return;
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTree currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if(currentNode.left!=null) {
                levelOrder(root.left);
            }
            if(currentNode.right!=null){
                levelOrder(root.right);
            }
        }
    }
    private static void inOrder(BinaryTree root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    private static void preOrder(BinaryTree root){
        if(root==null) return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    private static int getSize(BinaryTree root){
        if(root==null) return 0;
        return getSize(root.left) + getSize(root.right)+1;
    }

    private static int getMax(BinaryTree root){
        if(root==null) return 0;
        return Math.max(root.value,Math.max(getMax(root.left),getMax(root.right)));
    }
}
