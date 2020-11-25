import java.util.Random;

public class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l >= r)
            return;
        if (r - l <= 15) {
            InsertionSort.insertionSort1(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {

        int rand = new Random().nextInt(r - l) + l;
        swap(arr, l, rand);

        int v = arr[l];

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if(arr[i] < v)
                swap(arr, ++j, i);
        }
        swap(arr, l, j);
        return j;
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
        int[] arr = SortTestHelper.generateRandomArray(500000, 0, 10);
//        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        quickSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(isSorted(arr));
        System.out.println("消耗时间为 : " + (end - begin) + "ms");
    }
}