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
		//���ļ���  ��json
		FileReader reader = new FileReader("data.json");
		
		Gson gson = new Gson();
//		User u = gson.fromJson(reader, User.class);//��reader��  �е�����[����u]��ƴװ��ָ�����͵Ķ���
		
		Type t = new TypeToken<ArrayList<User>>(){}.getType();
		
		//���ڴ� ������  ���ͺܸ��ӡ���һ��װ�� User��ArrayList������ǰ�����Լ��������������
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
		
		Gson gson = new Gson();//����һ��Gson���󣬹��ܺ�ǿ��
		
		String json = gson.toJson(list);
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
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		toJson();
//		fromJson();
	}
	
	
}
