package wang;

import lombok.Data;
import org.junit.Test;

@Data
public class ThreadDemo1 extends Thread {

    private ThreadLocal<String> threadName;

    @Override
    public void run() {
        System.out.println("继承Thread类方法多线程开启！");

        for (int i = 0; i < 10; i++) {
            System.out.println(this.threadName.get() + i);
        }
        System.out.println("继承Thread类方法多线程结束！");
    }
}

class ThreadDemo1Test {

    @Test
    public void test() {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        ThreadDemo1 threadDemo2 = new ThreadDemo1();

        threadDemo1.start();
        threadDemo2.start();
    }

    public static void main(String[] args) {
        ThreadDemo1 threadDemo1 = new ThreadDemo1();
        ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
        threadLocal1.set("第一个线程！");
        threadDemo1.setThreadName(threadLocal1);
        ThreadDemo1 threadDemo2 = new ThreadDemo1();
        ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
        threadLocal2.set("第二个线程！");
        threadDemo2.setThreadName(threadLocal2);
        threadDemo1.start();
        threadDemo2.start();
    }

}