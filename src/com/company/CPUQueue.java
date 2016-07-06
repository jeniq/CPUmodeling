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
    private int maxSize = 0;
    private LinkedList<Process> processQueue = new LinkedList<>();

    public List<Process> getProcessQueue() {
        return processQueue;
    }

    // Adding process to the queue
    public synchronized void add(Process process){
        processQueue.addFirst(process);
    }

    // Removing process from the queue
    public synchronized Process remove(){
        if (processQueue.size() > 0){
            return processQueue.removeLast();
        }else{
            return null;
        }
    }

    public synchronized int size(){
        return processQueue.size();
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void checkSize(){
        if (size() > maxSize){
            maxSize = size();
        }
    }
}
