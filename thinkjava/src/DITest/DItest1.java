package DITest;

public class DItest1 {
    public static void main(String[] args) {
        Dog dog = new Dog("wangcai");
    }
}

class Dog{
    private Food food = new Food();
    private String name;

    public Dog(String name) {
        this.name = name;
        System.out.println("My name is " + name);
    }
}

class Food{
    private String food = "meat";

    public Food( ){
        System.out.println("the food is" + food);
    }
}
