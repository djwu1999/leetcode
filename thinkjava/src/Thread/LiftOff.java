package Thread;

public class LiftOff implements Runnable {

    static {
        System.out.println("The class that implements Runnable is initailize");
    }
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount ++;
    public LiftOff(){

    }

    public String status(){
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ").";
    }
    @Override
    public void run() {
        while(countDown-- > 0){
            System.out.println(status());
            Thread.yield();
        }
    }

    public static void main(String[] args) {
        /*LiftOff launch = new LiftOff();
        launch.run();*/
        /*Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("start");*/
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for liftoff");
    }
}
