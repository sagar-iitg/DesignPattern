package com.sagar.example1;

class CPU {
    public void freeze() {
        System.out.println("Freezing CPU...");
    }
    
    public void jump(String position) {
        System.out.println("Jumping to position " + position);
    }
    
    public void execute() {
        System.out.println("Executing instructions...");
    }
}

class Memory {
    public void load(String data) {
        System.out.println("Loading data: " + data);
    }
}

class HardDrive {
    public void readData(String fileName) {
        System.out.println("Reading data from file: " + fileName);
    }
}
