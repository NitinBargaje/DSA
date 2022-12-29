package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL<T> {
    BinaryNode<T> root;

    public BinaryTreeLL() {
        root = null;
    }

    //Preorder Traversal: root -> left subtree -> right subtree
    public void preOrderTraversal(BinaryNode<T> root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrder(BinaryNode<T> root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " -> ");
        inOrder(root.right);
    }

    public void postOrder(BinaryNode<T> root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " -> ");
    }

    public void levelOrder(BinaryNode<T> root) {
        Queue<BinaryNode<T>> binaryNodes = new LinkedList<>();
        binaryNodes.add(root);
        while (!binaryNodes.isEmpty()) {
            BinaryNode<T> currentNode = binaryNodes.remove();
            System.out.print(currentNode.value + " -> ");
            if(currentNode.left != null) binaryNodes.add(currentNode.left);
            if(currentNode.right != null) binaryNodes.add(currentNode.right);
        }
    }

    public void insert(T value) {
        BinaryNode<T> tBinaryNode = new BinaryNode<>();
        tBinaryNode.value = value;
        if(root == null) {
            root = tBinaryNode;
            System.out.println("New node added successfully!");
            return;
        }
        Queue<BinaryNode<T>> binaryNodes = new LinkedList<>();
        binaryNodes.add(root);
        while (!binaryNodes.isEmpty()) {
            BinaryNode<T> currentNode = binaryNodes.remove();
            if(currentNode.left == null) {
                currentNode.left = tBinaryNode;
                System.out.println("New node added successfully!");
                break;
            } else if (currentNode.right == null) {
                currentNode.right = tBinaryNode;
                System.out.println("New node added successfully!");
                break;
            } else {
                binaryNodes.add(currentNode.left);
                binaryNodes.add(currentNode.right);
            }
        }
    }

    public BinaryNode<T> getDeepestNode() {
        Queue<BinaryNode<T>> binaryNodes = new LinkedList<>();
        binaryNodes.add(root);
        BinaryNode<T> presentNode = null;
        while(!binaryNodes.isEmpty()) {
            presentNode = binaryNodes.remove();
            if(presentNode.left != null)  binaryNodes.add(presentNode.left);
            if(presentNode.right != null) binaryNodes.add(presentNode.right);
        }
        return presentNode;
    }

    public void deleteDeepestNode() {
        Queue<BinaryNode<T>> binaryNodes = new LinkedList<>();
        binaryNodes.add(root);
        BinaryNode<T> previousNode, presentNode = null;
        while (!binaryNodes.isEmpty()) {
            previousNode = presentNode;
            presentNode = binaryNodes.remove();
            if(presentNode.left == null) {
                previousNode.right = null;
                System.out.println("Deepest Node deleted!");
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                System.out.println("Deepest Node deleted!");
                return;
            } else {
                binaryNodes.add(presentNode.left);
                binaryNodes.add(presentNode.right);
            }
        }
    }

    public void deleteNode(T value) {
        Queue<BinaryNode<T>> binaryNodes = new LinkedList<>();
        binaryNodes.add(root);
        while(!binaryNodes.isEmpty()) {
            BinaryNode<T> presentNode = binaryNodes.remove();
            if(presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("Node deleted successfully!");
                return;
            }
            if(presentNode.left != null) binaryNodes.add(presentNode.left);
            if(presentNode.right != null) binaryNodes.add(presentNode.right);
        }
        System.out.println("Node with value = " + value + " not found in Binary Tree");
    }

    public void deleteBinaryTree() {
        root = null;
        System.out.println("\nBinary Tree has been deleted successfully");
    }
}
