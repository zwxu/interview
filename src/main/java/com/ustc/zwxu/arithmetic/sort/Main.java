package com.ustc.zwxu.arithmetic.sort;


class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	 }

public class Main {

	 public static ListNode removeElements(ListNode head, int val) {
		 if(head == null)
		 {
			 return null;
		 }
		 ListNode first = head,last = head.next;
		 while(last!=null)
		 {
			 if(last.val == val)
			 {
				 first.next=last.next;
				 last=first.next;
			 }
			 else
			 {
				 first = first.next;
	             last = last.next;
			 }
		 }
		 if(head.val==val)
	           head = head.next;
		return head;
	    
	    }
	 
	public static void main(String[] args) {
		String a="abcd";
		String b="ab";
		System.out.print("".contains(""));
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);		
		ListNode node2 = new ListNode(2);
		//ListNode node3 = new ListNode(2);
		//ListNode node4 = new ListNode(3);
		node1.next=node2;
		//node2.next=node3;
		//node3.next=node4;
		
		ListNode head = removeElements(node1,1);
	    while(head !=null)
	    {
	    	System.out.print(head.val+">>");
	    	head=head.next;
	    }
		
	}

}
