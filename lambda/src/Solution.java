import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * primeSum函数返回素数和
     * @param n int整型 n为正整数，且n>1
     * @param m int整型 m为正整数，且m>n
     * @return int整型
     */
    public static int primeSum (int n, int m) {
        // write code here

        int res = 0;
        if (n == 2) {
            res += 2;
            if(m >= 3)
                res += 3;
        }
        if (n == 3) {
            res += 3;
        }
        for (int i = n; i <= m; i++) {
            for (int j = 2; j < Math.sqrt(i) + 1; j++) {
                if (i % j == 0) {
                    break;
                }
                else if (j == (int) Math.sqrt(i))
                    res += i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(primeSum(2, 5));
    }
}