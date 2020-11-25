public class maxSubSum4 {
    public static int maxSubSum(int[] a){
        int maxSum = 0, thisSum = 0;
        for (int i = 0; i < a.length; i++) {
            thisSum += a[i];
            if(thisSum <= 0)
                thisSum = 0;
            else if(thisSum > maxSum)
                maxSum = thisSum;
        }

        return maxSum;
    }

    public static void main(String[] ar000gs) {
        int[] a = {4, -3, 5, -2, -1, 2, -6, -2};
        System.out.println(maxSubSum(a));
    }
}
