package com.sist.di;
// ������ DI ==> ��ü �����ÿ� ������ �ް������� ���� ä����
/*
 *    XML , Annotation => �������� ��û 
 *    
 *    ==> ���α׷� 
 *        ������ ��ü ó�� (����Ʈ���� ��ü)
 *        �ʿ�ø��� �������� ��û => ���� ���´� (����Ʈ��� �����ϴ� ����� => ������)
 *          => ��� ���� (IoC) => ��ƾ �Ŀ﷯ 
 *        => ����Ʈ���� ������� ���α׷��� ���� (�ε� ����) => ������
 *        
 *        ������ => IoC Container (�淮 �����̳�) 
 *        
 */
public class Member {
   private String name;
   private String addr;
   private String tel;
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
