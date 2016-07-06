package com.company;

/**
 * This class simulates CPU's work.
 * It executes processes and has executing time.
 *
 * @version 01 July 2016
 * @author Yevhen Hryshchenko
 */
public class CPU extends Thread{
    private CPUQueue queue; // queue of processes
    private String name; // CPU name
    private long lowerLimit; // minimum operating time
    private long upperLimit; // maximum operating time
    private boolean isBusy = false; // CPU status
    private Process process;

    public CPU(String name, CPUQueue queue, long min, long max){
        this.name = name;
        this.queue = queue;
        lowerLimit = min;
        upperLimit = max;
    }

    /**
     * This method checks queue on the emergence of new processes
     * and starts execute them removing from queue
     * or executes process if available one.
     * It runs process some random time.
     */
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            if (queue.size() != 0 || process != null) {
                if (!isBusy()) {
                    isBusy = true;
                    queue.checkSize();
                    if (process != null){
                        System.out.println(name + ": Executing " + process.getProcessName() + " "
                                + process.getThreadName());
                    }else{
                        process = queue.remove();
                        System.out.println(name + ": Executing from queue: " + process.getProcessName());
                    }
                    try {
                        Thread.sleep(generateTime());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    process = null;
                    isBusy = false;
                }
            }
        }
    }

    /**
     * This method set time for process running
     * @return time
     */
    public long generateTime(){
        return lowerLimit + (long)(Math.random()*(upperLimit - lowerLimit) + 1);
    }

    /**
     * This method give information about CPU status
     * @return true in case CPU is busy
     */
    public synchronized boolean isBusy() {
        return isBusy;
    }

    public synchronized void setProcess(Process process) {
        this.process = process;
    }
}

