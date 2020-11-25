package ClassPratice;

import com.sun.deploy.net.HttpRequest;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

public class InstanceTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Dog dog = new Dog();
        Dog dog1 = new Dog("旺财", 1);

        Dog test = new Dog("Tony", 18);
        Dog test1 = test;
        test1 = test;
        test1.setName("Jack");
        test1.setAge(20);
        System.out.println("test : " + test);
        System.out.println("test1 : " + test1);
        LinkedList<Integer> list = new LinkedList<>();

    }
}
