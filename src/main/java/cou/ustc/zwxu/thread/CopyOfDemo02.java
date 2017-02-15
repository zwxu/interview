package cou.ustc.zwxu.thread;


public class CopyOfDemo02 {
	public static void func(int num){
		boolean flag=true;
		int len = (int) Math.sqrt(num);
		for(int i=2;i<=len;i++)
		{
			if(num%i==0)
			{
				flag=false;
				System.out.print(" "+i);
				//num=;
				func(num/i);
			}
			if(flag == false)
			{
				break;
			}
			
		}
		if(flag==true)
		{
			System.out.print(" "+num);
		}
	}
	public static void main(String[] args) {
		func(120);
	}

}
