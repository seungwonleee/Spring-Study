<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- 
  1. ����
     margin , padding
  2. ����
     text-align: left , right , center
  3. \n , \n���� ���
     display:block , display:inline
  4. font ���� 
     font-size
     font-family
     font-weight
  5. ���� 
     color (���� ����)
     background-color(������)
  6. ����  : width
  7. ũ��  : height
  
  => text ����
     => ������Ʈ => ���ڿ� 
     color ���� 
     1)���� ���� : color 
     => color:red
     => color:RGB(255,255,255)
     => color:RGBA()
     2)text-decoration:none , underline
     ***3)text-align:left,center,right
     4)text-shadow:none|(���ΰŸ�) ���ΰŸ� �������� ����
     5)text-transform : �빮�� ��ȯ,�ҹ��ں�ȯ
     ***6) white-space: ���뺸�� , ��� 
     white-space : normal|nowrap|pre(�ٹٲ��� ����)|pre-line|pre-wrap(�ڵ� �ٹٲ�)
         ==================
                  �����ȿȿȿ��̿��̤Ǥ���
                  �Ǥ����̿Ȥ��ָ�����
         ==================
     ===> fixed ���� 
  => img ���� 
  
  => div ����
  
  => span ���� 
  
  => �ִϸ��̼� 
  
  => CSS3
      = ���������� �Ӽ����� �ٸ��� 
     
 -->
<style type="text/css">
h1 {
   color:rgb(0,200,0);/*�׸��ǿ��� ������ ���� => RGB css������ �����ϸ� ������*/
}
h2 {
    color:blue;
}
h3 {
   text-decoration: underline;
   /*a �±״� �⺻ : underline*/
}
.t {
   text-transform: uppercase;/*�빮��*/
}
.t1 {
    text-transform: capitalize;/*INITCAP*/
}
.t2 {
      text-transform: lowercase;/*�ҹ��� ���*/
}
#h1{
   color: orange;
}
#h2{
     text-shadow: 5px 5px 3px #f00;
}
#h3{
   color:#FFF;/*���*/
   text-shadow:7px -7px 5px #000;
}
</style>
</head>
<body>
 <!-- color -->
 <h1>10000���� ������</h1>
 <h2>����������</h2>
 <h3>��/��</h3>
 <ul>
   <li class="t">java</li>
   <li class="t">oracle</li>
   <li class="t1">spring</li>
   <li class="t2">MYBATIS</li>
 </ul>
 <h1 id="h1">HTML&CSS</h1>
 <h1 id="h2">HTML&CSS</h1>
 <h1 id="h3">HTML&CSS</h1>
 <table border=1 bordercolor=black width=100>
   <tr>
    <td>
    <pre style="white-space: pre-wrap;">
    fslafjkasjflasfjklasjfsaljfsakljfjasklfasjfjkalfhfhfhfhfhfhfhf
    dgdsdgdgdgdgdgdgdgdgdgfhfhfhf
    </pre>
    </td>
   </tr>
 </table>
</body>
</html>



