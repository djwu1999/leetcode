import java.util.Random;

public class QuickSort2 {
    public static void quickSort2(int[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int l, int r) {
        if(l >= r)
            return;
        if (r - l <= 15) {
            InsertionSort.insertionSort1(arr, l, r);
            return;
        }
        int p = partition2(arr, l, r);
        quickSort2(arr, l, p - 1);
        quickSort2(arr, p + 1, r);
    }

    private static int partition2(int[] arr, int l, int r) {

        int rand = new Random().nextInt(r - l) + l;
        swap(arr, l, rand);

        int v = arr[l];

        int lIndex = l + 1, rIndex = r;

        while (true) {
            while(lIndex <= r && arr[lIndex] < v)
                lIndex ++;
            while(rIndex >= l + 1 && arr[rIndex] > v)
                rIndex --;
            if(lIndex > rIndex)
                break;
            swap(arr, lIndex, rIndex);
            lIndex ++;
            rIndex --;
        }
        swap(arr, l, rIndex);
        return rIndex;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] arr = SortTestHelper.generateRandomArray(10000000, 0, 100000);
        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        quickSort2(arr);
        long end = System.currentTimeMillis();
        /*for (int i : arr) {
            System.out.println(i);
        }*/
        System.out.println(isSorted(arr));
        System.out.println("消耗时间为 : " + (end - begin) + "ms");
    }
}
