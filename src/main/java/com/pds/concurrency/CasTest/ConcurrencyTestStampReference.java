package com.pds.concurrency.CasTest;

import com.pds.concurrency.annotation.TheadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 线程安全的功劳 ：atomic  -  cas   ---  StampReference
 * StampReference用于解决cas 的ABA问题：比对过结果是1，然后执行后续操作，但是，这个1在过程中有被修改了，带来的结果错误
 *
 * 解决方案：给改变量加个版本号，通过版本区分
 *
 */
@TheadSafe
@Slf4j
public class ConcurrencyTestStampReference {
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
//        AtomicStampedReference a=new AtomicStampedReference();
    }

    public static void add() {
        count.incrementAndGet();
    }
}
