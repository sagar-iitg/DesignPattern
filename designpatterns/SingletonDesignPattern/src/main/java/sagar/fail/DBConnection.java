package sagar.fail;

public class DBConnection {

    private static DBConnection conObject;
    private DBConnection() {
        System.out.println("DBConnection instance created.");
    }

    public static DBConnection getInstance() {
        if (conObject == null) { // Thread 1 and Thread 2 could both enter here
            try {
                // Simulate some delay
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            conObject = new DBConnection();
        }
        return conObject;
    }
}

class Main {
    public static void main(String[] args) {
        // Create two threads trying to get an instance of DBConnection
        Thread thread1 = new Thread(() -> {
            DBConnection singletonObject = DBConnection.getInstance();
            System.out.println("Thread 1: " + singletonObject.hashCode());
        });

        Thread thread2 = new Thread(() -> {
            DBConnection singletonObject = DBConnection.getInstance();
            System.out.println("Thread 2: " + singletonObject.hashCode());
        });

        // Start both threads
        thread1.start();
        thread2.start();
    }
}
