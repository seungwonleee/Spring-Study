package com.sist.di;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

/*
 *   <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
       p:username="hr"
       p:password="happy"
    />
 */
// ������ ���̽� ���� 
// �޸� �Ҵ�
/*
 *    @Component : �Ϲ� Ŭ����
 *    @Repository : ����� (DataBase�� ����) => DAO
 *    ================= Web
 *    @Controller : Model  ==> return ����Ʈ �ּ�(JSP���ϸ�)
 *    @RestController : Model ==> return �Ϲ� ���ڿ� (ajax,json...)
 *    =================
 *    @Service : Manager,DAO�� �������϶� ��� ���  BI
 */
@Component
// ID => myBasicDataSource
public class MyBasicDataSource extends BasicDataSource{
    public MyBasicDataSource()
    {
    	setDriverClassName("oracle.jdbc.driver.OracleDriver");
    	setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
    	setUsername("hr");
    	setPassword("happy");
    }
}






