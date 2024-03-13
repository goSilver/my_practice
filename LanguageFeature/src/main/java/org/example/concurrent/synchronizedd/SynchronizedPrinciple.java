package org.example.concurrent.synchronizedd;

/**
 * synchronized原理
 * 使用javac命令进行编译生成.class文件
 * >javac SynchronizedPrinciple.java
 * <p>
 * 使用javap命令反编译查看.class文件的信息
 * >javap -verbose SynchronizedPrinciple.class
 * <p>
 * 会发现Monitorenter和Monitorexit指令，会让对象在执行，使其锁计数器加1或者减1。每一个对象在同一时间只与一个monitor(锁)相关联，而一个monitor在同一时间只能被一个线程获得，
 * 一个对象在尝试获得与这个对象相关联的Monitor锁的所有权的时候，
 * <p>
 * monitorenter指令会发生如下3中情况之一：
 * 1、monitor计数器为0，意味着目前还没有被获得，那这个线程就会立刻获得然后把锁计数器+1，一旦+1，别的线程再想获取，就需要等待
 * 2、如果这个monitor已经拿到了这个锁的所有权，又重入了这把锁，那锁计数器就会累加，变成2，并且随着重入的次数，会一直累加
 * 3、这把锁已经被别的线程获取了，等待锁释放
 * <p>
 * monitorexit指令：
 * 1、释放对于monitor的所有权，释放过程很简单，就是讲monitor的计数器减1，如果减完以后，计数器不是0，则代表刚才是重入进来的，
 * 当前线程还继续持有这把锁的所有权，如果计数器变成0，则代表当前线程不再拥有该monitor的所有权，即释放锁。
 *
 * @author chensh
 * @datetime 2024/3/13 8:36 PM
 */
public class SynchronizedPrinciple {
    Object object = new Object();

    /*
      反编译后：
      public void method1();
        descriptor: ()V
        flags: (0x0001) ACC_PUBLIC
        Code:
          stack=2, locals=3, args_size=1
             0: aload_0
             1: getfield      #3                  // Field object:Ljava/lang/Object;
             4: dup
             5: astore_1
             6: monitorenter
             7: aload_1
             8: monitorexit
             9: goto          17
            12: astore_2
            13: aload_1
            14: monitorexit
            15: aload_2
            16: athrow
            17: invokestatic  #4                  // Method method2:()V
            20: return
          Exception table:
             from    to  target type
                 7     9    12   any
                12    15    12   any
     */
    public void method1() {
        synchronized (object) {

        }
        method2();
    }

    private static void method2() {

    }
}
