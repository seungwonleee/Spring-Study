<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%--
  ���� Selector
  �±�:���� (�� a:hover,p:active)
 li:nth-child(1) (2) (3)... => �޴����� 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
/*
    �������� ����
*/
a:link {
	color:darkgrey;
}
a:visited {
	color:green;
}
/*
     ���  (���콺)
*/
a:hover{
    color:orange;
}
/*
   ���콺 Ŭ�� 
*/
p:active {
	color:red;
}
/*
     �ڽ��ȿ� ���콺 Ŭ�� => focus
*/
input:focus {
	background: blue;
}
/*
     table , dl , li => ������ �����ؼ� ã�� ��� 
     nth-child(1~)
     
        �޴� 
*/
li:nth-child(1) {
  color:red;	
}
li:nth-child(2) {
  color:blue;	
}
li:nth-child(3) {
  color:green;	
}
/*
    ������ ���� (Jsoup)
*/
tr:nth-child(1) {
   background-color: orange;	
}
tr:nth-child(2n) {
   background-color: RGB(255,255,200);	
}
</style>
</head>
<body>
  <!-- ����Ʈ �̵� (��ũ �±�) -->
  <!-- 
     a : �ζ��� �Ӽ� => ���� ��� 
     
     div , ul , ol , h1~h6 => block 
     a input img  => inline
   -->
  <a href="http://daum.net" style="display: block;">����</a>
  <%-- \n�� �����Ѵ� (block) --%>
  <a href="http://naver.net" style="display: block">���̹�</a>
  <p>Ŭ���ϼ���</p>
  <input type=text size=15>
  <ul>
    <li>�ڹ�</li>
    <li>����Ŭ</li>
    <li>������</li>
    <li>MyBatis</li>
    <li>�ڹٽ�Ʈ��Ʈ</li>
    <li>Ajax</li>
    <li>React</li>
  </ul>
  <table border=1 bordercolor=black width=500>
    <tr>
      <th>�̸�</th>
      <th>����</th>
      <th>����</th>
      <th>����</th>
    </tr>
    <tr>
      <td>ȫ�浿</td>
      <td>89</td>
      <td>90</td>
      <td>78</td>
    </tr>
    <tr>
      <td>��û��</td>
      <td>89</td>
      <td>90</td>
      <td>78</td>
    </tr>
    <tr>
      <td>�ڹ���</td>
      <td>89</td>
      <td>90</td>
      <td>78</td>
    </tr>
  </table>
</body>
</html>






