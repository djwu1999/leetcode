public class InitailTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> cl = Class.forName("TestInitail");
        System.out.println("---------------------");
        Class<TestInitail> cl1 = TestInitail.class;
        System.out.println("---------------------");
        System.out.println(TestInitail.size);
        Class<? extends Number> integerClass = int.class;
        integerClass = Double.class;
        cl = Double.class;
    }
}
