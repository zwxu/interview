package com.ustc.zwxu.basic.callback;



public class CallBackDemo {
    
    public static void main(String[] args) {
          CallBackDemo demo = new CallBackDemo();
          Employee emp = new Employee();  
          
          //将回调对象（上层对象）传入，注册  
          emp.setAddress(new Boss());
            
          //开启控制器对象运行  
          emp.doSome();  
     }
}

interface CallBackInterface
{
	void execute();
}
class Boss implements CallBackInterface
{

	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("收到了！！" + System.currentTimeMillis());  
	}
}

class Employee
{
	private CallBackInterface address;//老板的通讯地址

	public CallBackInterface getAddress() {
		return address;
	}

	public void setAddress(CallBackInterface address) {
		this.address = address;
	}
	
	//工人干活  
    public void doSome(){  
        //1.开始干活了  
        for(int i=0;i<10;i++){  
            System.out.println("第【" + i + "】事情干完了！");  
        }  
          
        //2.告诉老板干完了  
        address.execute();  
    }  
}  

