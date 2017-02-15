package com.ustc.zwxu.interview;


import java.util.Scanner;


public class WangYiDemo08 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x1 = sc.nextInt();
		int x2 = sc.nextInt();
		int x3 = sc.nextInt();
		int x4 = sc.nextInt();
		int a = (x1+x3)/2;
		int b = (x3-x1)/2;
		int c = (x4-x2)/2;
		
		if((a-((x1+x3)/2))!=0){
            System.out.print("No");
            return ;
        }
        if((b-((x3-x1)/2)!=0)||(b!=((x2+x4)/2))){
            System.out.print("No");
            return ;
        }
        if((c-((x4-x2)/2))!=0){
            System.out.print("No");
        return ;
        }
        //满足所有的约束条件，输出解。
        System.out.print((int)a+" "+(int)b+" "+(int)c);

	}



	
}
