import java.util.Random;

public class QuickSort3 {

    public static void quickSort3Ways(int[] arr) {
        quickSort3Ways(arr, 0, arr.length - 1);
    }

    private static void quickSort3Ways(int[] arr, int l, int r) {
        if (r - l <= 15) {
            InsertionSort.insertionSort1(arr, l, r);
            return;
        }

        int rand = new Random().nextInt(r - l) + l;

        //partitions
        swap(arr, l, rand);
        int v = arr[l];

        int lt = l; //arr[l+1...lt] < v
        int gt = r + 1; //arr[gt...r] > v
        int i = l + 1;  //arr[lt + 1...i] == v
        while (i < gt) {
            if(arr[i] < v)
                swap(arr, i ++, lt ++);
            else if(arr[i] > v)
                swap(arr, i , gt --);
            else{
                i ++;
            }
        }
        swap(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);

    }

    private static void swap(int[] arr, int first, int second) {
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
        int[] arr = SortTestHelper.generateRandomArray(10000000, 0, 100000);
//        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        quickSort3Ways(arr);
        long end = System.currentTimeMillis();
        /*for (int i : arr) {
            System.out.println(i);
        }*/
        System.out.println(isSorted(arr));
        System.out.println("消耗时间为 : " + (end - begin) + "ms");
    }
}
