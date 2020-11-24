package com.sist.di2;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
 *    class A
 *    {
 *        B b;
 *        public void setB(B b)
 *        {
 *           this.b=b;
 *        }
 *    }
 *    
 *    <bean id="a" class="A">
 *      <property name="b" ref="b">
 *    </bean>
 *    <bean id="b" class="B">
 */
import java.io.*;
public class ApplicationContext {
   private Map map=new HashMap();
   public ApplicationContext(String path)
   {
	   try
	   {
		   SAXParserFactory spf=SAXParserFactory.newInstance();
		   SAXParser sp=spf.newSAXParser();
		   XMLParser xp=new XMLParser();
		   sp.parse(new File(path), xp);
		   map=xp.map;
	   }catch(Exception ex){}
   }
   // DL (lookup) => �̸�(key)�� ������ Ŭ���� ��ü �ּҸ� ã���ִ� ���� 
   public Object getBean(String key)
   {
	   return map.get(key);
   }
   
}
