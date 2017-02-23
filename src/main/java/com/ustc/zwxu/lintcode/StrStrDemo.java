package com.ustc.zwxu.lintcode;

public class StrStrDemo {
	
	public static int strStr2(String source, String target) {
		if(source == null || target == null)
		{
			return -1;
		}
		
        int len1 = source.length();
        int len2 = target.length();
        int i = 0;
        int j = 0;
        while(i < len1 && j < len2)
        {
        	if(source.charAt(i) == target.charAt(j))
        	{
        		i++;  
        		j++;  
        	}else{  
	            i = i-j+1; //主串在子串基础上加1  
	            j = 0; //子串要归零  
        	}  
        }
		if( j >= len2)  //子串比较完成  
			return i-len2;  
		else  
			return -1;  
    }

	public static int strStr(String source, String target) {
		if(source == null || target == null)
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
        		if(position == 0)
        		{
        			i++;
        			position = 0;
        		}
        		else
        		{
        			position = 0;
        		}
        	}
        	else
        	{
        		i++;
        		position++;
        	}
        }
        if(i == len1 && (position == 0 || position != len2) && len1 != 0)
        {
        	return -1;
        }
		return i-len2;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(strStr2("","ab"));

	}

}
