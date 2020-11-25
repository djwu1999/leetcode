public class mergeSort {
    private static void mergeSort(int[] a, int[] temp, int left, int right){
        if(left < right){
            int center = (left + right) / 2;
            mergeSort(a, temp, left, center);
            mergeSort(a, temp, center + 1, right);
            merge(a, temp, left, center + 1, right);
        }
    }

    public static void mergeSort(int[] a){
        int[] temp = new int[a.length];

        mergeSort(a, temp, 0, a.length - 1);
    }

    private static void merge(int[] a, int[] temp, int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while(leftPos <= leftEnd && rightPos <= rightEnd){
            if(a[leftPos] <= a[rightPos])
                temp[tempPos ++] = a[leftPos ++];
            else
                temp[tempPos ++] = a[rightPos ++];
        }

        while(leftPos <= leftEnd){
            temp[tempPos ++] = a[leftPos ++];
        }

        while(rightPos <= rightEnd){
            temp[tempPos ++] = a[rightPos ++];
        }

        for(int i = 0; i < numElements; i ++, rightEnd --)
            a[rightEnd] = temp[rightEnd];
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 34, 4, 2, 12, 540};
        mergeSort(a);
        System.out.println(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
