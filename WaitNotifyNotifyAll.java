// public class wait_Notify_notifyAll {
//     public static void main(String[] args) {
//         ThreadDemo2 t1=new ThreadDemo2();
//         t1.start();
//         synchronized(t1){
//         System.out.println("main thread get noftification");
//         t1.wait();
//         System.out.println("Main thread received notification");
//         System.out.println(t1.sum);
//         }
//     }    
// }

// class ThreadDemo2 extends Thread{
//     int sum=0;
//     @Override
//     public void run(){
//         int sum=0;
//         synchronized(this){
//         System.out.println("Child thread start sum");
//         for(int i=0; i<50; i++){
//         sum +=i;
//         }
//         System.out.println("child thread giving noticiation :");
//         this.notify();
//         }

//     }
// }


public class WaitNotifyNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ThreadDemo2 t1 = new ThreadDemo2();
        t1.start();

        synchronized(t1) {
            System.out.println("Main thread waiting for notification...");
            t1.wait(); // Wait for the notification from the child thread
            System.out.println("Main thread received notification");
            System.out.println("Sum calculated by child thread: " + t1.sum);
        }
    }    
}

class ThreadDemo2 extends Thread {
    int sum = 0; // Use the instance variable `sum`

    @Override
    public void run() {
        synchronized(this) {
            System.out.println("Child thread starts calculating sum...");
            for(int i = 0; i < 50; i++) {
                sum += i;
            }
            System.out.println("Child thread completed calculation, giving notification...");
            this.notify(); // Notify the main thread
        }
    }
}
