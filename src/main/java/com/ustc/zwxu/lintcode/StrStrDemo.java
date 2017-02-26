package com.ustc.zwxu.lintcode;

public class StrStrDemo {

	public static int strStr(String source, String target) {
		if(source == null || target == null)
		{
			return -1;
		}
		if(source.equals(""))
		{
			return -1;
		}
        int len1 = source.length();
        int len2 = target.length();
        int i = 0;
        int position = 0;
        while(i < len1 && position < len2)
        {
        	if(source.charAt(i) != target.charAt(position))
        	{
        		if(i == 0)
        		{
        			i++;
        			position = 0;
        		}      			     		
        	}
        	else
        	{
        		i++;
        		position++;
        	}
        }
        if(i == len1 && position == 0)
        {
        	return -1;
        }
		return i-len2;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(strStr("source","target"));

	}

}
