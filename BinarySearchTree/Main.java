package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(70);
        binarySearchTree.insert(50);
        binarySearchTree.insert(90);
        binarySearchTree.insert(30);
        binarySearchTree.insert(60);
        binarySearchTree.insert(80);
        binarySearchTree.insert(100);
        binarySearchTree.insert(20);
        binarySearchTree.insert(40);

//        binarySearchTree.levelOrder(binarySearchTree.root);
//        System.out.println();
//        binarySearchTree.preOrder(binarySearchTree.root);
//        System.out.println();
//        binarySearchTree.inOrder(binarySearchTree.root);
//        System.out.println();
//        binarySearchTree.postOrder(binarySearchTree.root);

//        binarySearchTree.search(binarySearchTree.root, 200);
        binarySearchTree.levelOrder();
        System.out.println();
        binarySearchTree.delete(binarySearchTree.root, 20);
        binarySearchTree.levelOrder();
    }

}
