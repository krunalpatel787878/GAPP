<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Login Here</title>
</head>
<body style="background-color:#F8F8F8 ">


<form:form modelAttribute="user" class="form-horizontal" role="form">
<center>

<h1 class="page-header" style="background-color:#C0C0C0  ">
                           GAPP
                        </h1>
                        

                
<div class="col-lg-4">
    <div style="width:500px;text-align: left">
    <h1 class="page-header">
                            Login
                        </h1>
	</div>
<div >

 <div class="form-group">
 	<label class="control-label col-sm-2">Email</label>
 		<div class="col-sm-10">
			<form:input path="email" class="form-control"  placeholder="Email" /> <font color="red"><b><form:errors path="email" /></b></font>
		</div>
</div>

 <div class="form-group">
 	<label class="control-label col-sm-2">Password</label>
 		<div class="col-sm-10">
			<form:input type="password" path="password" class="form-control"  placeholder="password"/><font color="red"> <b><form:errors path="password" /></b></font>
		</div>
</div>

<div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
		<input type="submit" value="Submit" class="btn btn-default">  
	</div>
	
</div>

</div>

<a href="registration.html" style="margin-left:88px;" >New user register here</a>
</div>


</center>

</form:form>

</body>
</html>
