package wang;

import lombok.Data;
import lombok.SneakyThrows;
import org.junit.Test;

@Data
public class ThreadDemo4  {

    @Test
    public void test() throws InterruptedException {

        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    Thread.sleep(300);
                    System.out.println("子线程：" + i);
                }
            }
        });
        // 设置守护线程,会跟着主线程执行完毕一起销毁
        // GC线程是守护线程的一种，程序结束了就不需要垃圾回收了
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(300);
            System.out.println("主线程：" + i);
        }

    }

}
