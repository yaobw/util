package algorithm.structure;

import java.util.Arrays;

/**
 * @description: the BinaryHeap is a complete binary tree . Also the value of node in binaryHeap always bigger than other children.
 * @author: yaobw
 * @date: 2020/8/10 7:31 下午
 */
public class BinaryHeap {

    /**
     * X叉堆
     */
    private static final int furcation = 2;

    private int[] heap;

    private int heapSize;

    /**
     * This will init heap with default size
     *
     * @param capacity
     */
    public BinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    /**
     * @param i
     * @return
     */
    private int parent(int i) {
        return (i - 1) / furcation;
    }

    /**
     * @param i the number of sorted root
     * @param k the number of son under this root
     * @return
     */
    private int kThChild(int i, int k) {
        return furcation * i + k;
    }

    /**
     * Big O is at least logn, the best is O(1)
     *
     * @param x the number of insert
     */
    public void insert(int x) throws Exception {
        if (isFull()) {
            throw new Exception("Heap is full. No space to insert the new number");
        }
        heap[heapSize] = x;
        heapSize++;
        heapifyUp(heapSize - 1);
    }

    /**
     * delete the element which is at the index of x
     * the Big O is O(logn)
     * @param i
     * @return
     * @throws Exception
     */
    public int delete(int i) throws Exception{
        if(isEmpty()){
            throw  new Exception("Heap is empty, No element to delete");
        }
        int maxElement = heap[i];
        heap[i] = heap[heapSize -1];
        heapSize--;
        heapifyDown(i);
        return maxElement;
    }

    /**
     * the Big O is O(logn)
     * Maintains the heap property while inserting an element
     * process: the number will compare to every fatherNode, when it is less than the node.And every step there will be exchange the position of  fatherNode and number.
     * @param i
     */
    private void heapifyUp(int i) {
        int insertValue = heap[i];
        while (i > 0 && insertValue > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = insertValue;
    }

    /**
     * the Big O is O(logn)
     * Maintains the heap property while deleting an element
     * @param i
     */
    private void heapifyDown(int i){
        int child;
        int temp = heap[i];
        while(kThChild(i, 1) < heapSize){
            child = maxChild(i);
            if(temp >= heap[child]){
                break;
            }
            heap[i] = heap[child];
            i = child;
        }
        heap[i] = temp;
    }

    private int maxChild(int i){
        int leftChild = kThChild(i,1);
        int rightChild = kThChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    public void printHeap(){
        System.out.println("Heap is ");
        for(int i = 0; i < heapSize; i++){
            System.out.println(heap[i] + "");
        }
    }

    public int findMax() throws Exception {
        if(isEmpty()){
            throw  new Exception("");
        }
        return heap[0];
    }

    public static void main(String[] args) throws Exception {
        BinaryHeap maxHeap = new BinaryHeap(10);
        maxHeap.insert(10);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(1);
        maxHeap.insert(7);
        maxHeap.insert(5);
        maxHeap.insert(3);


        maxHeap.printHeap();
        maxHeap.delete(5);
        maxHeap.printHeap();
        maxHeap.delete(2);
        maxHeap.printHeap();
    }

}
