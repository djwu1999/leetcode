
// 以下代码来源于【参考1】
class VolatileExample {
  int x = 0;
  volatile boolean v = false;
  public void writer() {
    x = 42;
    v = true;
  }
  public void reader() {
    if (v) {
      // 这里x会是多少呢？
    }
  }

  class ThreadA implements Runnable {
    @Override
    public void run() {
      reader();
    }
  }

  class ThreadB implements Runnable {
    @Override
    public void run() {
      writer();
    }
  }



}