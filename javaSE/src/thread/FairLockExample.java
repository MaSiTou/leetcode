package thread;
import java.util.concurrent.locks.ReentrantLock;
public class FairLockExample {
    private final ReentrantLock lock = new ReentrantLock(true); // 公平锁
    private int value = 0;

    public void processInOrder() {
        lock.lock();  // 获取锁
        try {
            // 临界区代码 - 一次只有一个线程能执行这里
            System.out.println(Thread.currentThread().getName() +
                    " 开始处理, 当前值: " + value);
            value++;
            try {
                Thread.sleep(100); // 模拟处理时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " 处理完成, 新值: " + value);
        } finally {
            lock.unlock();  // 必须在finally中释放锁
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FairLockExample example = new FairLockExample();

        // 创建多个线程
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    example.processInOrder();
                }
            }, "Thread-" + i).start();
//            Thread.sleep(500);
        }
    }
}
