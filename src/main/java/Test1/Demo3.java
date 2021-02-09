package Test1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.function.DoubleToIntFunction;

/**
 * @Author: LR
 * @Descriprition: 多线程
 * @Date: Created in 16:30 2021/2/8
 * @Modified By:
 **/
public class Demo3 {

    private static Object resouce1 = new Object(); // 资源1
    private static Object resouce2 = new Object(); // 资源2

    public static void main(String[] args) {
        /*
        // 获取线程管理的MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 snchronizer 信息, 仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息, 仅打印线程ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
        }

         */

        new Thread(() -> {
            synchronized (resouce1){
                System.out.println(Thread.currentThread() + "get resouce1");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resouce2");
                synchronized (resouce2){
                    System.out.println(Thread.currentThread() + "get resouce2");
                }
            }
        }, "线程1").start();

        new Thread(() -> {
            synchronized (resouce2){
                System.out.println(Thread.currentThread() + "get resouce2");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resouce1");
                synchronized (resouce2){
                    System.out.println(Thread.currentThread() + "get resouce1");
                }
            }
        }, "线程2").start();
    }
}
