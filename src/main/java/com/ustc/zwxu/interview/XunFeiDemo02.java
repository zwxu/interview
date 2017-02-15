package com.ustc.zwxu.interview;

import java.util.HashMap;
import java.util.Map;


public class XunFeiDemo02 {
	public static StringBuffer Filter(StringBuffer input) {
		StringBuffer output=new StringBuffer();
		int count[]=new int[26];
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			count[ch-'a']++;
			if(count[ch-'a'] == 1)
			{
				output.append(ch);
			}
		}
		
		return output;

    }
	
	public static StringBuffer Filter2(StringBuffer input) {
		StringBuffer output=new StringBuffer();
		Map map= new HashMap();
		
		for(int i=0;i<input.length();i++)
		{
			char ch=input.charAt(i);
			if(!map.containsValue(ch))
			{
				map.put(i, ch);
				output.append(ch);
			}
		}
		
		
		return output;

    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(Filter(new StringBuffer("aabbccc")));
	}

}
