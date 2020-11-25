import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    /**
     * initialize your data structure here.
     */
    private Queue<Integer> left;
    private Queue<Integer> right;
    private int count = 0;


    public MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if ((count & 1) == 1) {
            right.add(num);
            left.add(right.peek());
        }
        if((count & 1) == 0) {
            left.add(num);
            right.add(left.remove());
        }
        count ++;
    }

    public double findMedian() {
        if(count == 0)
            return 0.0;
        if((count & 1) == 1)
            return left.peek() * 1.0;
        else
            return (left.peek() + right.peek()) / 2.0;
    }
}