import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort1(int[] arr){
        insertionSort1(arr, 0, arr.length - 1);
    }

    public static void insertionSort1(int[] arr, int l, int r){
        for (int i = l + 1; i <= r; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > l && arr[j - 1] > temp; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static void swap(int[] arr, int begin, int end) {
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args) {
        /*int[] arr = SortTestHelper.generateRandomArray(100000, 1, 100000);
        int[] arr1 = arr.clone();

        long begin = System.currentTimeMillis();
        insertionSort(arr);
        long end = System.currentTimeMillis();
        long begin1 = System.currentTimeMillis();
        insertionSort(arr);
        long end1 = System.currentTimeMillis();

        Arrays.stream(arr1).forEach(System.out::println);
        System.out.println("消耗时间为 : " + (end1 - begin1) + "ms");
        System.out.println(isSorted(arr));
        System.out.println("==================================");
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println("消耗时间为 : " + (end - begin) + "ms");
        System.out.println(isSorted(arr1));*/

        int[] arr = SortTestHelper.generateRandomArray(100000, 1, 100000);
//        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        insertionSort1(arr, 0, arr.length - 1);
        System.out.println(isSorted(arr));
        Arrays.stream(arr).forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("消耗时间为 : " + (end - begin) + "ms");
    }
}
