package com.ustc.zwxu.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

class Server{
	
}
public class Client {
	public void buildNullException(){
		
		try{
			int a=1/0;
			System.out.println("first step");
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("next step");
	}
	
	/**
	 * IOException JVM会提示主动try-catch
	 */
	public void buildIOException(){
		try {
			
			InputStream input = new FileInputStream("c:\\data\\input-text.txt");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("next step");
	}
	/*
	 * Error 系统级异常
	 */
	public void buildStackException(){
		try{
			buildStackException();
			
		}catch(Error e){
			e.printStackTrace();
		}
		System.out.println("next step");
		
	}
	
	public void buildHeapException(){
		ArrayList list=new ArrayList();
        while(true)
        {
            list.add(new Client());
            System.out.println("next step");
        }
	}

}
