package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * This class describes sequence of processes.
 * It performs work with linked list of CPU processes, getting queue,
 * adding and removing them.
 *
 * @version 27.06.2016
 * @author Yevhen Hryshchenko
 */
public class CPUQueue {
    private List<CPUProcess> processQueue = new LinkedList<>();

    public List<CPUProcess> getProcessQueue() {
        return processQueue;
    }

    // Adding process to the queue
    public synchronized void add(CPUProcess process){
        processQueue.add(process);
    }

    // Removing process from the queue
    public void remove(CPUProcess process){
        processQueue.remove(process);
    }
}
