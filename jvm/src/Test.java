public class Test {

    public static int initData = 666;
    public int compute(){
        int a = 11;
        int b = 21;
        int c = (a + b) * 10;
        return c;
    }
    public static void main(String[] args) {
        int d = 10;
        Test test = new Test();
        System.out.println(test.compute());
    }
}
