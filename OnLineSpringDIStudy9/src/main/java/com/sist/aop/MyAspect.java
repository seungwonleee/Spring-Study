package com.sist.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 *     public void select()
 *     {
 *         try
 *         {
 *             %%%%%%%% ==> Before
 *             ----------
 *             insert();   Around  ===> JoinPoint  PointCut
 *             ----------
 *         }catch(Exception ex)
 *         {
 *             %%%%%%%% ==> After-Throwing
 *         }
 *         finally
 *         {
 *             %%%%%%%%  ==> After
 *         }
 *         return;  %%%%%% ==> After-Returning
 *     }
 */
// ���� ��� 
@Aspect
@Component
public class MyAspect {
   @Autowired
   private MyDAO dao;
   @Before("execution(* com.sist.aop.MyDAO.db_*(..))")
   // * ������ (������� ó��)  db_*() => �Ű������� ���� ����
   // db_*(int)  db_*(String,String)  db_*(..) �Ű���������(O),����(X)
   /*
    *    1. Before
    *    2. After
    *    3. After-Throwing
    *    4. After-Retruning
    *    5. Around
    *    =================== ȣ�� ��ġ (JoinPoint)
    *    ����Ǵ� �޼ҵ� ���� ==> PointCut
    *    ======================================= Advice ������ ==> Aspect
    *    
    *    ==> Proxy ���� 
    *        =========
    *          => ���ȣ��(��ü��)
    *          
    *          
    *    class A
    *    {
    *       public void display()
    *       {
    *           System.out.println("dispaly()");
    *       }
    *    }
    *    //// ���̺귯�� ���� 
    *    class Proxy
    *    {
    *        public void display(A a)
    *        {
    *            System.out.println("Before");
    *            a.display();
    *            System.out.println("After");
    *        }
    *    }
    *    
    *    A a=new A();
    *    a.display(); ==> X
    *    Proxy p=new Proxy();
    *    p.display(a); ==> O
    *    
    */
   public void before()
   {
	   dao.getConnection();
   }
   @After("execution(* com.sist.aop.MyDAO.db_*(..))")
   public void after()
   {
	   dao.disConnection();
   }
}
