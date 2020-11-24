package com.sist.di5;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
/*
 *   ���������� �����ֱ� ���� �������̽� 
 *   InitializingBean : �ʱ�ȭ
 *   DisposableBean: �Ҹ� 
 *   
 *   ���� (�ʱ�ȭ)
 *    1. ������ => ��������� ���� ä��� => �޸� �Ҵ� 
 *    2. afterPropertiesSet() => setName,setDept
 *    ==========================================
 *    3. print() => ���α׷��� Ȱ��
 *    ==========================================
 *    4. close() => destory()
 */
public class Sawon implements InitializingBean,DisposableBean{

	private String name;
	private String dept;
	
	public Sawon(String name,String dept)
	{
		System.out.println("������ ȣ��(Sawon(String name,String dept))");
		this.name=name;
		this.dept=dept;
	}
	public void print()
	{
		System.out.println("���α׷��Ӱ� Ȱ�� : print()");
		System.out.println("�̸�:"+name);
		System.out.println("�μ�:"+dept);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setterDI(setName())");
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		System.out.println("setterDI(setDept())");
		this.dept = dept;
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��ü �Ҹ�:destory()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("setter DI ����:afterPropertiesSet()");
		
	}

}
