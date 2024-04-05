import java.util.ArrayList;
public class PQ{
    //implement the class of priority queue using min heap and arraylist
    private ArrayList<Integer> heap;

    public PQ(){
        heap = new ArrayList<Integer>();
    }
    public void add(int item){
        //add the item to the heap
        heap.add(item);
        int childIndex = heap.size()-1;
        int parentIndex = (childIndex-1)/2;

        while(childIndex > 0){
            if(heap.get(childIndex) < heap.get(parentIndex)){
                int temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            }else{
                return;
            }//end if
        }//end while
    }//end add
    //implement the remove method
    public int remove(){
        //remove the root of the heap
        if(heap.size() == 0){
            return -1;
        }
        int temp = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        while(leftChildIndex < heap.size()){
            int minIndex = parentIndex;
            if(heap.get(leftChildIndex) < heap.get(minIndex)){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)){
                minIndex = rightChildIndex;
            }
            if(minIndex == parentIndex){
                break;
            }
            int temp2 = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp2);
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex + 1;
            rightChildIndex = 2*parentIndex + 2;
        }
        return temp;
    }//end remove
    public int size(){
        return heap.size();
    }
    public boolean isEmpty(){
        return heap.size() == 0;
    }
    // public int getMin(){
    //     if(heap.size() == 0){
    //         return -1;
    //     }
    //     return heap.get(0);
    // }
    public void print(){
        for(int i = 0; i < heap.size(); i++){
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
    //implement the main method
    public static void main(String[] args){
        PQ pq = new PQ();
        //add 1-10 in ascending order in random order
        pq.add(10);
        pq.add(6);
        pq.add(3);
        pq.add(8);
        pq.add(5);
        pq.add(2);
        pq.add(7);
        pq.add(4);
        pq.add(9);
        pq.add(1);

       
        pq.print();
        System.out.println(pq.remove());
        pq.print();
        System.out.println(pq.remove());
        pq.print();
        System.out.println(pq.remove());
        pq.print();
        System.out.println(pq.remove());
        pq.print();
        System.out.println(pq.remove());
        pq.print();
        System.out.println(pq.remove());
        pq.print();
        System.out.println(pq.remove());
        pq.print();
        System.out.println(pq.remove());
        pq.print();


        while(!pq.isEmpty()){
            System.out.println(pq.remove());
        }

    }
    //arraylist .set(


}