package com.ustc.zwxu.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 剑指offer 从尾到头打印链表
 */
public class Demo05 {
	private static List<Integer> list = new ArrayList<Integer>();
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		
		if(listNode !=null)
		{
			
			
			if(listNode.next!=null)
			{
				printListFromTailToHead(listNode.next);
			}
			list.add(listNode.i);
			
		}
        return (ArrayList<Integer>) list;
    }
	
  public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
	  	Stack<ListNode> stack = new Stack<ListNode>(); 
	    while(listNode!=null)
	    {
	    	stack.push(listNode);
	    	listNode=listNode.next;
	    }
	    while(!stack.isEmpty())
	    {
	    	list.add(stack.pop().i);
	    }
        return (ArrayList<Integer>) list;
    }

	public static void main(String[] args) {
		ListNode node1= new ListNode(1);
		ListNode node2= new ListNode(2);
		ListNode node3= new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		System.out.print(printListFromTailToHead2(node1));
	}

}

class ListNode
{
	public int i;
	public ListNode next;
	public ListNode(int i) {

		this.i = i;
	}
	
	
}
