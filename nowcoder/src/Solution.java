import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n long长整型 表示标准完全二叉树的结点个数
     * @return long长整型
     */
    public long tree4 (long n) {
        // write code here
        long v = 1;
        long res = 0;
        for (long i = 1; i <= n; i++) {
            if (i >= Math.pow(2, v))
                v = (long)(Math.log(i) / Math.log(2) + 1);
            res += i * v;
        }
        return res % 998244353;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tree4(2));
        System.out.println(solution.tree4(5));
    }
}