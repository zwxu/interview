package com.ustc.zwxu.test;

public class HasStatic {// 1
    private static int x = 100;// 2
    public static void main(String args[]) {// 3
        HasStatic inc = new HasStatic();// 4
        
        int i = 0; 
        inc.fermin(i); 
        i= i ++; 
        System.out.println(i);
     
     } 
     void fermin(int i){ 
        i++; 
     } 
}
