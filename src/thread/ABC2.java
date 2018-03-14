package thread;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC2 {
    private volatile static int k = 0;

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch cd = new CountDownLatch(1000);
        ExecutorService executorService = new ThreadPoolExecutor(8, 8,
                60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(5000));
        Lock lock = new ReentrantLock();
        for (int i = 0; i < 1000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        k++;
                        cd.countDown();
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }
        cd.await();
        System.out.println(k);
    }
}
