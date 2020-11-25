package functionalinterface;

import functionalinterface.pojo.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class test1 {
    public static void main(String[] args) {
        User[] users = new User[4];
        for (int i = 0; i < 4; i++) {
            users[i] = new User("jack" + i, 23 + i);
        }

        Arrays.stream(users).forEach(System.out::println);
        System.out.println(users.toString());

//        Arrays.sort(users, (o1, o2) -> o2.getName().compareTo(o1.getName()) != 0 ? o2.getAge() - o1.getAge() : o2.getName().compareTo(o1.getName()));
//        Arrays.sort(users, Comparator.comparing(User::getName));
        Arrays.sort(users);
    }
}
