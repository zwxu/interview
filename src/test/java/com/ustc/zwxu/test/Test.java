package com.ustc.zwxu.test;

import java.util.Date;
class A{
	
}

public class Test extends A{
	 private static final long serialVersionUID = 1L; 
	    private void test(){ 
	       System.out.println(super.getClass()); 
	    } 
	      
	    public static void main(String[]args){ 
	       new Test().test(); 
	    } 
}
