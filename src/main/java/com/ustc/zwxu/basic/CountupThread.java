package com.ustc.zwxu.basic;
public class CountupThread extends Thread {

    private long counter = 0;

    private volatile boolean shutdownRequested = false;//保证内存同步

    public void shutdownRequest() {
        shutdownRequested = true;
        interrupt();//保证生命性
    }

    public boolean isShutdownRequested() {
        return shutdownRequested;
    }
  
    public final void run() {
        try {
        	while (!isInterrupted()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            doShutdown();
        }
    }

    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        //Thread.sleep(500);
        //此时不能检测到是否中断
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }

    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
