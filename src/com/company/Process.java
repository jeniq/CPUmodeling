package com.company;

/**
 * This class implements processes.
 * Process has name and generating time.
 *
 * @version 27 June 2016
 * @author Yevhen Hryshchenko
 */
public class Process extends CPUProcess{
    private String processName;
    private String threadName;

    public Process(String processName, String threadName) {
        this.processName = processName;
        this.threadName = threadName;
    }

    public String getProcessName() {
        return processName;
    }

    public long generateTime(){
        return lowerLimit + (long)(Math.random()*(upperLimit - lowerLimit) + 1);
    }

    public String getThreadName() {
        return threadName;
    }
}
