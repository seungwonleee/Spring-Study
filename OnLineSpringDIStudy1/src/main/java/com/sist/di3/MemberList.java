package com.sist.di3;
/*
 *   == ���ռ�(������) ���� ���α׷�  (new�� ���)
 *   == ���ռ�(������) ���� ���α׷� (�������� ���� ���α׷��� ����Ѵ�)
 *      ==========
 *      ����� => �ٸ� Ŭ����
 *      ������ => ���õ� �޼ҵ带 �� ��� ���
 *   �� ���� 
 *     = �Ϲ� ������
 *     = Ŭ���� �ּҰ�  (ref) ref="bean�±��� id���� �ο�"
 *      Member mem=new Member();
 *     MemberList ml=new MemberList();
 *     ml.setMem(mem)
 *     
 *    
 */
public class MemberList {
    private Member mem;

	public Member getMem() {
		return mem;
	}
	
	public void setMem(Member mem) {
		this.mem = mem;
	}
	
	public void print()
	{
		System.out.println("ȸ����ȣ:"+mem.getNo());
		System.out.println("�̸�:"+mem.getName());
		System.out.println("����:"+mem.getSex());
		System.out.println("�ּ�:"+mem.getAddr());
		System.out.println("��ȭ:"+mem.getTel());
	}
   
}
