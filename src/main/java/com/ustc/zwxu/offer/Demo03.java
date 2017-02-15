package com.ustc.zwxu.offer;

/*
 * 剑指offer 替换空格
 */
public class Demo03 {

	public static String replaceSpace(StringBuffer str) {
		StringBuffer output = new StringBuffer();
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			//System.out.print(c);
			if(c == ' ')
			{
				output.append('%');
				output.append('2');
				output.append('0');
			}
			else
			{
				output.append(c);
			}
		}
		return output.toString();
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer s= new StringBuffer("We Are Happy");
		System.out.print(replaceSpace(s));
	}

}
