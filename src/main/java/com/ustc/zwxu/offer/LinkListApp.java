package com.ustc.zwxu.offer;

import java.util.Scanner;



public class LinkListApp {
	private static void printlist_recursive(Node head){
		if(head != null)
		{
			if(head.next != null)
			{
				printlist_recursive(head.next);
			}
			System.out.print(head.data);
		}
	}
	
	public static void main(String[] args){
		LinkList list = new LinkList();
		list.insertRear2();
		list.display();
		//list.insertRear2(3);
		//list.insertRear2(5);
		//list.insertRear2(999);
		
		/*Node one = list.createNode(1);
		Node two = list.createNode(3);
		Node three = list.createNode(5);
		list.connectNode(one, two);
		list.connectNode(two, three);
		list.printlist(one);
		printlist_recursive(one);*/
		//list.printlist(one);
		
	}

}

class LinkList
{
	private Node head;

	
	public LinkList() {
		head = null;
	}

	public Node createNode(int data)
	{
		Node node=new Node(data);
		node.next=null;
		return node;
	}
	
	public void connectNode(Node current,Node next)
	{
		current.next=next;
	}
	
	public void insertFirst(int data)
	{
		Node newNode = new Node(data);
		newNode.next=head;
		head=newNode;
	}
	
	
	public void insertRear(int data)
	{
		Node newNode = new Node(data);
		if(head == null)
		{
			head = newNode;
		}
		else
		{
			Node rear = head;
			//每次更新尾巴为当前节点
			while(rear.next!=null)
			{
				rear=rear.next;
			}
			rear.next=newNode;
		}
		
	}
	
	public void insertRear2()
	{
		head = new Node();
		Node rear = head;
        Scanner in = new Scanner(System.in);
    	
    	while(in.hasNextInt())
    	{
    		int n = in.nextInt();
    		Node newNode = new Node(n);
		    
		    rear.next=newNode;
		    rear=newNode;

    	}
		
	    rear.next=null;
	    
		
	}
	
	public void display()
	{
		 Node current = head.next;
		 while (current != null) 
		 {
			 System.out.print(current.data);
			 current = current.next;
		 }
		 System.out.print("");
	} 
	
	public void printlist(Node head)
	{
		Node node=head;
		while(node != null){
			System.out.print(node.data);
			node=node.next;
		}
		System.out.println("");
	}
	
	
}

class Node
{
	public int data;
	
	public Node next;

	
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Node(int data) {
		this.data = data;
	}
	
}
