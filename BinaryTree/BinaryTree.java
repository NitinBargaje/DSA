package BinaryTree;

public class BinaryTree {
    String arr[];
    int lastUsedIndex;

    public BinaryTree(int size) {
        arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Blank tree of size "+size+" has been created");
    }

    boolean isFull() {
        if(arr.length - 1 == lastUsedIndex) return true; else return false;
    }

    //insert method
    public void insert(String value) {
        if(isFull()) {
            System.out.println("Binary Tree is full, can not insert new element in BT!");
            return;
        }
        arr[++lastUsedIndex] = value;
        System.out.println("The value of "+value+" is succussfully inserted!");
    }

    //Pre Order : Root Node -> Left Subtree -> Right Subtree
    public void preOrder(int rootIndex) {
        if(rootIndex > lastUsedIndex) {
            return;
        }
        System.out.print(arr[rootIndex]+ " -> ");
        preOrder(2 * rootIndex);
        preOrder(2 * rootIndex + 1);
    }

    public void inOrder(int rootIndex) {
        if(rootIndex > lastUsedIndex) return;
        inOrder(2 * rootIndex);
        System.out.print(arr[rootIndex]+ " -> ");
        inOrder(2 * rootIndex + 1);
    }

    public void postOrder(int rootIndex) {
        if(rootIndex > lastUsedIndex) return;
        postOrder(2 * rootIndex);
        postOrder(2 * rootIndex + 1);
        System.out.print(arr[rootIndex]+ " -> " );
    }

    public void levelOrder(int rootIndex) {
        for(int i = 1; i < lastUsedIndex; i++) {
            System.out.print(arr[i]+ " -> ");
        }
        System.out.print(arr[lastUsedIndex]);
    }

    public int search(String value) {
        for(int i = 1; i <= lastUsedIndex; i++){
            if(arr[i] == value) return i;
        }
        return -1;
    }

    //Delete Method
    public void delete(String value) {
        int index = search(value);
        if(index != -1) {
            arr[index] = arr[lastUsedIndex];
            arr[lastUsedIndex] = null;
            lastUsedIndex--;
            System.out.println("This value is deleted successfully!");
        } else {
            System.out.println("This value is not present in BT");
        }
    }

    public void deleteBT() {
        arr = null;
        System.out.println("Tree has been successfully deleted!");
    }
}
