<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>View</title>
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
                           View Department
                        </h4>

 <div class="panel panel-default">
    <div class="panel-body">
           <div class="form-group">
                        <table class="table table-striped">
                            <tr>
                                <th>
                                    Department Name:
                                </th>
                             	<td>
                             		${dept.departmentName}
                             	</td>
                            </tr>
                        
                            <tr>
                            	<th>
                            	Programs:
                            	</th>
                            	<c:if test="${not empty program}">
                            	<td>
                            	<table>
                            	<c:forEach items="${program}" var="each">
                            	<tr><td>
									${each.majorName } &nbsp; &nbsp; &nbsp;
									</td></tr>
								</c:forEach>     
								</table>                     	
                            	</td>
                            	</c:if>
                            	
                            	<c:if test="${empty program}">
                            	<td>-</td>
                            	</c:if>
                            </tr>
                            
                            <tr>
                            	<th>
                            	Additional Requirement:
                            	</th>
                            	
                            <c:if test="${not empty info}">
                            	<td>
                            	<table>
                            	<tr><th>Name</th><th>Type</th><th>Required</th></tr>
                            	<c:forEach items="${info}" var="each1">
                            	<tr><td>
									${each1.name } &nbsp;  &nbsp;  &nbsp;
								</td>
								<td>
									${each1.type } &nbsp;  &nbsp;  &nbsp;
								</td>
								<td>
									${each1.required } &nbsp;  &nbsp;  &nbsp;
								</td>	</tr>
								</c:forEach>
								</table>                     	
                            	</td>
                            	</c:if>
                            	
                            	<c:if test="${empty info}">
                            	<td>-</td>
                            	</c:if>
                            </tr>
                        
                     
                            
                          </table>
       </div>
   </div>
 </div>
</div> 

</body>
</html>