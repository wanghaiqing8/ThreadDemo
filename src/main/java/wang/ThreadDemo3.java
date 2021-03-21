package wang;

import lombok.Data;
import org.junit.Test;

@Data
public class ThreadDemo3 {

    private ThreadLocal<String> threadName;

    public void run() {
        System.out.println("继承Thread类方法多线程开启！");

        for (int i = 0; i < 10; i++) {
            System.out.println( i);
            if(i == 5) {
//                Thread.stop();
            }
        }
        System.out.println("继承Thread类方法多线程结束！");
    }

    @Test
    public void test() throws InterruptedException {
        ChildClass aa = new ChildClass(){
            @Override
            public void testRun() {
                System.out.println("这是修改后的！");
            }
        };
        aa.testRun();

        Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            System.out.println(i);
                        }
                    }
                },"name11"
        );
        // 主线程  任何程序运行
        System.out.println(Thread.currentThread().getId());
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());

        Thread.sleep(1000);

        // 子线程
        System.out.println(thread.getId());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());

        thread.start();
    }

}

// 抽象类使用的话可以使用匿名内部类，然后 abstract的类里的方法必须写方法体
abstract class ChildClass{

    public void testRun(){
        System.out.println("请重写");
    }

}