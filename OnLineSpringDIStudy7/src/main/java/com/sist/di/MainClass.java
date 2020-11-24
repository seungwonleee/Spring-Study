package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Ŭ���̾�Ʈ���� ������ �� �� �ְ� ����� Ŭ����
// WEB => JSP(View)
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MusicDAO dao=(MusicDAO)app.getBean("musicDAO");
        List<MusicVO> list=dao.musicListData();
        for(MusicVO vo:list)
        {
        	System.out.println("��ȣ:"+vo.getMno());
        	System.out.println("�뷡��:"+vo.getTitle());
        	System.out.println("������:"+vo.getSinger());
        	System.out.println("�ٹ�:"+vo.getAlbum());
        	System.out.println("======================================");
        }
	}

}



