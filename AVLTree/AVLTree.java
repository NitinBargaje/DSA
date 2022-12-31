package AVLTree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    BinaryNode root;

    AVLTree() {
        root = null;
    }

    public void preOrder(BinaryNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.value + " -> ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(BinaryNode root) {
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.value + " -> ");
        inOrder(root.right);
    }

    public void postOrder(BinaryNode root) {
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value+ " -> ");
    }

    public void levelOrder() {
        if(root == null) {
            System.out.println("AVL Tree is empty");
            return;
        }
        Queue<BinaryNode> binaryNodes = new LinkedList<BinaryNode>();
        binaryNodes.add(root);
        while(!binaryNodes.isEmpty()) {
            BinaryNode presentNode = binaryNodes.remove();
            System.out.print(presentNode.value + " -> ");
            if(presentNode.left != null) binaryNodes.add(presentNode.left);
            if(presentNode.right != null) binaryNodes.add(presentNode.right);
        }
    }

    public BinaryNode search(BinaryNode root, int value) {
        if(root == null) {
            System.out.println("Given value is not present in AVL tree");
            return null;
        }
        if(value < root.value) {
            return search(root.left, value);
        } else if (value > root.value) {
            return search(root.right, value);
        } else {
            System.out.println("Given value is found in AVL Tree");
            return root;
        }
    }

    public int getHeight(BinaryNode node) {
        if(node == null) return 0;
        return node.height;
    }

    // Rotate right
    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // Rotate Left
    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    // get Balance
    public int getBalance(BinaryNode node) {
        if(node == null) return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if(node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        }
        if(nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else {
            node.right = insertNode(node.right, nodeValue);
        }
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if(balance > 1 && nodeValue < node.left.value) {
            return rotateRight(node);
        }
        if(balance > 1 && nodeValue > node.left.value) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance < -1 && nodeValue > node.right.value) {
            return rotateLeft(node);
        }
        if(balance < -1 && nodeValue < node.right.value) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    public BinaryNode minimumNode(BinaryNode root) {
        if(root.left == null) return root;
        return minimumNode(root.left);
    }

    private BinaryNode deleteNode(BinaryNode node, int value) {
        if(node == null) {
            System.out.println("Value "+ value + " is not found in AVL tree");
            return null;
        }
        if(value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {
            if(node.left != null && node.right != null) {
                int successorValue = minimumNode(node.right).value;
                node.value = successorValue;
                node.right = deleteNode(node.right, successorValue );
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }

//        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if(balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }
        if(balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if(balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }
        if(balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return  node;
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

    public void deleteAVL() {
        root = null;
        System.out.println("AVL Tree has been successfully deleted");
    }
}
