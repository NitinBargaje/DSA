package AVLTree;

public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        avlTree.insert(5);
        avlTree.insert(10);
        avlTree.insert(15);
        avlTree.insert(20);

        avlTree.levelOrder();
        avlTree.delete(5);
        System.out.println();
        avlTree.levelOrder();
    }
}
