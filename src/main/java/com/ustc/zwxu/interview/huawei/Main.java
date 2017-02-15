package com.ustc.zwxu.interview.huawei;

import java.util.Scanner;

class Print{
    private static char FLAG = 'A';
    synchronized void print(char charI){
        while (charI != FLAG) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(FLAG);
        FLAG += 1;
        if (FLAG == 'E') {
            FLAG = 'A';
        }
        notifyAll();
    }
}

class PrintA extends Thread{
    public static int count ;
    private Print print;
    public PrintA(Print print, int count) {
        this.print = print;
        this.count = count;
    }
    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            print.print('A');
        }
    }
}

class PrintB extends Thread{
    private Print print;
    public PrintB(Print print) {
        this.print = print;
    }
    @Override
    public void run() {
        for (int i = 0; i < PrintA.count; i++) {
            print.print('B');
        }
    }
}

class PrintC extends Thread{
    private Print print;
    public PrintC(Print print) {
        this.print = print;
    }
    @Override
    public void run() {
        for (int i = 0; i < PrintA.count; i++) {
            print.print('C');
        }
    }
}

class PrintD extends Thread{
    private Print print;
    public PrintD(Print print) {
        this.print = print;
    }
    @Override
    public void run() {
        for (int i = 0; i < PrintA.count; i++) {
            print.print('D');
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        Print print = new Print();//保证print对象是唯一的。
        new PrintA(print, sum).start();
        new PrintB(print).start();
        new PrintC(print).start();
        new PrintD(print).start();

    }

}