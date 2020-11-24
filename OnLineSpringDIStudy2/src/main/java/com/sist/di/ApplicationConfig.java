package com.sist.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// XML ��ü
/*
 *    class ����
 *    class ���  extends ����
 *    class ��  extends ����   (���)����
 *    class ��  extends ����
 */
@Configuration
public class ApplicationConfig {
    // Ŭ���� 
	@Bean("sa")
	// <bean id="sa" class="Sawon">
	public Sawon sawonInfo()
	{
		Sawon sa=new Sawon();
		/*
		 *   <bean id="sa" class="Sawon"
		 *     p:name="ȫ�浿"
		 *     p:addr="����"
		 *     p:tel="010-1111-1111"
		 *   />
		 */
		sa.setName("ȫ�浿");
		sa.setAddr("����");
		sa.setTel("010-1111-1111");
		return sa;
	}
	@PostConstruct
	// <bean id="sa" class="Sawon" init-method="init" destory-method="destory">
	/*
	 *   �޼ҵ� ȣ�� 
	 *     ��ü������ : init-method  (@PostConstruct)
	 *               =========== DB (����̹� ���)
	 *     ��ü�Ҹ�� : destory-method (@PreDestroy)
	 *               =========== DB (disConnection)
	 *               
	 *     DI 
	 *      = setter DI
	 *      = method DI (init-method,destory-method)
	 *      = constructor DI ������ �Ű����� �� ���� 
	 *      = �ڵ� ���� 
	 */
	public void init()
	{
		System.out.println("===== ��� ���� =======");
	}
	@PreDestroy
	public void destory()
	{
		System.out.println("====================");
	}
}




