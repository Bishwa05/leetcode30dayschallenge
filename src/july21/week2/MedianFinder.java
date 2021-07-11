package july21.week2;

import java.util.Collections;
import java.util.PriorityQueue;


public class MedianFinder
{
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder(){

    }

    public void addNum(int num){
        if(maxHeap.isEmpty() || num<= maxHeap.peek()){
            maxHeap.add(num);
            if(maxHeap.size() == minHeap.size()+2){
                minHeap.add(maxHeap.poll());
            }
        } else {
            minHeap.add(num);
            if(minHeap.size() > maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian(){
        if(maxHeap.size()> minHeap.size()) return maxHeap.peek();
        return (maxHeap.peek() + minHeap.peek())/2.0d;
    }
}
