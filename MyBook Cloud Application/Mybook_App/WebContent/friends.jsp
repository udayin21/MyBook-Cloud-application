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
hello<br>
<% 
String friends[][] = (String[][])request.getSession().getAttribute("friends");
String noms[] = (String[])request.getSession().getAttribute("noms");
for (int i=0; i<friends.length ; i++) { 
	String[] j = friends[i];
	String name = noms[i];
	for (int k=0;k<j.length;k++){
		String link = j[k];
		System.out.println(link);
%> 
Friend : <%= name %>
<br/>

<img src= <%= link %> /> 
<br/>
___________________________________________________________________________________
<br/>
<br/>
<% }
	}%>
<br>

<% 
String mes[][] = (String[][])request.getSession().getAttribute("friendmes");
for (int i=0; i<mes.length ; i++) { 
	String[] j = mes[i];
	String name = noms[i];
	for (int k=0;k<j.length;k++){
		String m = j[k];
		System.out.println(m);
%> 
Friend : <%= name %>
<br/>

Message: <%= m%>
<br/>
___________________________________________________________________________________
<br/>
<br/>
<% }
	}%>
<br>

</div>
</body>
</html>