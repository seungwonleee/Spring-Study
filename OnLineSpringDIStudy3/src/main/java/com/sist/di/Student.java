package com.sist.di;
/*
 *   <bean id="s" class="Student" init-method="init" destory-method="destory"
 *     p:name="ȫ�浿"  => setterDI
 *     p:kor=90
 *     p:eng=70
 *     p:math=80
 *   >
 *   
 *   ����
 *   1) Class.forName("Student") => �޸� �Ҵ� 
 *   2) setXxx()�� ���� ä���ش� 
 *   3) init-method=> ȣ�� 
 *  ===========================================
 *  
 *  
 *   4) ���α׷��� ���� => ���α׷���
 *   
 *   
 *  ===========================================
 *   5) destory-method => ȣ�� 
 *  ===========================================
 */
public class Student {
    private String name;
    private int kor;
    private int eng;
    private int math;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
   
}
