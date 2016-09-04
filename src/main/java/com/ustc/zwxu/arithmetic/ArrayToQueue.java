package com.ustc.zwxu.arithmetic;

import java.util.Queue;

class MyQueue
{
	private int size;
	private int front;
	private int rear;
	private int[] array;
	
	public MyQueue(int size) {
		super();
		this.size = size;
		array= new int[size];
		this.front=0;
		this.rear=0;
	}
	//队头出队
	public int pop()
	{
		int x=array[front];
		front=(front+1)%size;
		return x;
	}
	//队尾入队
	public void push(int i)
	{
		array[rear]=i;
		rear=(rear+1)%size;

	}	
}
public class ArrayToQueue {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue s = new MyQueue(3);
		s.push(3);
		s.push(6);
		s.push(5);
		
		System.out.print(s.pop());
		System.out.print(s.pop());
	}

}
