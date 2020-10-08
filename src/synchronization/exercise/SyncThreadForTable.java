package synchronization.exercise;

import java.util.Scanner;

class Sync{

    void increment(int n) {

        for (int j = 0; j < 10; j++) {
            System.out.println(n + " * " + (j + 1) + " = " + (n*(j + 1)));
            try {

                Thread.sleep(500);
            } catch (InterruptedException e) {

                System.out.println("ERROR" + e);
            }
        }
    }
}

class Inc extends Thread {

    final Sync s;

    Inc(Sync s){
        this.s = s;
    }

    public void run() {

        synchronized (s) {

            while (!SyncThreadForTable.onceOnly1) {

                System.out.println("-*- TABLE 1: -*-");
                s.increment(SyncThreadForTable.n1);
                System.out.println("\n");
                SyncThreadForTable.onceOnly1 = true;
            }

            while (!SyncThreadForTable.onceOnly2) {

                System.out.println("-*- TABLE 2: -*-");
                s.increment(SyncThreadForTable.n2);
                SyncThreadForTable.onceOnly2 = true;
            }

            SyncThreadForTable.onceOnly2 = false;
        }
    }
}

public class SyncThreadForTable {

    static boolean onceOnly1 = false;
    static boolean onceOnly2 = true;

    public static int n1 = 0;
    public static int n2 = 0;

    public static void main(String[] args) {

        Scanner scan =new Scanner(System.in);

        System.out.println("\n\t\t-*- SYNCHRONIZATION TABLE -*-");

        System.out.println("\nWhich two Multiplication Tables do you want?\nEnter Number 1:");

        n1 = scan.nextInt();

        System.out.println("Enter number 2:");

        n2 = scan.nextInt();

        System.out.println("\nThe required tables are as follows--\n");

        Sync s = new Sync();

        Inc i1 = new Inc(s);
        Inc i2 = new Inc(s);

        i1.start();
        i2.start();

        try {
            i1.join();
            i2.join();
        } catch (InterruptedException e){
            System.out.println("ERROR: " + e);
        }

        System.out.println("\n\tPrepared by: VIVEK D KAPADIA\n\t\t19CE055");
    }
}
