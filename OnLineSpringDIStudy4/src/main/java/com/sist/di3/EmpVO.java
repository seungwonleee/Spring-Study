package com.sist.di3;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
// VO => ���������� �����ϴ� Ŭ������ �ƴϴ� (������) : ����� ���� �������� 
/*
 *    �������� �����ϴ� ��� 
 *    ================ Bean
 *    @Repository
 *    1. DAO
 *    @Component
 *    2. Manager (��ũ�Ѹ�,Ʈ���� , openApi)
 *    @Controller
 *    3. Model
 *    @Service
 *    4. Service (DAO+DAO) => BI
 *    @Aspect
 *    5. AOP(������)
 */
//@Setter
//@Getter
public class EmpVO {
   private int empno;
   private String ename;
   private String job;
   private Date regdate;
   private int sal;
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public int getSal() {
	return sal;
}
public void setSal(int sal) {
	this.sal = sal;
}
   
}







