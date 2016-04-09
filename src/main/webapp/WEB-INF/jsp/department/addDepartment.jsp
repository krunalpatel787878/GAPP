<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>Add Department</title>
</head>
<body style="background-color:#F8F8F8 ">


<b><a href="<c:url value='/user/login.html' />"  style="margin-left:10px;">LogOut</a></b>
    <div style="width:500px;text-align: left;margin-left:20px;">
    <b><u><a href="<c:url value='/user/home.html' />"  style="margin-top:20px;">Home</a></u></b>
    <h3 class="page-header">
                            Admin
                        </h3>
                        
	</div>
	
<form:form modelAttribute="department" class="form-horizontal" role="form">	
	<div class="col-lg-5">
    <div style="width:500px;text-align: left">
    <h4 class="page-header">
                            Add Department
                        </h4>
	</div>
<div >


 <div class="form-group">
 	<label class="control-label col-sm-2">Department Name</label>
 		<div class="col-sm-10">
			<form:input path="departmentName" class="form-control"  placeholder="Department Name" required="required" /> 
		</div>
</div>



<div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
		<input type="submit" value="Submit" class="btn btn-default">  
	</div>
</div>
</div>
</div>


</form:form>
</body>
</html>