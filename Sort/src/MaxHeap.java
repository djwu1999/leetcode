import java.util.Random;

public class MaxHeap {
    private int[] data;

    private int count;

    private int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(int[] arr) {
        data = new int[arr.length + 1];
        capacity = arr.length;
        for (int i = 0; i < arr.length; i++)
            data[i + 1] = arr[i];
        count = arr.length;
        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    int size(){
        return count;
    }

    boolean isEmpty() {
        return count == 0;
    }

    void insert(int e) {
        if(count + 1 > capacity)
            throw new IllegalArgumentException("越界");
        data[++count] = e;
        shiftUp(count);
    }

    int remove() {
        if (count < 1)
            throw new IllegalArgumentException("空堆");
        int res = data[1];

        swap(data, 1, count --);
        shiftDown(1);

        return res;
    }

    private void shiftDown(int k) {
        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1] > data[j])
                j += 1;
            if (data[k] >= data[j])
                break;
            swap(data, k, j);
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }

    private void swap(int[] data, int i, int k) {
        int temp = data[i];
        data[i] = data[k];
        data[k] = temp;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        int level = 1;
        for (int i = 1; i <= this.count; i++) {
            sb.append(data[i] + " ");
            if (i == (Math.pow(2, level) - 1)) {
                sb.append("\r\n");
                level ++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(100);
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            heap.insert(rand.nextInt(100));
        }
        System.out.println(heap.print());

        while (!heap.isEmpty()) {
            System.out.println(heap.remove());
        }
    }

}
