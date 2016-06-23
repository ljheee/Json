package com.ljheee.entity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {
		
//		toJson();
		fromJson();
	}
	
	/**
	 * json--->object
	 * @throws FileNotFoundException 
	 */
	private static void fromJson() throws FileNotFoundException {
		//从文件中  读json
		FileReader reader = new FileReader("data.json");
		
		Gson gson = new Gson();
		User u = gson.fromJson(reader, User.class);//把reader流  中的数据，拼装成指定类型的对象
		System.out.println(u.name +"   "+u.age);
		
	}

	/**
	 * object--->json
	 */
	public static void toJson() {
		User u1 = new User();
		
		u1.name = "mm";
		u1.age = 21;
		
		Gson gson = new Gson();//创建一个Gson对象，功能很强大
		
		String json = gson.toJson(u1);
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

	
	
}
