package com.sist.di2;
// �޸� �Ҵ� => DAO�� �ڵ��������� �޴´�
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class MainClass {
	@Autowired
    private MusicDAO dao;
	
	@Autowired
	private MovieDAO mDao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app2.xml");
        MainClass mc=(MainClass)app.getBean("mainClass");
        //MainClass mc=new MainClass();
        List<MusicVO> list=mc.dao.musicListData();
        for(MusicVO vo:list)
        {
        	System.out.println("��ȣ:"+vo.getMno());
        	System.out.println("�뷡��:"+vo.getTitle());
        	System.out.println("������:"+vo.getSinger());
        	System.out.println("�ٹ�:"+vo.getAlbum());
        	System.out.println("======================================");
        }
        System.out.println("===== ��ȭ ��� ======");
        List<MovieVO> mList=mc.mDao.movieListData();
        for(MovieVO vo:mList)
        {
        	System.out.println("��ȣ:"+vo.getNo());
        	System.out.println("��ȭ��:"+vo.getTitle());
        	System.out.println("�⿬:"+vo.getActor());
        	System.out.println("����:"+vo.getDirector());
        }
	}

}



