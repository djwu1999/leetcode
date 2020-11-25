package Thread.volatiletest;

public class test1 {
    public static void main(String[] args) throws InterruptedException {
        Number number = new Number();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    number.addOne();
                }
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(number.getNum());
    }
}

class Number{
    private volatile int num;
    public void addOne(){
        System.out.println(++num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
