package com.sist.di2;

import org.springframework.stereotype.Component;

@Component("sa")
/*
 *    1. Ŭ���� => �޸� �Ҵ� => ���� ���� (Container)
 *       ApplicationContext => Map
 *    2. Ŭ���� ã�� : DL
 *    3. ������ ���ÿ� �ʿ��� �����Ͱ� �ִ� ���   
 *       ==================== ó�� ==> DI  setter , constructor
 *                                        p:        c:
 *    4. Ȱ�� : ���α׷��� 
 *    5. �Ҹ� : �޸� ���� 
 *       @Component
 *        class Sawon
 *        
 *       @Component("mem")
 *        class Member
 *       ====================
 *        key      value
 *       ====================
 *        sawon    new Sawon()
 *       ====================
 *        mem      new Member()    => getBean("mem") ==> Member m=app.getBean("mem");
 *                                                                ===================
 *       ====================                                      new Member()
 *       AnnotationConfigApplicationContext
 *       = MVC = WebApplicationContext
 */

public class Sawon {
    private String name="��û��";
    private String dept="���ߺ�";
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
	   
}
