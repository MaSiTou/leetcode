package thread;



public class SequenceWithLock {
    private final Object lock = new Object();
    private int value = 0;

    public void processInOrder() {
        synchronized(lock) {
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
        }
    }

    public static void main(String[] args) {
        SequenceWithLock example = new SequenceWithLock();

        // 创建多个线程
        //输出的线程的顺序是不确定的
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    example.processInOrder();
                }
            }, "Thread-" + i).start();
        }
    }
}
