package Thread;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable {
    private int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
