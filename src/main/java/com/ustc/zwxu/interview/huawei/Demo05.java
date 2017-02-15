package com.ustc.zwxu.interview.huawei;

import java.util.Scanner;

public class Demo05 {

	/**
	 * 加密规则  A-b 0-1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		String str1 = scanner.next();
		String str2 = scanner.next();
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		encrypt(c1);
		unEncrypt(c2);
		
		
	}
	
	public static void encrypt(char aucPassword[])
	{

		char aucResult[] = new char[aucPassword.length];
		for(int i=0;i<aucPassword.length;i++)
		{
			if(aucPassword[i] >= 'a')
			{
				aucResult[i]=(char)(aucPassword[i]-32+1);
			}
			else if(aucPassword[i] >= 'A')
			{
				aucResult[i]=(char)(aucPassword[i]+32-1);
			}
			else if(aucPassword[i] == '9')
			{
				aucResult[i]='0';
			}
			else
			{
				aucResult[i]=(char)(aucPassword[i]+1);
			}
		}
		System.out.println(aucResult);
	}
	
	public static void unEncrypt(char result[])
	{
		char password[] =new char[result.length];
		for(int i=0;i<result.length;i++)
		{
			if(result[i] >= 'a')
			{
				password[i]=(char)(result[i]-32+1);
			}
			else if(result[i] >= 'A')
			{
				password[i]=(char)(result[i]+32-1);
			}
			else if(result[i] == '0')
			{
				password[i]='9';
			}
			else
			{
				password[i]=(char)(result[i]-1);
			}
		}
		System.out.println(password);
	}
	

}
