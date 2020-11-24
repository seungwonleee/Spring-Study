package com.sist.di;
/*
 *   Container : ����(����) => Ŭ������ ��Ƽ� ���� 
 *   
 *        ���������� ����  (page 49) 
 *        ===========
 *          BeanFactory ==> CORE(DI)
 *             |
 *          ApplicationContext  AnnotationConfigApplicationContext
 *             |   DI , AOP                           |
 *        WebApplicationContext WebAnnotationConfigApplicationContext
 *                 DI , AOP , MVC
 *        ==> XML,Annotation�� ��� Ŭ������ �о ���� 
 *      
 *   Component : Ŭ���� �Ѱ�
 *   
 *          ���κ���
 *   ��ǻ��  : CPU , �޸� , �ϵ�.....
 */
public class Sawon {
    private String name;
    private String addr;
    private String tel;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	   
}
