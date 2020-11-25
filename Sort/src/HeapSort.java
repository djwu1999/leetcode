public class HeapSort {
    public static void heapSort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            shiftDown(arr,arr.length,  i);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
    }

    private static void shiftDown(int[] arr,int n, int k) {
        while (2 * k + 1 < n) {
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j])
                j += 1;
            if (arr[k] >= arr[j])
                break;
            swap(arr, k, j);
            k = j;
        }
    }

    private static void swap(int[] arr, int begin, int end) {
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray(10000000, 0, 100000);
        long begin = System.currentTimeMillis();
        heapSort(arr);
        long end = System.currentTimeMillis();

        int[] arr1 = SortTestHelper.getSortedArray(10000000);
        int[] arr2 = new int[arr1.length];
        int index = 0;
        for (int i = arr2.length - 1; i >= 0; i--) {
            arr2[i] = arr1[index ++];
        }
        long begin1 = System.currentTimeMillis();
        heapSort(arr1);
        long end1 = System.currentTimeMillis();
        System.out.println(isSorted(arr));
        System.out.println(isSorted(arr1));
        System.out.println("arr消耗时间为 : " + (end - begin) + "ms");
        System.out.println("arr1消耗时间为 : " + (end1 - begin1) + "ms");
    }
}
