package com.ustc.zwxu.test;

class Node
{
	int x;
}
public class PointerDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node a = new Node();
		a.x=3;
		Node b =new Node();
		b=a;
		System.out.println(b.x);
		a.x=4;
		System.out.println(b.x);
	}

}
