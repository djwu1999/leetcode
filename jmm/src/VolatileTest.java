public class VolatileTest {

    private static boolean initFlag = false;
    private volatile static User user = new User(false);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("wating data...");
            while (!user.isFlag()) {
            }
            System.out.println("=================");
        }).start();

        Thread.sleep(20);

        new Thread(() -> {
            prepareData();
        }).start();
    }

    public static void prepareData() {
        System.out.println("preparing data...");
//        initFlag = true;
        user.setFlag(true);
        System.out.println("prepare data end...");
    }
}

class User{
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public User() {
    }

    public User(boolean flag) {
        this.flag = flag;
    }
}
