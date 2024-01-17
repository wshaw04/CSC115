import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public void insert(Integer value) {
        root = insertRec(root, value);
    }

    private TreeNode insertRec(TreeNode cur, Integer value) {
        if(cur == null) {
            cur = new TreeNode(value);
            return cur;
        }

        else if(value < cur.getValue()) {
            cur.left = insertRec(cur.left, value);
        }

        else {
            cur.right = insertRec(cur.right, value);
        }

        return cur;
    }

    public boolean find(int val) {
        TreeNode cur = root;

        while(cur != null) {
            if(val == cur.data) {
                return true;
            }
            else if(val < cur.data) {
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
        }
        return false;
    }

    public int getMax() throws TreeEmptyException {
        if(root == null) {
            throw new TreeEmptyException();
        }
        return getMaxRec(root);
    }

    private int getMaxRec(TreeNode cur) {
        if(cur.right == null) {
            return cur.data;
        }
        else {
            return getMaxRec(cur.right);
        }
    }


    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);

        System.out.println("Sum is: " + myTree.sum());

        System.out.println("Finding 6, should be true");
        System.out.println(myTree.find(6));

        System.out.println("Finding 100, should be false");
        System.out.println(myTree.find(100));

        System.out.println("Finding 3, should be false");
        System.out.println(myTree.find(3));

        System.out.println("Finding max, should be 7");
        try {
            System.out.println(myTree.getMax());
        }
        catch(TreeEmptyException t) {
            System.out.println("empty");
        }
    }
}
