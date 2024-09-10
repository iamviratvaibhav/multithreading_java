



public class syn_with2method  {
    public static void main(String[] args) {
        // Creating threads for both methods
        Thread t1 = new Thread(new SynThread1(p));
        Thread t2 = new Thread(new SynThread2(p));

        // Starting both threads
        t1.start();
        t2.start();
    }
}

class PrintMsg2 {
    // Synchronized method 1
    public synchronized void m1() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi, this is method 1");
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Synchronized method 2
    public synchronized void m2() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi, this is method 2");
        }
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Thread to call method 1
class SynThread1 implements Runnable {
    PrintMsg2 p;

    SynThread1(PrintMsg2 p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.m1();
    }
}

// Thread to call method 2
class SynThread2 implements Runnable {
    PrintMsg2 p;

    SynThread2(PrintMsg2 p) {
        this.p = p;
    }

    @Override
    public void run() {
        p.m2();
    }
}
