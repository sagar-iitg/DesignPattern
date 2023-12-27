package com.sagar.example2;

// Product class
class Computer {
    private String processor;
    private int memory;
    private int storage;
    private boolean graphicsCard;
    private boolean bluetooth;

    // Constructor is private to enforce the use of the builder
    private Computer() {
        // Initialization of required properties
        this.processor = "Default Processor";
        this.memory = 4; // Default memory size in GB
        this.storage = 256; // Default storage size in GB
    }

    // Getters...

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", memory=" + memory +
                ", storage=" + storage +
                ", graphicsCard=" + graphicsCard +
                ", bluetooth=" + bluetooth +
                '}';
    }

    // Builder class
    public static class ComputerBuilder {
        private Computer computer;

        public ComputerBuilder() {
            this.computer = new Computer();
        }

        public ComputerBuilder setProcessor(String processor) {
            computer.processor = processor;
            return this;
        }

        public ComputerBuilder setMemory(int memory) {
            computer.memory = memory;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            computer.storage = storage;
            return this;
        }

        public ComputerBuilder addGraphicsCard() {
            computer.graphicsCard = true;
            return this;
        }

        public ComputerBuilder addBluetooth() {
            computer.bluetooth = true;
            return this;
        }

        public Computer build() {
            return computer;
        }
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        // Creating a custom computer using the Builder pattern
        Computer customComputer = new Computer.ComputerBuilder()
                .setProcessor("Intel i7")
                .setMemory(16)
                .setStorage(512)
                .addGraphicsCard()
                .addBluetooth()
                .build();

        // Displaying the details of the constructed computer
        System.out.println(customComputer.toString());
    }
}
