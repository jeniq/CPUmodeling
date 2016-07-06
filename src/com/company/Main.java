package com.company;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CPUQueue queue = new CPUQueue();
        CPU cpu1 = new CPU("CPU1", queue, 10, 25);
        CPU cpu2 = new CPU("CPU2", queue, 10, 25);

        cpu1.start();
        cpu2.start();

	    CPUProcess thread1 = new CPUProcess(1, queue, cpu1, cpu2, 50, 1, 10);
        CPUProcess thread2 = new CPUProcess(2, queue, cpu1, cpu2, 30, 20, 25);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        Thread.sleep(2000);

        cpu1.interrupt();
        cpu2.interrupt();

        System.out.println("Max size of queue: " + queue.getMaxSize());
        System.out.println("Lost processes at CPU1: " + thread1.getNumberOfLostProcesses());
        System.out.println("Lost processes at CPU2: " + thread2.getNumberOfLostProcesses());
    }
}