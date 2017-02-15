package com.ustc.zwxu.interview;

import java.util.Scanner;


public class WangYiDemo01 {
	
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int arr[];
		while(sc.hasNext()){
			int n = sc.nextInt();
			if(n<1 || n>50)
			{
				break;
			}
			arr = new int[n];
			for (int i = 0; i < n; i++){
				int input = sc.nextInt();
				if(input<1 || n>1000)
				{
					throw new Exception("输入异常");
				}
				arr[i] = input;
			}
			System.out.println(solve1(n, arr));
		}
		sc.close();
	}

	private static int solve(int n, int arr[]) {
		int left = 0;
		int right = n - 1;
		int ans = 0;
		while (left < right){
			if (arr[left] > arr[right]){
				arr[right-1] += arr[right];
				right--; ans++;
			}else if(arr[left] < arr[right]){
				arr[left+1] += arr[left];
				left++; ans++;
			}else{
				left++; right--;
			}
		}
		return ans;
	}
	
	private static int solve1(int n, int arr[]) {
		int left=0;
		int right=n-1;
		int count=0;
		while(left<right)
		{
			if(arr[left] > arr[right])
			{
				arr[right-1]+=arr[right];
				right--;
				count++;
			}
			else if(arr[left] < arr[right])
			{
				arr[left+1]+=arr[left];
				left++;
				count++;
			}
			else
			{
				left++;
				right--;
			}
		}
		return count;
		
	}
	
}
