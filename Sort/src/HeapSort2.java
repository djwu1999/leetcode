public class HeapSort2 {
    public static void heapSort2(int[] arr) {
        MaxHeap maxHeap = new MaxHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = maxHeap.remove();
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
        int[] arr = SortTestHelper.generateRandomArray(10000000, 0, 100000);
        long begin = System.currentTimeMillis();
        heapSort2(arr);
        long end = System.currentTimeMillis();

        int[] arr1 = SortTestHelper.getSortedArray(10000000);
        int[] arr2 = new int[arr1.length];
        int index = 0;
        for (int i = arr2.length - 1; i >= 0; i--) {
            arr2[i] = arr1[index ++];
        }
        long begin1 = System.currentTimeMillis();
        heapSort2(arr1);
        long end1 = System.currentTimeMillis();
        System.out.println(isSorted(arr));
        System.out.println(isSorted(arr1));
        System.out.println("arr消耗时间为 : " + (end - begin) + "ms");
        System.out.println("arr1消耗时间为 : " + (end1 - begin1) + "ms");
    }
}
