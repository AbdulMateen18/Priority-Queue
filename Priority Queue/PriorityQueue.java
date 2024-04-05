import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Integer> heap;

    public PriorityQueue() {
        heap = new LinkedList<>();
    }

    public void add(int item) {
        heap.add(item);
        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0 && heap.get(childIndex) > heap.get(parentIndex)) {
            int temp = heap.get(childIndex);
            heap.set(childIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);

            childIndex = parentIndex;
            parentIndex = (childIndex - 1) / 2;
        }
    }

    public int remove() {
        if (heap.isEmpty()) {
            return -1;
        }

        int root = heap.getFirst();
        heap.set(0, heap.getLast());
        heap.removeLast();

        int parentIndex = 0;
        while (true) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;

            if (leftChildIndex >= heap.size()) {
                break;
            }

            int maxIndex = leftChildIndex;
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex) > heap.get(leftChildIndex)) {
                maxIndex = rightChildIndex;
            }

            if (heap.get(parentIndex) < heap.get(maxIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(maxIndex));
                heap.set(maxIndex, temp);

                parentIndex = maxIndex;
            } else {
                break;
            }
        }

        return root;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void printQueue() {
        System.out.print("Priority Queue: ");
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(1);
        pq.add(2);
        pq.add(9);
        pq.add(4);
        pq.add(7);
        pq.add(3);
        pq.add(5);

        pq.printQueue();

        while (!pq.isEmpty()) {
            int max = pq.remove();
            System.out.println(max);
        }
    }
}
