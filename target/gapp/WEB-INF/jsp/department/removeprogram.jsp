<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<title>Remove Program</title>
</head>
<body style="background-color:#F8F8F8 ">

<b><a href="<c:url value='/user/login.html' />"  style="margin-left:10px;">LogOut</a></b>
    <div style="width:500px;text-align: left;margin-left:20px;">
    <b><u><a href="<c:url value='/user/home.html' />"  style="margin-top:20px;">Home</a></u></b>
     <b><u><a href="<c:url value='departmentlists.html' />"  style="margin-top:20px;">Department</a></u></b>
    <h3 class="page-header">
                            Admin
                        </h3>
                        
	</div>
	
	
	<div class="col-lg-6">
<h4 class="page-header">
                           Remove Program
                        </h4>
<b>Department Name:</b>      &nbsp;<b>${dept.departmentName}</b>
<c:if test="${not empty program }">
 <div class="panel panel-default">
 
    <div class="panel-body">
  		  
           <div class="form-group">
           
                   
                        <table class="table table-striped">
                            <tr>
                                <th>
                                    Program Name
                                </th>
                             	<th>
                                    Remove
                                </th>
                            </tr>
                        <c:forEach items="${program}" var="each">
                            <tr>
                            	
                            	<td>
								${each.majorName } 
							                       	
                            	</td>
                            	
                            	<td>
                            	<a href="remprog.html?id=${each.id}" >Remove</a>
                            	</td>
                            </tr>
                        </c:forEach>
                          
                          </table>
                          
                         
                         
       </div>
   </div>
 </div>
 </c:if>
 <c:if test="${empty program }">
 <br>
                         <font color="RED"> No Program Available</font>
                          </c:if>
</div> 
 
</body>
</html>