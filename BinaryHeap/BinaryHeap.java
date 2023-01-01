package BinaryHeap;

public class BinaryHeap {
    int arr[];
    int sizeOfTree;

    public BinaryHeap(int size) {
        arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap has been created");
    }

    public boolean isEmpty() {
        if(sizeOfTree == 0) return true;
        return false;
    }

    public Integer peek() {
        if(isEmpty()) {
            System.out.println("Binary Heap is Empty");
            return null;
        } else {
            return arr[1];
        }
    }

    public int sizeOfBinaryHeap() {
        return sizeOfTree;
    }

    public void levelOrder() {
        if(!isEmpty()) {
            for(int i = 1; i <= sizeOfTree; i++) {
                System.out.print(arr[i] + " -> ");
            }
            System.out.println();
        }
    }

    private void heapifyBottomToTop(int index, String heapType) {
        if(index > 0 && index <= sizeOfTree) {
            if(index <= 1) return;
            int parentIndex = index/2;
            switch (heapType) {
                case "MIN":
                    if(arr[parentIndex] > arr[index]) {
                        int temp = arr[parentIndex];
                        arr[parentIndex] = arr[index];
                        arr[index] = temp;
                    }
                    break;
                case "MAX":
                    if(arr[parentIndex] < arr[index]) {
                        int temp = arr[parentIndex];
                        arr[parentIndex] = arr[index];
                        arr[index] = temp;
                    }
                    break;
                default:
                    System.out.println("Heap Type not configured");
            }
            heapifyBottomToTop(parentIndex, heapType);
        }
    }

    public void insert(int value, String heapType) {
        arr[++sizeOfTree] = value;
        heapifyBottomToTop(sizeOfTree, heapType);
    }

    public void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;
        int swapChild;
        if(left > sizeOfTree) return;
        if(heapType == "MAX") {
               if(left == sizeOfTree) {
                   if(arr[left] > arr[index]) {
                       int temp = arr[left];
                       arr[left] = arr[index];
                       arr[index] = temp;
                   }
                   return;
               } else {
                   if(arr[left] > arr[right]) {
                       swapChild = left;
                   } else {
                       swapChild = right;
                   }
                   if(arr[swapChild] > arr[index]) {
                   int temp = arr[swapChild];
                   arr[swapChild] = arr[index];
                   arr[index] = temp;
                   heapifyTopToBottom(swapChild,heapType);
                   }
               }
        } else if(heapType == "MIN") {
            if(left == sizeOfTree) {
                if(arr[left] < arr[index]) {
                    int temp = arr[left];
                    arr[left] = arr[index];
                    arr[index] = temp;
                }
                return;
            } else {
                if(arr[left] < arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if(arr[swapChild] < arr[index]) {
                int temp = arr[swapChild];
                arr[swapChild] = arr[index];
                arr[index] = temp;
                heapifyTopToBottom(swapChild,heapType);
                }
            }
        }
    }

    public Integer extractHeadOfBinaryHeap(String heapType) {
        if(isEmpty()) {
            System.out.println("Binary Heap is empty");
            return null;
        } else {
            int top = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return top;
        }
    }

    public void deleteBinaryHeap() {
        arr = null;
        System.out.println("Binary Heap is deleted successfully");
    }
}
