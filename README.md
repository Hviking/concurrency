# concurrency
-- CountDownLatch   线程阻塞

-- Semaphore  控制同时并发的线程数

-- 线程池    ExecutorService

-- 线程调度       
-- 线程安全 
#### 原子性  ：一个时刻只有一个线程访问

  ATOMIC - CAS  ：原理判断cpu 计算值和主内存中统一变量值是否一致
  
  
  
 AtomicStampedReference 用于解决 cas 的ABA问题： 
#### 可见性；一个线程对主内存修改，可以被其他线程观察到
#### 有序性
  
