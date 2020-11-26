import java.util.Arrays;
import java.util.Random;

public class QuickSort3 implements Sort {

    public void sort(int[] arr) {
        quickSort3(arr, 0, arr.length - 1);
    }

    private static void quickSort3(int[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertSort.insertSort(arr, l, r);
            return;
        }
        /*if (l >= r)
            return;*/
        int rand = new Random().nextInt(r - l) + l;
        swap(arr, l, rand);
        int v = arr[l];
        int lt = l, gt = r + 1, i = l + 1;
        while (i < gt) {
            if (arr[i] < v)
                swap(arr, i++, ++lt);
            else if (arr[i] > v)
                swap(arr, i, --gt);
            else
                i++;
        }
        swap(arr, l, lt);
        quickSort3(arr, l, lt - 1);
        quickSort3(arr, gt, r);
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {9, 2, 1, 2, 3, 4, 1, 5};
        int[] arr = SortTestHelper.generateRandomArray(1000000, 0, 10);
//        int[] arr = SortTestHelper.generateRandomArray(10000, 0, 100);
//        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        new QuickSort().sort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(end - begin);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}
