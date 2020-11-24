package com.sist.xml;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;
/*
 *   ���� ���� : �Ľ��ϴ� ���� 
 *   => XML (MyBatis) => XML�� ��� �о� ������ 
 *      ���� API => XML => �Ľ� => �����͸� �Ѱ��ش� 
 *      JAXP : �Ľ� (�±׸� �Ѱ��� �о ������ ����)
 *             �б����� (O) SAX�Ľ�=>��κ� API���� ����ϴ� ��� , �б�����(X) : DOM�Ľ�
 *      JAXB : ���� (�ڹ�Ŭ����)
 *      
 *      =====> XML�� ������� �ִ� ==> XML�� ��ü�ϴ� ���α׷� (Annotation)
 *      =====> MVC =====> Spring =====> ��������  ==> ���� �޸� (Vue,React)
 *                                                              ======= React Native
 *                                                              �ȵ���̵�,������ 
 *      
 */
public class NewsManager {
   public List<Item> naverNewsData(String fd)
   {
	   List<Item> list=new ArrayList<Item>();
	   try
	   {
		   String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
				        +URLEncoder.encode(fd, "UTF-8");
		   URL url=new URL(strUrl);
		   // ���̹��� ���� ==> �ѱ��� �ݵ�� ���ڵ� URLEncoder.encode(fd, "UTF-8");
		   JAXBContext jb=JAXBContext.newInstance(Rss.class);
		   Unmarshaller un=jb.createUnmarshaller();
		   Rss rss=(Rss)un.unmarshal(url);// �����͸� ������ => RssŬ������ ���� ä���� 
		   /*
		    *   Rss => Channel => Item
		    */
		   list=rss.getChannel().getItem();
	   }catch(Exception ex) {}
	   return list;
   }
   public static void main(String[] args) {
	  NewsManager m=new NewsManager();
	  List<Item> list=m.naverNewsData("��ȭ");
	  for(Item i:list)
	  {
		  System.out.println(i.getTitle());
		  System.out.println(i.getDescription());
		  System.out.println(i.getAuthor());
		  System.out.println("===================================================");
	  }
   }
}







