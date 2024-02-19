package model;

import java.util.PriorityQueue;

public class MinHeap {
    private PriorityQueue<Integer> minHeap;

    public MinHeap(int maxSize) {
        minHeap = new PriorityQueue<>();
        for (int i = 0; i < maxSize; i++) {
            minHeap.add(i);
        }
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }

    public int poll() {
        return minHeap.poll();
    }

    public void add(int slotNumber) {
        minHeap.add(slotNumber);
    }
}