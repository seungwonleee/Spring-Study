package com.sist.xml;

import javax.xml.bind.annotation.XmlRootElement;

/*
 *   news => naver ==> JAXB (XML => Java Class��ȯ) : �𸶼�
 *   ==============    JAXB (Java Class=> XML) :����
 *   <rss>  �±� (�±�) ==> Ŭ���� 
 *     <channel> => Ŭ���� 
 *       <item>
 *         <title>aaa</title> ������ 
 *         <description>aaa</description>
 *         <author>aaa</author>
 *         <link>aaa</link>
 *       </item>
 *       <item>
 *         <title>aaa</title>
 *         <description>aaa</description>
 *         <author>aaa</author>
 *         <link>aaa</link>
 *       </item> ==> <item> => 50��
 *    </channel>
 *  </rss>
 *  
 *     <member>  ==> class Member
 *       <list>  ==> class List 
 *                   {
 *                       private String name
 *                       private String sex
 *                   }
 *         <name>aaa</name>
 *         <sex>aaa</sex>
 *       </list>
 *     </member>
 */
@XmlRootElement
public class Rss {
   private Channel channel=new Channel();

	public Channel getChannel() {
		return channel;
	}
	
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
  
}








