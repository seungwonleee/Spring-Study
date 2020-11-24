package com.sist.di3;

import org.springframework.stereotype.Component;

/*
 *    1. ������� �ʱ�ȭ 
 *       1) ����� �ʱ�ȭ
 *       =============
 *       2) setter
 *       3) ������
 */
@Component("mem")
public class Member {
    private String name="ȫ�浿";
    private String addr="����";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public void print()
	{
		System.out.println("�̸�:"+name);
		System.out.println("�ּ�:"+addr);
	}
  
}
