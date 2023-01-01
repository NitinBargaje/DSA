package BinaryHeap;

public class Main {
    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap(5);
//        System.out.println(binaryHeap.peek());
        binaryHeap.levelOrder();
        binaryHeap.insert(10, "MIN");
        binaryHeap.insert(5, "MIN");
        binaryHeap.insert(15, "MIN");
        binaryHeap.insert(1, "MIN");

        binaryHeap.levelOrder();
        binaryHeap.extractHeadOfBinaryHeap("MIN");
        binaryHeap.levelOrder();
        binaryHeap.extractHeadOfBinaryHeap("MIN");
        binaryHeap.levelOrder();
        binaryHeap.extractHeadOfBinaryHeap("MIN");
        binaryHeap.levelOrder();
        binaryHeap.extractHeadOfBinaryHeap("MIN");
        binaryHeap.levelOrder();
    }
}
