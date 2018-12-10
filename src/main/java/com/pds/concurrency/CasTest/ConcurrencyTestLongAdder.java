package com.pds.concurrency.CasTest;

import com.pds.concurrency.annotation.TheadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全的功劳 ：atomic  -  cas   ---  AtomicInteger的功劳
 */
@TheadSafe
@Slf4j
public class ConcurrencyTestLongAdder {
    /**
     * 请求总数
     */
    public  static  int  reqNum=1000;
    /**
     * 并发线程数
     */

    public  static  int  threadNum=20;
    /**
     * 计数器
     */
    public  static AtomicInteger count=new AtomicInteger(0);
//    public  static  int  count=0;



    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();
        final Semaphore semaphore=new Semaphore(threadNum);
        final CountDownLatch countDownLatch=new CountDownLatch(reqNum);
        for(int i=0;i<reqNum;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                add();
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
            log.info("countDown:" +count.get() );
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void add() {
        count.incrementAndGet();
    }
}
