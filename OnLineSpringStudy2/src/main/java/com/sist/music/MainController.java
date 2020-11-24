package com.sist.music;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 *    ==> VO�� ������ ��� Ŭ������ �������� ������û
 *    ����� ���� Ŭ������ ��Ƽ� ���� (�����ֱ�)
 *          => Ŭ���� ��ü ���� ~ ��ü �Ҹ�  ==> ���赵 ���� �����ϴ� 
 *                                      �ٸ� Ŭ������ ������ ��ġ�� �ʴ´�
 *              ���ռ�(������) ���� ���α׷� 
 *              ���� => �ٸ� ������ �ƴ��� Ȯ��   
 *              =======================
 *              �޸� �Ҵ� (���������� �Ѵ�) => �޸𸮸� �������� �ʴ´� 
 *              => �̱���
 *    XML : Ŭ������ ��Ű�� ������ �޸� �Ҵ� ��û
 *    Annotation : Ŭ���� ã��,�޼ҵ� ã�� 
 *    
 *    Container : Ŭ������ ��Ƽ� ���� 
 *      ==> ApplicationContext => application-context.xml
 *         ==================== XML �ļ�
 *    ***DI : ���� (setter,������ �Ű������� ���� ä���)
 *    ***AOP : �ݺ��� ���� => �ڵ� ȣ��(�ݹ�)
 *    ORM : Mapper(�����ͺ��̽� ����)
 *    MVC : Web
 *    ==================================
 *    Spring 5 => ���� �ڹٸ����� �ڵ� (XML�� ����) , kotlin (Annotation)
 *    
 *    DL : Ŭ������ ã�� �� ��� 
 *    DI : �޸� �Ҵ�ÿ� �ʿ��� �����͸� �޴´�
 *    
 *    ������ġ�� : ������ (���� : �Ѵ޿� 600����) => Spring
 */
@Controller
public class MainController {
   @RequestMapping("main/main.do")
   public String main_main(HttpServletRequest request)
   {
	   request.setAttribute("msg", "Hello Spring");
	   return "main/main";
   }
}
