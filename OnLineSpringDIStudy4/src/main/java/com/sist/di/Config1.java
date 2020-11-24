package com.sist.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config1 {
   @Bean("sawon")
   public Sawon sawonInfo()
   {
	   /*
	    *   <bean id="sa" class="com.sist.di.Sawon"
		      p:name="ȫ�浿"
		      p:dept="������"
		      p:job="�븮"
		    />
		     * 
		     * map.put("sa",new Sawon()) => 100
		     * 
		     * public Object getBean(String id)
		     * {
		     *    return map.get(id);
		     * }
		     * 
		     * Sawon sa=getBean("sa")
		     * Sawon sa=100
		     * 
		     * int a=10;
	    */
	   Sawon s=new Sawon();// ��ü ���� 
	   // DI
	   s.setName("�̼���");
	   s.setDept("���ߺ�");
	   s.setJob("����");
	   return s;
   }
}
