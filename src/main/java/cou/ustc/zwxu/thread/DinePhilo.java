package cou.ustc.zwxu.thread;


public class DinePhilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tool spoon = new Tool("Spoon");
		Tool fork = new Tool("Fork");
		Pair pair = new Pair(spoon,fork);
		new EaterThread("Alice",pair).start();
		new EaterThread("Bobby",pair).start();
	}

}
class Tool
{
	private final String name;
	public Tool(String name){
		this.name=name;
	}
	public String toString(){
		return "[" + name + "]";
	}
}
class Pair {
	private final Tool lefthand;
	private final Tool righthand;
	public Pair(Tool lefthand, Tool righthand) {
		super();
		this.lefthand = lefthand;
		this.righthand = righthand;
	}
	public String toString(){
		return "[" + lefthand + " and "+ righthand +"]";
	}
}
class EaterThread extends Thread
{
	private String name;
	//private final Tool lefthand;
	//private final Tool righthand;
	private final Pair pair;
	public EaterThread(String name, Pair pair) {
		super();
		this.name = name;
		this.pair = pair;
	}
	public void run(){
		while(true)
		{
			eat();
		}
	}
	/*
	 * 若先放左，再放右，会出现死锁(尽管保证安全性，但降低了生存性)
	 */
	public void eat(){
		synchronized(pair){
			System.out.println(name + " takes up " + pair + ".");
			System.out.println(name + " is eating now, yam yam!");
			System.out.println(name + " puts down " + pair + ".");
		}
	}
}
