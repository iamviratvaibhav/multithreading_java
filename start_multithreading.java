/**
 * start_multithreading
 */
public class start_multithreading {
    public static void main(String[] args) {
        Demo d=new Demo();
        d.start();
        for(int i=0; i<10; i++){
            System.out.println("main ");
        }
    }
    
}

class Demo extends Thread {
    @Override
    public void run(){
        //job
        for(int i=0; i<10; i++){
            System.out.println("Jai Shree Ram");
        }
    }
}