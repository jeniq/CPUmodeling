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

    public Process(String processName) {
        this.processName = processName;
    }

    public String getProcessName() {
        return processName;
    }

    public long generateTime(){
        return lowerLimit + (long)(Math.random()*(upperLimit - lowerLimit) + 1);
    }
}
