import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(inventory.length, (a, b) -> b - a);
        for (int i = 0; i < inventory.length; i++) {
            q.add(inventory[i]);
        }
        long res = 0;
        for (int i = 0; i < orders; i++) {
            int po = q.poll();
            res += po;
            q.add(po - 1);
        }
        return (int) (res % (long)(Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1000000000};
        System.out.println(solution.maxProfit(arr, 1000000000));
    }
}