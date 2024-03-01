import java.util.Objects;

public class BinarySearchTree {
    private int value;
    BinarySearchTree left;
    BinarySearchTree right;

    public BinarySearchTree(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BinarySearchTree root = new BinarySearchTree(20);
        root.left= new BinarySearchTree(15);
        root.right= new BinarySearchTree(30);
        root.left.left= new BinarySearchTree(12);
        root.left.right= new BinarySearchTree(18);
        root.right.right= new BinarySearchTree(40);
        root.right.right.right=new BinarySearchTree(50);
        root.right.right.right.right=new BinarySearchTree(70);

        System.out.println(searchBST(root,30));
        inOrder(root);
    }

    private static boolean searchBST(BinarySearchTree root,int target){
        if(root==null) return false;
        if(Objects.equals(root.value,target)) return true;
        else if(root.value>target){
            return searchBST(root.left,target);
        }else {
            return searchBST(root.right,target);
        }

//        while(root!=null){
//            System.out.println("root value "+ root.value +" target: "+target);
//            if(Objects.equals(root.value,target))return  true;
//            if(root.value>target){
//                root=root.left;
//            }else{
//                root=root.right;
//            }
//        }
//        return false;
    }

    private static void inOrder(BinarySearchTree root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    private static BinarySearchTree insert(BinarySearchTree root,int newValue){
        if(root==null) return new BinarySearchTree(newValue);
        if(root.value>newValue){
            root.left = insert(root.left,newValue);
        }else {
            root.right = insert(root.right,newValue);
        }
        return root;
    }
}
