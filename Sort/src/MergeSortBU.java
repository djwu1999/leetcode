import java.util.Arrays;

public class MergeSortBU {

    public static void mergeSortBU(int[] arr) {
        for (int size = 1; size < arr.length; size += size)
            for (int i = 0; i + size < arr.length; i += 2 * size) {
                merge(arr, i, i + size - 1, Math.min(i + size + size - 1, arr.length - 1));
            }
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
        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        mergeSortBU(arr);
        long end = System.currentTimeMillis();
//        for (int i : arr) {
//            System.out.println(i);
//        }
        System.out.println(isSorted(arr));
        System.out.println("消耗时间为 : " + (end - begin) + "ms");

    }

}
