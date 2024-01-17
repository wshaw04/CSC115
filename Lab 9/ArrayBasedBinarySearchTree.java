public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree {

    public void insert(Integer value) {
        if(data[root] == null) {
            data[root] = value;
        }
        else {
            insertRec(value);
        }
    }

    private void insertRec(Integer value) {
        int cur = root;

        while(data[cur] != null) {
            if(value < data[cur]) {
                cur = getLeft(cur);
            }
            else {
                cur = getRight(cur);
            }
        }
        data[cur] = value;
    }
    
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
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
    }

}
