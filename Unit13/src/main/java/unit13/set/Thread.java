package unit13.set;

public class Thread {
    //Threading without synchronization can lead to race conditions where multiple threads access shared resources concurrently, resulting in unpredictable behavior.
    // sleep(): Pauses the execution of the current thread for a specified amount of time.
    // join(): Waits for the thread on which it's called to terminate.

    public class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread: " + i);
                try {
                    Thread.sleep(1000); // Sleep for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    
        public static void main(String[] args) {
            MyThread thread = new MyThread();
            thread.start();
        }
    }

    // In this example, the count variable is being accessed and incremented 
    // by multiple threads (MyThread instances) without synchronization. This 
    // can lead to race conditions where multiple threads attempt to update the 
    // count variable simultaneously, resulting in unpredictable or incorrect 
    // values.




    //Synchronization ensures that only one thread can access a shared resource at a time, preventing race conditions.
    // synchronized: Keyword used to synchronize methods or blocks of code.
    // wait(): Causes the current thread to wait until another thread invokes the notify() or notifyAll() method.
    // notify(): Wakes up a single thread that is waiting on the object's monitor.
    // notifyAll(): Wakes up all threads that are waiting on the object's monitor.

    public class Counter {
        private int count = 0;
    
        public synchronized void increment() {
            count++;
        }
    
        public synchronized int getCount() {
            return count;
        }
    
        public static void main(String[] args) {
            Counter counter = new Counter();
    
            Runnable runnable = () -> {
                for (int i = 0; i < 1000; i++) {
                    counter.increment();
                }
            };
    
            Thread thread1 = new Thread(runnable);
            Thread thread2 = new Thread(runnable);
    
            thread1.start();
            thread2.start();
    
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            System.out.println("Count: " + counter.getCount());
        }
    }

    // In this example, the increment() and getCount() methods of the Counter class
    //  are synchronized, ensuring that only one thread can access them at a time.
    //  This prevents race conditions when multiple threads attempt to modify or 
    // read the count variable concurrently.




    //  Part 1) Client:
    // The client initiates communication with the server by establishing a connection.
    // It sends requests to the server and waits for responses.
    // It may handle user input or generate data to be sent to the server.
    // Example: A client for a chat application that sends messages to a server.

    // A client for a chat application connects to the chat server, sends messages
    //  typed by the user, and displays messages received from other users.


    // Part 2) Server:
    // The server listens for incoming connections from clients.
    // It processes client requests and sends appropriate responses.
    // It may handle multiple client connections concurrently.
    // Example: A server for a multiplayer game that receives player actions and updates the game state.
        

//     A server for a multiplayer game receives player actions (e.g., moves, 
//     attacks) from clients, updates the game state accordingly, and broadcasts
//     updates to all connected players.

// Understanding threading concepts, synchronization techniques, and client-server 
// interactions is crucial for building robust and scalable concurrent 
// applications. Practice writing and debugging multithreaded code to gain 
// proficiency in these areas.
        
}
