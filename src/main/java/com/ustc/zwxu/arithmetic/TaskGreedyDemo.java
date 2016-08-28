package com.ustc.zwxu.arithmetic;

public class TaskGreedyDemo {
	static int n=7;
	static void change(Task ta[], int maxwight)  //将所有的代价值用最大代价减去自身代价
	{
		for (int i = 0; i < n; i++)
		{
			ta[i].w = maxwight - ta[i].w;
		}
	}
	static void sortW(Task ta[])					//对权重进行排序
	{
		Task s = null;
		for (int i = n - 1; i > 0; i--)
		{
			for (int j = 0; j < i; j++)
			{
				if (ta[j].w < ta[j + 1].w)  //冒泡排序 递减排序
				{
					/*replace(s, ta[j]);
					replace(ta[j], ta[j + 1]);
					replace(ta[j + 1], s);*/
					s=replace(ta[j]);
					ta[j]=replace(ta[j+1]);
					ta[j+1]=replace(s);
					
					
				}
			}
		}
	}

	static void sortD(Task ta[], int k)			//将调度方案按照截止时间进行排序
	{
		Task s = null;
		for (int i = k - 1; i > 0; i--)
		{
			for (int j = 0; j<i; j++)
			{
				if (ta[j].d>ta[j + 1].d)
				{
					/*replace(s, ta[j]);
					replace(ta[j], ta[j + 1]);
					replace(ta[j + 1], s);*/
					s=replace(ta[j]);
					ta[j]=replace(ta[j+1]);
					ta[j+1]=replace(s);
				}
			}
		}
	}
	//static void replace(Task t,Task s) 			//复制任务
	static Task replace(Task s) 	
	{
		Task t=(Task) s.clone();
		return t;
		
	}
	static int greedy(Task a[], Task ta[])			//实现贪心算法
	{
		int max = 0, k = 0, i, j;
		int count = 0;
		int Nt[]=new int[n+1];//Nt[i]记录a[]中截止时间<=i的任务数
		sortW(ta);							//w递减排序
		//replace(a[0], ta[0]);
		a[0] = replace(ta[0]);
		//max = ta[0].d;
		k = 1;
		for (i = 0; i <= n; i++)//如果第一个不通过，则Nt为0
		{
			if (a[0].d <= i)
				Nt[i] = 1;
			else
				Nt[i] = 0;
		}
		for (i = 1; i<n; i++)//放入1，12，123，1234依次独立检测
		{
			for (j = ta[i].d; j <= n; j++)
			{
				if (Nt[j] + 1>j)//独立检测，说明ta[i]不能放入a[]中。
					break;
			}
			if (j == n + 1)	//遍历完后，就表明ta[i]能放入a[]中
			{
				//replace(a[k], ta[i]);
				a[k] = replace(ta[i]);//把早任务都放进以k为长度的数组
				k++;
				for (j = ta[i].d; j <= n; j++)//将ta[i]放入独立集合后，所有在t>ta[i].d后的Nt的值都要加1
				{
					Nt[j]++;
				}
			}
		}
		return k;//有效的早任务数
	}

	static int getW(Task a[], Task ta[], int k)	//计算延时任务的惩罚
	{
		int i = 0;
		int sum1 = 0, sum2 = 0;
		for (i = 0; i < k; i++)
		{
			sum1 += a[i].w;
		}
		for (i = 0; i < n; i++)
		{
			sum2 += ta[i].w;
		}
		return sum2 - sum1;
	}

	static int getMaxW(Task ta[],int maxwight)					//找到最大惩罚值
	{

		for (int i = 0; i < n; i++)//找到最大惩罚值
		{
			if (maxwight < ta[i].w)
				maxwight = ta[i].w;
		}
		return maxwight;
	}
	static void print(Task tasks[] , int k )//打印任务调度顺序
	{
		for (int i = 0; i < k; i++)
		{
			System.out.println("id="+tasks[i].id+" "+"d="+tasks[i].d+" "+"w="+tasks[i].w);
		}
		
	}
	public static void main(String[] args) {
		
		Task t1=new Task(2,2,60);
		Task t2=new Task(1,4,70);
		Task t3=new Task(3,4,50);
		Task t4=new Task(4,3,40);
		Task t5=new Task(5,1,30);
		Task t6=new Task(6,4,20);
		Task t7=new Task(7,6,10);
		Task A[]=new Task[7];		 //独立任务集合	
		int k=0;
		int maxwight = -99;//标记
		Task[] tasks={t1,t2,t3,t4,t5,t6,t7};
		sortW(tasks);
		print(tasks,tasks.length);
		maxwight = getMaxW(tasks,maxwight);//找到最大惩罚值
		//原始值确定最优调度
		k = greedy(A, tasks);//A存放着早任务数组
		sortD(A, k);
		System.out.println( "最优调度方案为：" );	
		print(A,k);
		System.out.println("惩罚为：" +getW(A, tasks, k));
		System.out.println("======================");
		//改变惩罚值重新确定最优调度
		change(tasks,maxwight);
		k = greedy(A, tasks);
		sortD(A, k);
		System.out.println("替换惩罚值后最优调度方案为：");
		print(A,k);
		System.out.println("惩罚为："+getW(A, tasks, k) );
		
	}
}
class Task implements Cloneable{
	public int id;
	public int d;
	public int w;
	public Task(int id, int d, int w) {
		super();
		this.id = id;
		this.d = d;
		this.w = w;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	protected Task clone(){
		
		 try { 
			   return (Task) super.clone();
			  } catch (CloneNotSupportedException e) {   
			   e.printStackTrace();
			   return null;
			  }

	}
}