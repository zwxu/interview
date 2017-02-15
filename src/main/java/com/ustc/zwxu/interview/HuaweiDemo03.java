package com.ustc.zwxu.interview;

import java.util.Scanner;
/**
 * 输入用nextLine
 * 输出不要夹带任何格式，除非题目要求
 * 模块化可给高分
 */
public class HuaweiDemo03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		String input = scanner.nextLine();
		System.out.println(findLastWordLength(input));
	}
	
	public static int findLastWordLength(String input)
	{
		if(input.length() < 0 || input == null)
		{
			return -1;
		}
		String[] number = input.split(" ");
		return number[number.length-1].length();	
	}

}
