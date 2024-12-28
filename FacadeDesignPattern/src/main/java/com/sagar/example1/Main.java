package com.sagar.example1;

public class Main {
    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();

        ComputerFacade computer = new ComputerFacade(cpu, memory, hardDrive);

        // Use the facade to start the computer
        computer.startComputer();
    }
}
