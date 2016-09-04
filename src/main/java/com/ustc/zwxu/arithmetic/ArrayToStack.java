package com.ustc.zwxu.arithmetic;

class MyStack
{
	private int max;
	private int top;
	private int[] array;
	public MyStack(int size)
	{
		max=size;
		array = new int[max];
	}
	public int pop()
	{
		return array[top--];
	}
	public void push(int i)
	{
		array[++top]=i;
	}	
}
public class ArrayToStack {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack s = new MyStack(3);
		s.push(3);
		s.push(6);
		System.out.print(s.pop());
	}

}
