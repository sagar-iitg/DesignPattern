package com.sagar.example1;

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade(CPU cpu, Memory memory, HardDrive hardDrive) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public void startComputer() {
        System.out.println("Starting the computer...");
        cpu.freeze();
        memory.load("Operating System");
        hardDrive.readData("bootloader");
        cpu.jump("main memory");
        cpu.execute();
    }
}
