package com.sist.dao;
import java.io.*;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class BoardDAO {
   // XML파일 읽기
   private static SqlSessionFactory ssf;
   // 자동 초기화 => 블록
   static 
   {
	   try
	   {
		   // 파일 읽기
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   // XML 파싱 => 필요한 데이터를 저장한다 
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // 목록 읽기 
   // <select id="boardListData" resultType="BoardVO" parameterType="hashmap">
   public static List<BoardVO> boardListData(Map map)
   {
	   List<BoardVO> list=new ArrayList<BoardVO>();//list=> 값을 채운다
	   // Connection => Sqlession
	   SqlSession session=null;
	   try
	   {
		   // 연결 객체 
		   session=ssf.openSession();
		   // SQL문장 실행 요청
		   list=session.selectList("boardListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
   /*
    *     <update id="hitIncrement" parameterType="int">
		    UPDATE freeboard SET
		    hit=hit+1
		    WHERE no=#{no}
		  </update>
		  <select id="boardDetailData" resultType="BoardVO" parameterType="int">
		    SELECT no,name,subject,content,regdate,hit 
		    FROM freeboard
		    WHERE no=#{no}
		  </select>
    */
   //          resultType              parameterType
   public static BoardVO boardDetailData(int no)
   {
	   /*
	    *   resultType => 리턴형    ==> 
	    *   List<BoardVO> ==========> selectList
	    *   BoardVO       ==========> selectOne
	    *   parameterType => 매개변수
	    *   => 고급 : subquery , PL/SQL , Index
	    *   => MVC 
	    *   => JavaScript (Ajax)
	    */
	   BoardVO vo=new BoardVO();
	   // Connection => SqlSession
	   /*
	    *   자바 (JDBC) => autoCommit
	    *   UPDATE,DELETE,INSERT ==> commit
	    *   =====================
	    *   
	    *   session=ssf.openSession(true) => INSERT,UPDATE,DELETE
	    *   
	    *   session=ssf.openSession(); => UPDATE,SELECT
	    *   문장수행
	    *   session.commit()
	    */
	   SqlSession session=null;
	   try
	   {
		   // 연결 시도
		   session=ssf.openSession();
		   // 조회수 증가 
		   session.update("hitIncrement", no);
		   session.commit();
		   
		   // 실제 데이터 
		   vo=session.selectOne("boardDetailData", no);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // Connection 사용후에 반환  ==> DBCP
		   /*
		    *    JDBC 
		    *    1. 요청하면 연결 , 처리후에 해제 => UNPOOLED => 연결시간을 많이 소모한다
		    *                                            =================
		    *    DBCP 
		    *    1. 미리 오라클연결 => 객체 (POOL에 저장) => 처리가 끝나면 반드시 POOL안에 반환(재사용)
		    *    2. Connection을 제어  ==> POOLED
		    */
		   if(session!=null)
			    session.close();
	   }
	   return vo;
   }
   // 총페이지 구하기 
   /*
    *     <select id="boardTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/10.0) FROM freeboard
		  </select>
    */
   public static int boardTotalPage()
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   // 데이터 읽어 오기 
		   total=session.selectOne("boardTotalPage");// 대소문자 구분 
	   }catch(Exception ex)
	   {
		   // 에러 처리
		   ex.printStackTrace();
	   }
	   finally
	   {
		   // 반환 => 재사용
		   if(session!=null)
			   session.close();
	   }
	   
	   return total;
   }
   // 데이터 추가
   /*
    *   <insert id="boardInsert" parameterType="BoardVO">
		   INSERT INTO freeboard(no,name,email,subject,content,pwd)
		   VALUES(
		     (SELECT NVL(MAX(no)+1,1) FROM freeboard),
		     #{name},
		     ' ',
		     #{subject},
		     #{content},
		     #{pwd}
		   )
		  </insert>
    */
   public static void boardInsert(BoardVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.insert("boardInsert",vo);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   // 수정할 데이터 읽기 
   public static BoardVO boardUpdateData(int no)
   {
	   BoardVO vo=new BoardVO();
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   vo=session.selectOne("boardDetailData", no);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();// 에러 
	   }
	   finally
	   {
		   // 반환 
		   if(session!=null)
			   session.close();
	   }
	   return vo;
   }
   //수정 
   /*
    *   <select id="boardGetPassword" resultType="string" parameterType="int">
		    SELECT pwd FROM freeboard
		    WHERE no=#{no}
		  </select>
		  <update id="boardupdate" parameterType="BoardVO">
		    UPDATE freeboard SET
		    name=#{name},
		    subject=#{subject},
		    content=#{content}
		    WHERE no=#{no}
		  </update>
    */
   public static boolean boardUpdate(BoardVO vo)
   {
	   boolean bCheck=false;
	   SqlSession session=null;
	   try
	   {
		   // 연결
		   session=ssf.openSession();
		   // 비밀번호 검색 
		   String db_pwd=session.selectOne("boardGetPassword", vo.getNo());
		   if(db_pwd.equals(vo.getPwd()))// 본인여부 확인 => 수정
		   {
			   bCheck=true;
			   // 실제 수정을 한다 
			   session.update("boardupdate", vo);
			   session.commit();
		   }
		   else
		   {
			   bCheck=false;
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return bCheck;
   }
   
   // 삭제하기 
   /*
    *     <delete id="boardDelete" parameterType="int">
		    DELETE FROM freeboard
		    WHERE no=#{no}
		  </delete>
    */
   public static boolean boardDelete(int no,String pwd)
   {
	   boolean bCheck=false;
	   SqlSession session=null;
	   try
	   {
		   // 연결 
		   session=ssf.openSession();
		   // 비밀번호 검사
		   String db_pwd=session.selectOne("boardGetPassword", no);
		   if(db_pwd.equals(pwd))// 삭제
		   {
			   bCheck=true;
			   // 실제 데이터 삭제
			   session.delete("boardDelete",no);
			   session.commit();
		   }
		   else // 비밀번호가 틀리다
		   {
			   bCheck=false;
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return bCheck;
   }
}










