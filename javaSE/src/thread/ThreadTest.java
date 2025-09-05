package thread;

public class ThreadTest extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("子线程执行" + Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("线程开始执行"+Thread.currentThread().getName());
        ThreadTest thread = new ThreadTest();
        thread.start();
        thread.join();
        System.out.println("线程结束执行"+Thread.currentThread().getName());
    }
}
