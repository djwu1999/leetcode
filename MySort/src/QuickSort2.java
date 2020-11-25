import java.util.Arrays;
import java.util.Random;

public class QuickSort2 {

    public static void quickSort2(int[] arr) {
        quickSort2(arr, 0, arr.length - 1);
    }

    private static void quickSort2(int[] arr, int l, int r) {
        /*if (r - l <= 15) {
            InsertSort.insertSort(arr, l, r);
            return;
        }*/
        if (l >= r)
            return;
        int p = partition(arr, l, r);
        quickSort2(arr, l, p - 1);
        quickSort2(arr, p + 1, r);
    }

    private static int partition(int[] arr, int l, int r) {
        int rand = new Random().nextInt(r - l) + l;
        swap(arr, l, rand);
        int v = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v)
                i++;
            while (j >= l + 1 && arr[j] > v)
                j--;
            if (i > j || i == r || j == l + 1)
                break;
            swap(arr, i++, j--);
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {9, 2, 1, 2, 3, 4, 1, 5};
//        int[] arr = SortTestHelper.generateRandomArray(1000000, 0, 10);
        int[] arr = SortTestHelper.generateRandomArray(10000, 0, 100);
//        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        quickSort2(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(end - begin);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}
