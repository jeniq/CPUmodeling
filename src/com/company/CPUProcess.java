package com.company;

/**
 * This class implements thread of processes.
 * It defines CPU for executing process.
 *
 * @version 27 June 2016
 * @author Yevhen Hryshchenko
 */
public class CPUProcess extends Thread{
    protected long lowerLimit;
    protected long upperLimit;
    private int numOfProcesses;
    private Process[] processes;
    private CPUQueue queue;
    private CPU cpu1;
    private CPU cpu2;
    private int name;

    protected CPUProcess(){}

    public CPUProcess(int name, CPUQueue queue, CPU cpu1, CPU cpu2, int n, long min, long max){
        this.name = name;
        this.queue = queue;
        this.cpu1 = cpu1;
        this.cpu2 = cpu2;
        numOfProcesses = n;
        processes = new Process[numOfProcesses];
    }

    public void run(){
        int i = 0;
        while (i < numOfProcesses){
            processes[i] = new Process("Process" + i + "; Thread" + name);
            try {
                Thread.sleep(processes[i].generateTime()); // generating process

                if (!cpu2.isBusy() && name == 2){
                    System.out.println("Adding to queue " + processes[i].getProcessName());
                    queue.add(processes[i]);
                    i++;
                    continue;
                }
                if (!cpu1.isBusy()){
                    cpu1.executeProcess(processes[i]);
                }else if (!cpu2.isBusy()){
                    cpu2.executeProcess(processes[i]);
                }else if (name == 1){
                    System.out.println("Removed " + processes[i]);
                    processes[i] = null;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

}
