import java.lang.Math;
import java.util.LinkedList;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
    protected TreeNode root;
    
    public RefBasedBinaryTree() {
        this.root = null;
    }
    
    public void insert(Integer value){
        if (root==null) {
            root = new TreeNode(value);
        } else {
            insert(null, root, value);
		}
        
    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(parent.getLeft()==null) {
                parent.setLeft(new TreeNode(value));
			} else {
                parent.setRight(new TreeNode(value));
			}            
        }  else {
            int htLeft = height(t.getLeft());
            int htRight = height(t.getRight());
            if (htLeft>htRight) {
                insert(t, t.getRight(), value);
			} else {
                insert(t, t.getLeft(), value);
			}
        }
    }
    
    private int height(TreeNode t) {
        if (t==null) {
            return -1;
		} else {
            int highest = Math.max(height(t.getLeft()), height(t.getRight()));
            return 1 + highest;
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following an in-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void inOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            inOrder(t.getLeft());
            System.out.print(t.getValue() + " ");
            inOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a pre-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void preOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            System.out.print(t.getValue() + " ");
            preOrder(t.getLeft());
            preOrder(t.getRight());
        }
    }
    
    /*
     * Purpose: prints the value at each TreeNode in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    
    /*
     * Purpose: prints the value at each TreeNode in t,
     *          following a post-order traversal
     * Parameters: TreeNode t
     * Returns: Nothing
     */
    private void postOrder(TreeNode t){
        if (t==null) {
            return;
        } else {
            postOrder(t.getLeft());
            postOrder(t.getRight());
            System.out.print(t.getValue() + " ");
        }
    }

    public int sum() {
        return sumRec(root);
    }

    private int sumRec(TreeNode cur) {
        if(cur == null) {
            return 0;
        }
        return sumRec(cur.left) + cur.getValue() + sumRec(cur.right);
    }

    public boolean find(int val) {
        return findRec(root, val);
    }

    private boolean findRec(TreeNode cur, int val) {
        if(cur == null) {
            return false;
        }

        if(cur.data == val) {
            return true;
        }

        boolean checkLeft = findRec(cur.getLeft(), val);
        boolean checkRight = findRec(cur.getRight(), val);

        return checkLeft || checkRight;
    }

    public int getMax() throws TreeEmptyException {
        if(root == null) {
            throw new TreeEmptyException();
        }

        return getMaxRec(root);
    }

    private int getMaxRec(TreeNode cur) {
        int maxValue = cur.data;

        if (cur.left != null) {
            int maxLeft = getMaxRec(cur.left);
            if (maxLeft > maxValue) {
                maxValue = maxLeft;
            }
        }

        if (cur.right != null) {
            int maxRight = getMaxRec(cur.right);
            if (maxRight > maxValue) {
                maxValue = maxRight;
            }
        }

        return maxValue;
    }
    
    /*
     * Purpose: returns a String reprensentation of this BinaryTree
     * Parameters: none
     * Returns: String - the representation
     */
    public String toString() {
        return toString(root);
    }
    
    private String toString(TreeNode t) {
        if(t==null) {
            return "";
        } else {
            String s = "";
            
            s += toString(t.getLeft());
            s += t.getValue() + " ";
            s += toString(t.getRight());
            
            return s;
        }
    }
    
    
    public static void main(String[] args) {
        // use these trees to test the methods you will implement in Part II
        RefBasedBinaryTree emptyTree = new RefBasedBinaryTree();
        RefBasedBinaryTree myTree = new RefBasedBinaryTree();
        for(int i=2; i<8; i++) {
            myTree.insert(i);
        }

        System.out.println("Sum is: " + myTree.sum());

        System.out.println("Finding 10, should be false");
        System.out.println(myTree.find(10));

        System.out.println("Finding 3, should be true");
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
