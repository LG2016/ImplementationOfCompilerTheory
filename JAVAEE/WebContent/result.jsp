<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>目标代码输出</title>
 <style type="text/css">    
 body{    
      background-image: url(temp/bg1.jpg);    
      background-repeat: repeat-x;    
 }    
 </style>    
 </head>    
</head>
<body>
<center>
	<span><font color="green" size="20"> 词法分析   和  LL(1)语法分析器 </font></span>
	<br><br><br>
	<a href="/JAVAEE/index.jsp"><font color="blue">《--跳转到源文件代码输入</font></a>
    <br><br><br>
  	 <div align="left">
    <label><font color="red" size="5">词法分析:</font></label>
    </div>
     <br>
	<textarea name="wordAnaly" rows="60" cols="80"><%=request.getAttribute("wordAnalyResult") %></textarea>
	 <br><br>
	 <div align="left">
	<label><font color="red" size="5">LL1语法分析:</font></label>
	</div>
	<br>
	<textarea name="langAnaly" rows="60" cols="80"><%=request.getAttribute("langAnalyResult") %></textarea>
	 

</center>
</body>
</html>