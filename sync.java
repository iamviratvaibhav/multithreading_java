// public class sync {
    class Counter {
        private int count = 0;
    
        // Synchronized method to increment the count
        public synchronized void increment() {
            count++;
        }
    
        // Method to get the current count
        public int getCount() {
            return count;
        }
    }
    
    public class sync {
        public static void main(String[] args) {
            Counter counter = new Counter();
    
            // Creating two threads that will call the increment method
            Thread t1 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        counter.increment();
                    }
                }
            });
    
            Thread t2 = new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        counter.increment();
                    }
                }
            });
    
            // Starting the threads
            t1.start();
            t2.start();
    
            // Waiting for both threads to finish
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            // Printing the final count value
            System.out.println("Final count: " + counter.getCount());
        }
    }
    
// }
