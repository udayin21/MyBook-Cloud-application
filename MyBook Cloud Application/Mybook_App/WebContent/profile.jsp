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
Hello <%= request.getSession().getAttribute("name") %>
<br>
<%= request.getSession().getAttribute("email") %>
<br>
<%= request.getSession().getAttribute("mobile") %>
</div>
<br>
<form action ="Follow" method="post">
User name: <input type="text" name="followingname" >
<input type="submit" value="FOLLOW">
</form>

<form action ="Following" method="post">
<input type="submit" value="PEOPLE I FOLLOW">
</form>

<form action ="Personal" method="post">
<input type="submit" value="MY STUFF">
</form>
<form action ="Friends" method="post">
<input type="submit" value="FRIEND'S STUFF">
</form>

<form action ="Addstuff" method="post">
Add path: <input type="text" name="objectname" >
Object name: <input type="text" name="objname" >
<input type="submit" value="ADD OBJECT">
</form>

<form action ="PMessage" method="post">
Add message: <input type="text" name="message" >
<input type="submit" value="ADD message">
</form>

</body>
</html>