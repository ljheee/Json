package com.ljheee.entity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Test {

	/**
	 * json--->object
	 * @throws FileNotFoundException 
	 */
	private static void fromJson() throws FileNotFoundException {
		//从文件中  读json
		FileReader reader = new FileReader("data.json");
		
		Gson gson = new Gson();
//		User u = gson.fromJson(reader, User.class);//把reader流  中的数据[对象u]，拼装成指定类型的对象
		
		Type t = new TypeToken<ArrayList<User>>(){}.getType();
		
		//现在待 解析的  类型很复杂。是一个装载 User的ArrayList；解析前我们自己定义了这个类型
		ArrayList<User> list = gson.fromJson(reader, t);
		
	}
	

	/**
	 * object--->json
	 */
	public static void toJson() {
		User u1 = new User();
		
		u1.name = "mm";
		u1.age = 21;
		u1.address= new Address("cs", "load498");
		u1.phones.add("135");
		u1.phones.add("157");
		u1.phones.add("150");
		
		ArrayList<User> list = new ArrayList<>();
		list.add(u1);
		
		User u2 = new User();
		u2.name = "bob";
		u2.phones.add("139");
		
		list.add(u2);
		list.add(u1);
		
		Gson gson = new Gson();//创建一个Gson对象，功能很强大
		
		String json = gson.toJson(list);
		System.out.println(json);
		
		//把 json字符串     写入文件
		try {
			FileWriter fw = new FileWriter("data.json");//文件不存在，会自动创建
			fw.write(json);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		toJson();
//		fromJson();
	}
	
	
}
