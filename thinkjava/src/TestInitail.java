import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestInitail implements Serializable {

    static final int size = 0;

    /*public TestInitail(){
        System.out.println("Initail...");
    }*/
    static {
        System.out.println("static heap iniatail....");
    }
}
