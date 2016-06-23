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
		//���ļ���  ��json
		FileReader reader = new FileReader("data.json");
		
		Gson gson = new Gson();
		User u = gson.fromJson(reader, User.class);//��reader��  �е����ݣ�ƴװ��ָ�����͵Ķ���
		System.out.println(u.name +"   "+u.age);
		
	}

	/**
	 * object--->json
	 */
	public static void toJson() {
		User u1 = new User();
		
		u1.name = "mm";
		u1.age = 21;
		
		Gson gson = new Gson();//����һ��Gson���󣬹��ܺ�ǿ��
		
		String json = gson.toJson(u1);
		System.out.println(json);
		
		//�� json�ַ���     д���ļ�
		try {
			FileWriter fw = new FileWriter("data.json");//�ļ������ڣ����Զ�����
			fw.write(json);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
