package com.sist.di;
/*
 *    Container : �������� Ŭ������ ��Ƽ� ���� ���� 
 *    ==========
 *      ApplicationContext (������ 4) : ���� ��� (������ 4)
 *         ==> XML�� �Ľ�
 *      AnnotationConfigApplicationContext (������ 5)
 *         ==> Annotation
 */
public class Sawon {
    private String name;
    private String dept;
    private String job;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
   
}
