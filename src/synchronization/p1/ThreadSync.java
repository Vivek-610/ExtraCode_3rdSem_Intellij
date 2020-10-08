package synchronization.p1;

class Counter {

    private int val=0;
    synchronized public void increment() {
        System.out.println("Before increment called..." + val);
        val++;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println("thread interrupted..");
        }
        System.out.println("After increment called..." + val);
    }

    synchronized public void decrement() {
        System.out.println("Before decrement called..." + val);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            System.out.println("thread interrupted..");
        }
        val--;
        System.out.println("After decrement called..." + val);
    }

    public int getVal() {
        return val;
    }
}

class IncThread extends Thread {

    Counter c;

    public IncThread(Counter c) {
        this.c = c;
        start();
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            c.increment();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                System.out.println("Thread Interrupted...");
            }
        }
        System.out.println("Final inc : " + c.getVal());
    }
}

class DecThread extends Thread {

    Counter c;

    public DecThread(Counter c) {
        this.c = c;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            c.decrement();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                System.out.println("Thread interrupted...");
            }
        }

        System.out.println("Final dec : " + c.getVal());
    }
}

public class ThreadSync {

    public static void main(String[] args) {
        Counter c = new Counter();
        new IncThread(c); // Both threads are sharing same object
        new DecThread(c);
    }
}
