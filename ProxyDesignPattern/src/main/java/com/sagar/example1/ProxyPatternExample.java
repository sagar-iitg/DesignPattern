package com.sagar.example1;

// Subject Interface
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk(); // Expensive operation
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Proxy
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName); // Lazy initialization
        }
        realImage.display();
    }
}

// Client Code
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("test_image.jpg");
        System.out.println("Image object created, but not loaded yet.");

        // Loading happens only when display is called
        image.display(); 
        System.out.println("Image already loaded; no need to load again.");
        image.display();
    }
}
