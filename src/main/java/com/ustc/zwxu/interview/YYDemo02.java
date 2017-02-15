package com.ustc.zwxu.interview;

import java.util.Scanner;
public class YYDemo02 {
    public static int filter(String input)    
    {
    	String[] array = input.split(" ");
    	int len = array.length;
    	int len2 = array[len-1].length();
    	return len2;
        
    }
 
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	while(in.hasNext())
    	{
    		String n = in.next();
    		int output = filter(n);
        	System.out.println(output);
    	}
    	
    }
}
