package com.sist.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import java.util.*;
import com.sist.vo.*;
public class MovieDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   ssf=CreateSqlSessionFactory.getSsf();
   }
   /*
    *   <select id="movieListData" resultType="MovieVO" parameterType="hashmap">
		    SELECT no,poster,title,num
		    FROM (SELECT no,poster,title,rownum as num
		    FROM (SELECT no,poster,title 
		    FROM daum_movie WHERE cateno=#{cateno} ORDER BY score DESC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="movieTotalPage" resultType="int" parameterType="int">
		    SELECT CEIL(COUNT(*)/12.0) FROM daum_movie
		    WHERE cateno=#{cateno}
		  </select>
    */
   public static List<MovieVO> movieListData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<MovieVO> list=session.selectList("movieListData",map);
	   session.close();// 반환
	   return list;
   }
   public static int movieTotalPage(int cateno)
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("movieTotalPage", cateno);
	   session.close();
	   return total;
   }
   /*
    *   <select id="movieNewsData" resultType="com.sist.vo.NewsVO" parameterType="hashmap">
		    <!-- Class.forName("com.sist.vo.NewsVO") 
		        private String title;
			    private String poster;
			    private String link;
			    private String content;
			    private String author;
		    -->
		    SELECT title,poster,link,content,author,num
		    FROM (SELECT title,poster,link,content,author,rownum as num 
		    FROM (SELECT title,poster,link,content,author 
		    FROM daum_news))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
    */
   // DAO ==> Model (List=>Controller=>JSP) => forward
   public static List<NewsVO> movieNewsData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<NewsVO> list=session.selectList("movieNewsData",map);
	   session.close();
	   return list;
   }
   /*
    *   <select id="newsTotalPage" resultType="int">
		    SELECT CEIL(COUNT(*)/20.0) FROM daum_news
		  </select>
    */
   public static int newsTotalPage()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("newsTotalPage");
	   session.close();
	   return total;
   }
   /*
    *   <select id="movieTotalData" resultType="MovieVO" parameterType="hashmap">
		    SELECT no,poster,title,num
		    FROM (SELECT no,poster,title,rownum as num
		    FROM (SELECT no,poster,title 
		    FROM daum_movie ORDER BY score DESC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="movieTotalPage2" resultType="int" parameterType="int">
		    SELECT CEIL(COUNT(*)/12.0) FROM daum_movie
		  </select>
    */
   public static List<MovieVO> movieTotalData(Map map)
   {
	   SqlSession session=ssf.openSession();
	   List<MovieVO> list=session.selectList("movieTotalData",map);
	   session.close();// 반환
	   return list;
   }
   public static int movieTotalPage2()
   {
	   SqlSession session=ssf.openSession();
	   int total=session.selectOne("movieTotalPage2");
	   session.close();
	   return total;
   }
   /*
    *   <update id="hitIncrement" parameterType="int">
		    UPDATE daum_movie SET
		    hit=hit+1
		    WHERE no=#{no}
		  </update>
		  <select id="movieDetailData" resultType="MovieVO" parameterType="int">
		    SELECT * FROM daum_movie
		    WHERE no=#{no}
		  </select>
    */
   public static MovieVO movieDetailData(int no)
   {
	   SqlSession session=ssf.openSession();
	   session.update("hitIncrement", no);
	   session.commit();
	   MovieVO vo=session.selectOne("movieDetailData", no);
	   session.close();
	   return vo;
   }
   
   public static List<MovieVO> movieReserveData()
   {
	   SqlSession session=ssf.openSession();
	   List<MovieVO> list=session.selectList("movieReserveData");
	   session.close();// 반환
	   return list;
   }
   /*
    *  <select id="movieTheaterNo" resultType="String" parameterType="int">
		    SELECT theater_no FROM movie_info
		    WHERE no=#{no}
		  </select>
		  
		  <select id="theaterListData" resultType="com.sist.vo.TheaterVO" parameterType="int">
		    SELECT * FROM theater_info
		    WHERE tno=#{tno}
		  </select>
    */
   public static String movieTheaterNo(int no)
   {
	   SqlSession session=ssf.openSession();
	   String tdata=session.selectOne("movieTheaterNo", no);
	   
	   session.close();
	   return tdata;
   }
   
   public static TheaterVO theaterListData(int tno)
   {
	   SqlSession session=ssf.openSession();
	   TheaterVO tdata=session.selectOne("theaterListData", tno);
	   session.close();
	   return tdata;
   }
   /*
    *   <select id="theaterReserveData" resultType="String" parameterType="int">
		    SELECT rday FROM theater_info
		    WHERE tno=#{tno}
		  </select>
    */
   public static String theaterReserveData(int tno)
   {
	   SqlSession session=ssf.openSession();
	   String rday=session.selectOne("theaterReserveData", tno);
	   session.close();
	   return rday;
   }
   /*
    *   <select id="dayTimeData" resultType="String" parameterType="int">
		    SELECT rtime FROM date_info
		    WHERE rday=#{rday}
		  </select>
		  
		  <select id="timeData" resultType="String" parameterType="int">
		    SELECT time FROM time_info
		    WHERE tno=#{tno}
		  </select>
    */
   // 1,4,5, 10
   public static String dayTimeData(int rday)
   {
	   SqlSession session=ssf.openSession();
	   String times=session.selectOne("dayTimeData", rday);
	   session.close();
	   return times;
   }
   
   public static String timeData(int tno)
   {
	   SqlSession session=ssf.openSession();
	   String time=session.selectOne("timeData", tno);
	   session.close();
	   return time;
   }
   /*
    *  <insert id="reserveInsert" parameterType="com.sist.vo.ReserveVO">
    */
   public static void reserveInsert(ReserveVO vo)
   {
	   SqlSession session=ssf.openSession(true);
	   session.insert("reserveInsert",vo);
	   session.close();
   }
   
   /*
    * <select id="mypageReserveListData" resultMap="reserveList" parameterType="string">
	    SELECT no,title,poster,theater,time,inwon,price,isreserve
	    FROM reserve,movie_info
	    WHERE mno=no AND id=#{id}
	  </select>
	  <select id="adminReserveListData" resultMap="reserveList">
	    SELECT no,title,poster,theater,time,inwon,price,isreserve
	    FROM reserve,movie_info
	    WHERE mno=no
	  </select>
    */
   public static List<ReserveVO> mypageReserveListData(String id)
   {
	   SqlSession session=ssf.openSession();
	   List<ReserveVO> list=session.selectList("mypageReserveListData",id);
	   session.close();
	   return list;
   }
   public static List<ReserveVO> adminReserveListData()
   {
	   SqlSession session=ssf.openSession();
	   List<ReserveVO> list=session.selectList("adminReserveListData");
	   session.close();
	   return list;
   }
   /*
    *   <update id="reserveOk" parameterType="int">
		    UPDATE reserve SET
		    isreserve='y'
		    WHERE no=#{no}
		  </update>
    */
   public static void reserveOk(int no)
   {
	   SqlSession session=ssf.openSession(true);//autocommit
	   session.update("reserveOk",no);
	   session.close();
   }
   /*
    *   사용자 요청  ==> *.do ==> DispatcherServlet(Controller) => Model(RequestMapping)
    *   ========
    *     1. <a href="main.do">
    *     2. <form action="insert.do"> 
    *     3. ajax => url:'update.do'
    *     
    *    =====> main.do 처리를 하는 메소드 찾기 
    *    =====> insert.do 
    */
   /*
    *  <!-- 좋아요 -->
		  <update id="likeIncrement" parameterType="int">
		    UPDATE movie_info SET
		    hit=hit+1
		    WHERE no=#{no}
		  </update>
    */
   public static void likeIncrement(int no)
   {
	   SqlSession session=ssf.openSession(true);
	   session.update("likeIncrement", no);
	   session.close();
   }
   /*
		  <!-- 찜 저장  -->
		  <insert id="jjimInsert" parameterType="com.sist.vo.JjimVO">
		    INSERT INTO jjim VALUES(
		      (SELECT NVL(MAX(no)+1,1) FROM jjim),#{id},#{mno}
		    )
		  </insert>
    */
   public static void jjimInsert(JjimVO vo)
   {
	   SqlSession session=ssf.openSession(true);
	   session.update("jjimInsert", vo);
	   session.close();
   }
   /*
		  <!-- 데이터 읽기(찜 목록) -->
		  <select id="jjimListData" parameterType="String" resultType="com.sist.vo.JjimVO">
		    SELECT * FROM jjim
		    WHERE id=#{id}
		  </select>
   */
   public static List<JjimVO> jjimListData(String id)
   {
	   SqlSession session=ssf.openSession();
	   List<JjimVO> list=session.selectList("jjimListData",id);
	   session.close();
	   return list;
   }
   /*
		  <!-- 찜여부 확인 -->
		  <select id="jjimCount" parameterType="com.sist.vo.JjimVO" resultType="int">
		    SELECT COUNT(*) FROM jjim
		    WHERE id=#{id} AND mno=#{mno}
		  </select>
   */
   public static int jjimCount(JjimVO vo)
   {
	   SqlSession session=ssf.openSession();
	   int count=session.selectOne("jjimCount",vo);
	   session.close();
	   return count;
   }
   /*
		  <!-- 찜 취소시에 처리  -->
		  <delete id="jjimDelete" parameterType="int">
		    DELETE FROM jjim
		    WHERE no=#{no}
		  </delete>
    */
   public static void jjimDelete(int no)
   {
	   SqlSession session=ssf.openSession(true);
	   session.delete("jjimDelete", no);
	   session.close();
   }
}




