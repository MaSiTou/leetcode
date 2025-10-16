//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("t1");
            System.out.println("thread:"+Thread.currentThread().getName());
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("t2");
            System.out.println("thread:"+Thread.currentThread().getName());
        });
        t1.start();
        t2.start();
        t2.join();
        System.out.println("main thread:"+Thread.currentThread().getName());
    }
}