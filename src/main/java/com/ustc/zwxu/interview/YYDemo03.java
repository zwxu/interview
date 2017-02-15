package com.ustc.zwxu.interview;

import java.util.Scanner;
public class YYDemo03 {
	public int x;
    public static int count(String input,String in)    
    {
    	
		int output =0;
		for(int i=0;i<input.length();i++)
		{
			char c = input.charAt(i);
			if(c == Character.toLowerCase(in.toCharArray()[0]) || c == Character.toUpperCase(in.toCharArray()[0]))
			{
				output++;
			}
			
		}
		return output;
        
    }
 
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	
    	while(in.hasNext())
    	{
    		String x = in.next();
    		String y = in.next();
    		int output = count(x,y);
        	System.out.println(output);
    	}
    	
    }
}
