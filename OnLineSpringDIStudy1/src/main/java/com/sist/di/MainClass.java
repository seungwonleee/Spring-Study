package com.sist.di;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//////////////////////////////////
		Sawon s=new Sawon();
		s.setName("ȫ�浿");
		s.setSex("����");
		s.setAge(20);
		// DI(������ ����) 
		s.init();
		//////////////////////////////////
		s.print();// ���α׷��Ӱ� ȣ�� 

	}

}
