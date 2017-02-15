package com.ustc.zwxu.interview.huawei;

import java.util.Scanner;

public class Demo07 {

	/**
	 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		String str = scanner.nextLine();
		int english = getEnglishCharCount(str);	
		int blank = getBlankCharCount(str);
		int number = getNumberCharCount(str);
		int other = str.length()-english-blank-number;
		System.out.println(english);
		System.out.println(blank);
		System.out.println(number);
		System.out.println(other);

		
	}

	
	public static int getEnglishCharCount(String str)
	{
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if((c >= 'A' && c<= 'Z') || (c >= 'a' && c<= 'z'))
			{
				count++;
			}
		}
		return count;
	}
	
	public static int getBlankCharCount(String str)
	{
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(Character.isSpaceChar(c))
			{
				count++;
			}
		}
		return count;
	}
	
	public static int getNumberCharCount(String str)
    {
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			if(c >= '0' && c<= '9')
			{
				count++;
			}
		}
		return count;
    }
	
	
}
