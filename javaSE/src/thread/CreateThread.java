package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CreateThread {
    public static void main(String[] args) {
        //通过new Thread创建线程
        new Thread(() -> {
            System.out.println("通过new Thread创建线程");
        }).start();

        //通过Runable创建线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("通过Runable创建线程");
            }
        }).start();

        //通过callable创建线程,使用futrueTask
        new Thread(new FutureTask<Void>(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                System.out.println("通过callable创建线程");
                return null;
            }
        })).start();
    }
}
