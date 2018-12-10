package com.pds.concurrency.CasTest;

import com.pds.concurrency.annotation.TheadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 线程安全的功劳 ：atomic  -  cas   ---  AtomicIntegerFieldUpdater
 *
 */
@TheadSafe
@Slf4j
public class ConcurrencyAtomicIntegerFieldUpdater {
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
    public  static AtomicIntegerFieldUpdater<ConcurrencyAtomicIntegerFieldUpdater> updater=
            AtomicIntegerFieldUpdater.newUpdater(ConcurrencyAtomicIntegerFieldUpdater.class,"count");
    @Getter
    public  volatile  int count = 100;


    public static void main(String[] args) {
        ConcurrencyAtomicIntegerFieldUpdater c=new ConcurrencyAtomicIntegerFieldUpdater();
        if(updater.compareAndSet(c,100,120)){
            log.info("aaaaa"+c.getCount());
        }
        if(updater.compareAndSet(c,100,120)){
            log.info("bbb"+c.getCount());
        }
    }


}
