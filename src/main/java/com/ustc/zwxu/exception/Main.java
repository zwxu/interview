package com.ustc.zwxu.exception;

public class Main {

	/**
	 * RuntimeException JVM主动抛出
	 */
	public static void main(String[] args) {
		Client c = new Client();
		c.buildStackException();
		/*try{
			c.buildStackException();
		}catch(Exception e){
			e.printStackTrace();
		}*/
	}

}
