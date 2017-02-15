/*package com.ustc.zwxu.offer;

public class ArrayListApp {
	private static void reverse(ArrayList list)
	{
		int temp;
		for(int i=0;i<list.length/2;i++)
		{
			temp=list.a[i];
			list.a[i]=list.a[list.length-i-1];
			list.a[list.length-i-1]=temp;
		}
	}
	
	public static void main(String[] args){
		ArrayList array = new ArrayList(5);
		array.insert(1);
		array.insert(3);
		array.insert(5);
		array.display();
		reverse(array);
		array.display();
	}

}

class ArrayList
{
	public int[] a;
	public int length;
	public ArrayList(int max) {
		a = new int[max];
		length = 0;
	}
	
	public void insert(int i)
	{
		a[length]=i;
		length++;
	}
	
	public void display()
	{
		for(int i=0;i<length;i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println("");
		
	}
	
	
}
*/