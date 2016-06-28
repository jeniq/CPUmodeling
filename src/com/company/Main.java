package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CPU cpu1 = new CPU("CPU1", 10, 1500);
        CPU cpu2 = new CPU("CPU2", 10, 1500);
        CPUQueue queue = new CPUQueue();

	    CPUProcess thread1 = new CPUProcess(1, queue, cpu1, cpu2, 20, 300, 3000);
        CPUProcess thread2 = new CPUProcess(2, queue, cpu1, cpu2, 15, 700, 2200);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}