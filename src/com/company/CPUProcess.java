package com.company;

/**
 * This class implements thread of processes.
 * It defines CPU for executing process.
 *
 * @version 30 June 2016
 * @author Yevhen Hryshchenko
 */
public class CPUProcess extends Thread{
    protected long lowerLimit; // minimum time for generating process
    protected long upperLimit; // maximum time for generating process
    private CPUQueue queue; // queue of processes
    private CPU cpu1;
    private CPU cpu2;
    private int numOfProcesses; // number of processes
    private int name; // processes' thread name
    private volatile int numberOfLostProcesses = 0;

    protected CPUProcess(){}

    public CPUProcess(int name, CPUQueue queue, CPU cpu1, CPU cpu2, int n, long min, long max){
        this.name = name;
        this.queue = queue;
        this.cpu1 = cpu1;
        this.cpu2 = cpu2;
        numOfProcesses = n;
    }

    public void run(){
        for (int i = 0; i < numOfProcesses; i++){
            Process process = new Process("Process" + i, "Thread" + name);
            try {
                Thread.sleep(process.generateTime()); // generating process
                if (!cpu1.isBusy()){
                    cpu1.setProcess(process);
                }else if (!cpu2.isBusy()){
                    cpu2.setProcess(process);
                }else if (name == 2){
                    System.out.println("Add to queue " + process.getProcessName() + " " + process.getThreadName());
                    queue.add(process);
                }else{
                    System.out.println("Lost " + process.getProcessName() + " " + process.getThreadName());
                    numberOfLostProcesses++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getNumberOfLostProcesses() {
        return numberOfLostProcesses;
    }
}
