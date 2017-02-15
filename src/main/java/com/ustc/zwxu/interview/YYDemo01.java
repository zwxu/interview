package com.ustc.zwxu.interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
public class YYDemo01 {
	public static final List list = new ArrayList();
	public static String test(String s)
	{
		
		int i=1;
		list.add(new String("11111111111111111111111111"));
		System.out.print(list);
		return test(i+s+"111111111111");
	}
    public static String getResult(long input)    
    {
        StringBuffer sb = new StringBuffer();
        for(long i=2;i<=input;i++)
        {
            if(input%i==0 && isPrime(i)==1)
            {
                input=input/i;
                sb.append(i+" ");
                i--;
            }
            else
            {
                continue;
            }
        }
        return sb.toString();
        
    }
    public static int isPrime(long number)
    {
        if(number==0 || number==1)
            return 0;
        if(number==2)
            return 1;
        for(int i=2;i<number;i++)
        {
            if(number%i == 0)
            {return 0;}
            
        }
        return 1;
        
    }
    public static void main(String[] args) {
    	/*Scanner in = new Scanner(System.in);
    	long n = in.nextLong();
    	String output = getResult(n);
    	System.out.println(output);*/
    	test("1111");
    }
}
