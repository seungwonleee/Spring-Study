<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- ���� ��Ÿ�� (�Ѱ��� ���Ͽ����� ����) -->
<style type="text/css">
.book1 {
   list-style-type: lower-alpha;
}
.book2 {
   list-style-type: upper-roman;
}
.book3 {
  list-style-type: square;/*�̹��� ÷�ΰ� ����*/
  /*display: inline-block;*/
}
.book3 li{
  /*display: inline;*/
}
</style>
</head>
<body>
  <%--
       �޴� ==> �θ޴� (span)
    ol (order list)
    li (list item)
    => block 
   --%>
  <ol class="book1">
    <li>�ڹ��� ����</li>
    <li>����Ŭ�� ����</li>
  </ol>
  <ol class="book2">
    <li>�ڹ��� ����</li>
    <li>����Ŭ�� ����</li>
  </ol>
  <ul class="book3">
    <li>�ڹ��� ����</li>
    <li>����Ŭ�� ����</li>
  </ul>
</body>
</html>