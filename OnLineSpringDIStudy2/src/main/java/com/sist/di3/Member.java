package com.sist.di3;

public class Member {
    private String name,addr,tel;

	public Member(String name, String addr, String tel) {
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}
	
	public void print()
	{
		System.out.println("�̸�:"+name);
		System.out.println("�ּ�:"+addr);
		System.out.println("��ȭ:"+tel);
	}
   
}
