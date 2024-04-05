public class MinHeapPriorityQueue<T extends Comparable<T>> {
    private class Node {
        private T data;
        private int priority;
        private Node next;

        public Node(T data, int priority) {
            this.data = data;
            this.priority = priority;
            this.next = null;
        }
    }

    private Node head;

    public MinHeapPriorityQueue() {
        head = null;
    }

    public void enqueue(T data, int priority) {
        Node newNode = new Node(data, priority);

        if (head == null) {
            head = newNode;
        } else if (newNode.priority < head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null && current.next.priority <= newNode.priority) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public T dequeue() {
        if (head == null) {
            return null;
        }

        T data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int size = 0;
        Node current = head;

        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    public T peek() {
        if (head == null) {
            return null;
        }

        return head.data;
    }

    public void print(){
        while(!isEmpty()){
            System.out.print(dequeue()+" ");
        }
    }

    public static void main(String[] args) {
        MinHeapPriorityQueue a = new MinHeapPriorityQueue();
        a.enqueue(12,2);
        a.enqueue(11,4);
        a.enqueue(16,1);
        a.enqueue(4,7);
        a.enqueue(55,8);
        a.enqueue(122,233);
        a.print();
    }
}