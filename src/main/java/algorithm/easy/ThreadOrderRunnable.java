package algorithm.easy;

/**
 * @description:
 * @author: yaobw
 * @date: 2020/5/20 7:26 下午
 */
public class ThreadOrderRunnable {

    private volatile int rank = 1;

    public ThreadOrderRunnable() {

    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        rank = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(rank != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        rank = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(rank != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
