package cou.ustc.zwxu.thread;

/*
 * 交替输出奇数和偶数
 */

enum AccountType
{
    SAVING, FIXED, CURRENT;
    AccountType()
    {
        System.out.println("It is a account type");
    }
}
public class Test {

	public Test(){}
	private static int i=1;
    public int getNext(){
         return i++;
    }
    public static void main(String [] args){
    	 System.out.println(AccountType.FIXED);
        Test test=new Test();
        Test testObject=new Test();
        test.getNext();
        testObject.getNext();
        System.out.println(testObject.getNext());
    }

}

class ClientThread implements Runnable
{
	private int id;
	private static int num=1;
	public ClientThread(int id) {
		super();
		this.id = id;
	}

	public void run() {
	
		synchronized(ClientThread.class)
		{
			while(true)
			{
				if(num == id)
				{
					System.out.println(id);
					num++;
					ClientThread.class.notifyAll();//this
				}
				else
				{
					try {
						ClientThread.class.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
