package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    //Insert Method - Time complexity: O(LogN), Space complexity: O(LogN)
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if(currentNode == null) {
            BinaryNode binaryNode = new BinaryNode(value);
            System.out.println("The value successfully inserted!");
            return binaryNode;
        }
        if(value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insert(int value) {
        root = insert(root, value);
    }

    /*** Traversal Methods for Binary Search Tree
     * Depth First Search:
     *  - PreOrder Traversal
     *  - InOrder Traversal
     *  - PostOrder Traversal
     *
     *  Breadth First Search:
     *  - level Order Traversal
     */
    
    // PreOrder: Root Node -> Left Subtree -> Right Subtree
    public void preOrder(BinaryNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value+ " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // InOrder: Left Subtree -> Root Node -> Right Subtree
    public void inOrder(BinaryNode root) {
        if(root == null ) return;
        inOrder(root.left);
        System.out.print(root.value + " -> ");
        inOrder(root.right);
    }

    // PostOrder: Left Subtree -> Right Subtree -> Root Node
    public void postOrder(BinaryNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " -> ");
    }

    public void levelOrder() {
        if(root == null) return;
        Queue<BinaryNode> binaryNodes = new LinkedList<BinaryNode>();
        binaryNodes.add(root);
        while(!binaryNodes.isEmpty()) {
            BinaryNode presentNode = binaryNodes.remove();
            System.out.print(presentNode.value + " -> ");
            if(presentNode.left != null) binaryNodes.add(presentNode.left);
            if(presentNode.right != null) binaryNodes.add(presentNode.right);
        }
    }

    //Search Method
    public BinaryNode search(BinaryNode root, int value) {
        if(root == null) {
            System.out.println("This value is not present in Binary Search Tree");
            return null;
        }
        if(root.value == value) {
            System.out.println("This value is present in BST");
            return root;
        }
        if(value < root.value) return search(root.left, value);
        else return search(root.right, value);
    }

    private BinaryNode minimumNode(BinaryNode node) {
        if(node.left == null) return node;
        else return minimumNode(node.left);
    }

    public BinaryNode delete(BinaryNode root, int value) {
        if(root == null) {
            System.out.println("Value is not found in binary search tree");
            return null;
        }
        if(value < root.value) root.left = delete(root.left, value);
        else if (value > root.value) root.right = delete(root.right, value);
        else {
            if(root.left != null && root.right != null) {
                int successorValue = minimumNode(root.right).value;
                root.value = successorValue;
                delete(root.right, successorValue);
            } else if(root.left != null) {
                root = root.left;
            } else if(root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
            return root;
    }

    public void deleteBST() {
        root = null;
        System.out.println("Binary search tree deleted successfully");
    }
}
