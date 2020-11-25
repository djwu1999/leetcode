public class test {
    public static void main(String[] args) {
        int num = 1;
        add(num);
        System.out.println(num);

        User user = new User("machael", 28);
        objChange(user);
        System.out.println(user);

        int num1 = 19;
        Integer num2 = new Integer(19);
        objChange(num2);
        objChange(num1);
        System.out.println(num1);
        System.out.println(num2);

        User user1 = new User("jackson", 30);
        userChnage(user1);
        System.out.println(user1);

        Integer num3 = 19;
        integerChange(num3);
        System.out.println(num3);
    }

    public static void add(int num) {
        num += 5;
    }

    public static void objChange(Object obj) {
        if(obj.getClass() == User.class){
            ((User)obj).setAge(18);
            ((User)obj).setName("jack");
            System.out.println(obj == ((User)obj));
        } else if (obj.getClass() == Integer.class) {
            obj = ((Integer)obj) + 1;
        }
    }

    public static void userChnage(User user) {
        user.setName("jack");
        user.setAge(18);
    }

    public static void integerChange(Integer num) {
        num++;
    }
}

class User{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
