<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<html>
<head><title>Users</title></head>
<body>
<%--  <table>
<tr><th>ID</th><th>email</th></tr>
<c:forEach items="${users}" var="user">
<tr>
  <td>${user.id}</td>
  <td>${user.email}</td>
</tr>
</c:forEach>
</table>  --%> 

<%-- <table>
<tr><th>ID</th><th>name</th><th></th></tr>
<c:forEach items="${users}" var="d">
<tr>
  <td>${d.id}</td>
  <td>${d.term}</td>
  <td> ${d.program.department.departmentName}</td>
</tr>
</c:forEach>
</table>   --%>

<table>
<tr><th>ID</th><th>name</th><th></th></tr>
<c:forEach items="${users}" var="d">
<tr>
  <td>${d.id}</td>
  <td>${d.term}</td>
  <td> ${d.student.firstName}</td>
  <td> ${d.student.email}</td>
</tr>
</c:forEach>
</table>  

</body>
</html>