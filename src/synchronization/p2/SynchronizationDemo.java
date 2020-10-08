package synchronization.p2;

class Callee{
    synchronized void disp(String msg){
        System.out.print("[" + msg);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ie){
            System.out.println("Interrupted..");
        }
        System.out.println(" ]");
    }
}
class Caller implements Runnable{
    Thread t;
    String msg;
    Callee c;
    Caller(Callee c,String msg){
        this.c = c;
        this.msg = msg;
        t = new Thread(this);
        t.start();
    }

    public void run()
    {
        synchronized(c){
            c.disp(msg);
        }
    }
}

public class SynchronizationDemo {
    public static void main(String[] args){
        Callee c = new Callee();

        Caller c1 = new Caller(c,"I");
        Caller c2 = new Caller(c,"like");
        Caller c3 = new Caller(c,"Java ");
        Caller c4 = new Caller(c,"Programming.");

        // wait for the the threads to end..

        try{
            c1.t.join();
            c2.t.join();
            c3.t.join();
            c4.t.join();
        }catch(InterruptedException ie){
            System.out.println("main Interrupted..");
        }
    }
}
