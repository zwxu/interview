package com.ustc.zwxu.arithmetic.greedy;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

class User
{
	private int name;
	private int age;
	public User(int name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
public class Test {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		User u1 = new User(1,2);
		User u2 = new User(3,4);
		List<User> list = new ArrayList<User>();
		Gson gson = new Gson();
		String b = gson.toJson(u1);
		System.out.print(new String(b.getBytes()));
		User u = gson.fromJson(b.toString(), User.class);
		
		System.out.print(u.getAge());
	}

}
