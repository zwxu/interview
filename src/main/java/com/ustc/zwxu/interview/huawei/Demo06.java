package com.ustc.zwxu.interview.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
   T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
	按照字符串规则进行加密
 */

public class Demo06 {

    public static void main(String[] args){
    	Scanner scanner = new Scanner(System.in);
		//华为笔试标准格式
		String str1 = scanner.next().toLowerCase();
		String str2 = scanner.next();
		encrypt(str1,str2);
    }
    
    public static void encrypt(String key,String data)
    {
    	char[] c1 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    	String output = filter(key).toString();
    	List<Character> list=new ArrayList<Character>();
    	for(int i=0;i<output.length();i++)
    	{
    		list.add(output.charAt(i));
    	}

		for(int j=0;j<26;j++)
		{

			if(!list.contains(c1[j]))
			{
				list.add(c1[j]);
			}
			
		}

    	
    	for(int i=0;i<data.length();i++)
    	{
    		char c = data.charAt(i);
    		if(c >= 'a')
    		{
    			int index = c-'a';
        		System.out.print(list.get(index));
    		}
    		else
    		{
    			int index = c-'A';
        		System.out.print(Character.toUpperCase(list.get(index)));
    		}
    		
    	}
    	

    }
    
    public static StringBuffer filter(String input)
	{
		StringBuffer output=new StringBuffer();
		int[] count = new int[26] ;
		for(int i=0;i<input.length();i++)
		{
			char c = input.charAt(i);

			count[c-'a']++;
			if(count[c-'a'] == 1)
			{
				output.append(c);
			}
			
		}
		return output;
	}

}
