package com.company;

/**
 * This class simulates CPU's work.
 * It executes processes and has executing time.
 *
 * @version 27 June 2016
 * @author Yevhen Hryshchenko
 */
public class CPU extends Thread{
    private long lowerLimit;
    private long upperLimit;
    private volatile boolean isBusy = false;
    private String name;

    public CPU(String name, long min, long max){
        this.name = name;
        lowerLimit = min;
        upperLimit = max;
    }


    public void executeProcess(Process process){
        isBusy = true;
        try {
            System.out.println(name + ": Executing " + process.getProcessName());
            Thread.sleep(generateTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            isBusy = false;
        }
    }

    public long generateTime(){
        return lowerLimit + (long)(Math.random()*(upperLimit - lowerLimit) + 1);
    }

    public synchronized boolean isBusy() {
        return isBusy;
    }
}

