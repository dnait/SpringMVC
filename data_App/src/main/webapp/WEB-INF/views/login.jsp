<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>From JSP</title>
</head>
<%
System.out.println("Success!");
System.out.println(request.getParameter("name"));
java.util.Date date = new java.util.Date();
%>
<div>Current date is <%=date%> </div>
<body>
First JSP for ${name}
</body>
</html>