package com.ustc.zwxu.test;

import java.util.ArrayList;

public class Base {
    String baseName = "base";
    public Base() {

        callName();
    }
    public void callName() {
        System.out.println(baseName);
    }
    
    public void add(Byte b)
    {
        b = b++;
    }
    public void test()
    {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
    
    static int x=10;
    static {x+=5;}
    public static void main(String[] args) //4
    {
    	ArrayList list = new ArrayList(20);
    	int _Hello$World;
    	boolean flag = false;
    	if (flag == true)
    	{
    	    System.out.println("true");
    	}
    	else
    	{
    	    System.out.println("false");
    	}
        System.out.println("x="+x);
    }
    //static{x/=3;};
}
class Sub extends Base {
    private String baseName = "sub";
    
  

	public void callName() {

        System.out.println(super.baseName);
    }
}
