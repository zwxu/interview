package com.ustc.zwxu.offer;

/*
 * 剑指offer 二维数组中的查找
 */
public class Demo04 {

	public static boolean Find(int [][] array,int target) {
		int cols=array[0].length;
		int rows=array.length;
		if(array != null && cols>0 && rows>0)
		{
			int row=0;
			int col=cols-1;
			while(row<rows && col>=0)
			{
				if(array[row][col] > target)
				{
					col--;
				}
				else if(array[row][col] < target)
				{
					row++;
				}
				else
				{
					return true;
				}
			}
		}
		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[][]={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.print(Find(array,5));
	}

}
