package com.ustc.zwxu.offer;

/*
 * 剑指offer 实现单例模式
 */
public class Demo02 {
	private Demo02(){}
	private static Demo02 instance = new Demo02();
	//饿汉式
	public static Demo02 getInstance2()
	{
	
		return instance;
		
	}
		
	//懒汉式
	public static Demo02 getInstance1()
	{
	
			if(instance == null)
			{
				instance = new Demo02();
			}
		return instance;
		
	}
	
	
	
	public static Demo02 getInstance()
	{
		if(instance == null)
		{
			synchronized(Demo02.class)
			{
				if(instance == null)
				{
					instance = new Demo02();
				}
			}
		}
		return instance;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo02 d1 = getInstance1();
		Demo02 d2 = getInstance1();
		System.out.print(d1==d2);
	}

}
