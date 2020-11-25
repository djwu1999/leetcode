public class solution_50 {
    public static double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickPow(x, N) : 1.0 / quickPow(x, -N);
    }

    public static double quickPow(double x, long N){
        if(N == 0){
            return 1.0;
        }
        double y = quickPow(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2));
    }
}
