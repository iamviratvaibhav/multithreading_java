public class syncronize_method {
   

    public static void main(String[] args) {
        // Initialize the Printmsg object
        Printmsg p = new Printmsg();
        
        // Create threads and pass the Printmsg object to them
        SyncThreadDemo t1 = new SyncThreadDemo(p);
        SyncThreadDemo t2 = new SyncThreadDemo(p);
        
        // Set thread names
        t1.setName("This is T1");
        t2.setName("this is T2");
        
        // Start the threads
        t1.start();
        t2.start();
    }
}


class Printmsg{
    public synchronized void m1(){
        for(int i=1; i<=5; i++){
            System.out.println("executed by "+ Thread.currentThread().getName());
            System.out.println("Hello Virat ");
        }
       
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}

class SyncThreadDemo extends Thread {
    Printmsg p;
    SyncThreadDemo(Printmsg p){
        this.p=p;

    }
    @Override
    public void run(){
        p.m1();
    }
}

