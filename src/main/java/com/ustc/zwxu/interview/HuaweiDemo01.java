package com.ustc.zwxu.interview;

public class HuaweiDemo01 {
	
	public StringBuffer filter1(String input)
	{
		StringBuffer output=new StringBuffer();
		int[] count = new int[26] ;
		for(int i=0;i<input.length();i++)
		{
			char c = input.charAt(i);
			//System.out.print(c-'a');
			count[c-'a']++;
			if(count[c-'a'] == 1)
			{
				output.append(c);
			}
		}
		return output;
	}
	
	public StringBuffer filter(String input)
	{
		StringBuffer output=new StringBuffer();
		for(int i=0;i<input.length();i++)
		{
			boolean flag = true;
			for(int j=0;j<i;j++)
			{
				if(input.charAt(i) == input.charAt(j))
				{
					flag = false;
				}
			}
			if(flag == true)
			{
				output.append(input.charAt(i));
			}
		}
		return output;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HuaweiDemo01 demo = new HuaweiDemo01();
		System.out.print(demo.filter1("abacb"));
	}

}
