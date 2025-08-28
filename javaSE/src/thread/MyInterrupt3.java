package thread;


public class MyInterrupt3 {

    public static void main(String[] args) throws InterruptedException {

        //1.打断阻塞的线程
//        Thread t1 = new Thread(()->{
//            System.out.println("t1 正在运行...");
//            try {
//                System.out.println("t1 阻塞中...");
//                Thread.sleep(5000);
//                System.out.println("t1 运行结束...");
//            } catch (InterruptedException e) {
//                System.out.println("t1 被打断...");
//                e.printStackTrace();
//            }
//        }, "t1");
//        t1.start();
//        Thread.sleep(500);
//        t1.interrupt();
//        System.out.println(t1.isInterrupted());


        //2.打断正常的线程
        Thread t2 = new Thread(()->{
            while(true) {
                Thread current = Thread.currentThread();
                boolean interrupted = current.isInterrupted();
                if(interrupted) {
                    System.out.println("打断状态："+interrupted);
                    break;
                }
            }
        }, "t2");
        t2.start();
        Thread.sleep(5000);
        t2.interrupt();

    }
}
