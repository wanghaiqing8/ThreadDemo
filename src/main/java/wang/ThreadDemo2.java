package wang;

import lombok.Data;
import org.junit.Test;

@Data
public class ThreadDemo2 implements Runnable {

    private ThreadLocal<String> threadName;

    @Override
    public void run() {
        System.out.println("继承Thread类方法多线程开启！");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("继承Thread类方法多线程结束！");
    }

}

class ThreadDemo2Test {

    @Test
    public void test() {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        ThreadDemo1 threadDemo2 = new ThreadDemo1();

        threadDemo1.start();
        threadDemo2.start();
    }

    public static void main(String[] args) {
        ThreadDemo2 threadDemo1 = new ThreadDemo2();
        Thread thread = new Thread(threadDemo1);
        thread.start();

        for (int i = 0; i <10 ; i++) {
            System.out.println("测试"+i);
        }

    }



}