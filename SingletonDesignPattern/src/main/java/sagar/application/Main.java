package sagar.application;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Enum Singleton representing the database connection pool
enum DBConnectionPool {
    INSTANCE;

    private BlockingQueue<DBConnection> connections;

    // Private constructor to initialize the connection pool
    private DBConnectionPool() {
        // Initialize the connection pool with a fixed number of connections
        connections = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 10; i++) {
            connections.offer(new DBConnection("Connection " + (i + 1)));
        }
    }

    // Method to get a database connection from the pool
    public DBConnection getConnection() {
        try {
            return connections.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error while getting database connection", e);
        }
    }

    // Method to return a database connection to the pool
    public void returnConnection(DBConnection connection) {
        try {
            connections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Error while returning database connection", e);
        }
    }
}

// Class representing a database connection
class DBConnection {
    private String connectionName;

    public DBConnection(String connectionName) {
        this.connectionName = connectionName;
    }

    public void executeQuery(String query) {
        System.out.println("Executing query '" + query + "' on connection: " + connectionName);
        // Simulated execution of query
    }
}

// Main class to demonstrate the use of the database connection pool
public class Main {
    public static void main(String[] args) {
        // Get a database connection from the pool
        DBConnection connection1 = DBConnectionPool.INSTANCE.getConnection();
        connection1.executeQuery("SELECT * FROM table1");

        // Get another database connection from the pool
        DBConnection connection2 = DBConnectionPool.INSTANCE.getConnection();
        connection2.executeQuery("UPDATE table2 SET column1 = 'value'");

        // Return the connections to the pool
        DBConnectionPool.INSTANCE.returnConnection(connection1);
        DBConnectionPool.INSTANCE.returnConnection(connection2);
    }
}
