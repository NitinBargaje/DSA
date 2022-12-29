package BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTreeLL<String> stringBinaryTreeLL = new BinaryTreeLL<>();
        /**
        BinaryNode<String> n1 = new BinaryNode<>();
        n1.value = "N1";
        BinaryNode<String> n2 = new BinaryNode<>();
        n2.value = "N2";
        BinaryNode<String> n3 = new BinaryNode<>();
        n3.value = "N3";
        BinaryNode<String> n4 = new BinaryNode<>();
        n4.value = "N4";
        BinaryNode<String> n5 = new BinaryNode<>();
        n5.value = "N5";
        BinaryNode<String> n6 = new BinaryNode<>();
        n6.value = "N6";
        BinaryNode<String> n7 = new BinaryNode<>();
        n7.value = "N7";
        BinaryNode<String> n8 = new BinaryNode<>();
        n8.value = "N8";
        BinaryNode<String> n9 = new BinaryNode<>();
        n9.value = "N9";

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;
        stringBinaryTreeLL.root = n1;
        ***/

        stringBinaryTreeLL.insert("N1");
        stringBinaryTreeLL.insert("N2");
        stringBinaryTreeLL.insert("N3");
        stringBinaryTreeLL.insert("N4");
        stringBinaryTreeLL.insert("N5");
        stringBinaryTreeLL.insert("N6");
        stringBinaryTreeLL.insert("N7");
        stringBinaryTreeLL.insert("N8");
        stringBinaryTreeLL.insert("N9");
//        stringBinaryTreeLL.preOrderTraversal(stringBinaryTreeLL.root);
//        stringBinaryTreeLL.inOrder(stringBinaryTreeLL.root);
//        stringBinaryTreeLL.postOrder(stringBinaryTreeLL.root);
        stringBinaryTreeLL.levelOrder(stringBinaryTreeLL.root);
        stringBinaryTreeLL.deleteNode("N3");
        stringBinaryTreeLL.levelOrder(stringBinaryTreeLL.root);

        stringBinaryTreeLL.deleteBinaryTree();
    }
}
