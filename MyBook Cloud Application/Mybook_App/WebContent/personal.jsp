<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align ="center">
My Profile<br>

<% 
int k; 
String m="";
String pm[] = (String[])request.getSession().getAttribute("pmessage");
for (k=0; k<pm.length ; k++) { 
	m = pm[k];
%> 
Message : <%=m %>
<br/><br/>
___________________________________________________________________________________
<br/>


<% } %>



<% 
int i; 
String j="";
String pers[] = (String[])request.getSession().getAttribute("personal");
for (i=0; i<pers.length ; i++) { 
	j = pers[i];
%> 
<img src= <%= j %> /> 
<br/><br/>
___________________________________________________________________________________
<br/>


<% } %>

 
<br>

</div>
</body>
</html>