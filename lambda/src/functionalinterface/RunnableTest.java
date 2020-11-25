package functionalinterface;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class RunnableTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream ps = System.out;
        ps.println("sout");
    }
}
