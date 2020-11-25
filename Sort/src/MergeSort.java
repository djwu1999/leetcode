import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] arr) {
        mergePart(arr, 0, arr.length - 1);
    }

    private static void mergePart(int[] arr, int l, int r) {
//        if(l >= r)
//            return;

        if (r - l <= 15) {
            InsertionSort.insertionSort1(arr, l, r);
            return;
        }
        int mid = (l + r) / 2;
        mergePart(arr, l, mid);
        mergePart(arr, mid + 1, r);
        if(arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);
        int lIndex = 0, rIndex = mid - l + 1;
        for (int i = l; i <= r; i++) {
            if (lIndex > mid - l)
                arr[i] = aux[rIndex++];
            else if (rIndex > r - l)
                arr[i] = aux[lIndex++];
            else if (aux[lIndex] < aux[rIndex])
                arr[i] = aux[lIndex++];
            else
                arr[i] = aux[rIndex++];
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /*int[] arr = SortTestHelper.generateRandomArray(1000000, 0, 100000);
        long begin = System.currentTimeMillis();
        mergeSort(arr);
        long end = System.currentTimeMillis();
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(isSorted(arr));
        System.out.println("消耗时间为 : " + (end - begin) + "ms");*/

        int[] arr = SortTestHelper.getSortedArray(10000000);
//        int[] arr = SortTestHelper.generateRandomArray(10000000, 0, 10000000);
        long begin = System.currentTimeMillis();
        mergeSort(arr);
        long end = System.currentTimeMillis();
//        Arrays.stream(arr).forEach(System.out::println);
        System.out.println(isSorted(arr));
        System.out.println("消耗时间为 : " + (end - begin) + "ms");

    }

}
