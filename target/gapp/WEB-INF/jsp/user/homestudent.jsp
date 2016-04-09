<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body style="background-color:#F8F8F8 ">


<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
    
      <a class="navbar-brand" href="#">Gapp</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="homestudent.html">Home <span class="sr-only">(current)</span></a></li>
  
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
     <li><p class="navbar-text navbar-right" style="margin-right:10px;">Signed in as ${user.firstName} ${user.lastName}</p></li>
     <li><p class="navbar-text navbar-right" style="margin-right:10px;">Student</p></li>
     
   <a href="<c:url value='/user/login.html' />"><button type="button" class="btn btn-default navbar-btn">Logout</button></a>
     </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>




   

	

<div class="col-lg-10">
	
<h4 class="page-header">
                        Applications
                        </h4>
                        <a href="<c:url value='/application/apply.html'  />" style="margin-left:20px;">Apply For Admission</a>
                        <br><br>
<c:if test="${not empty app }">
 <div class="panel panel-default">
 <div class="panel-heading">
                           List of Applications
                        </div>
    <div class="panel-body">
           <div class="form-group">
                        <table class="table table-striped">
                            <tr>
                                <th>
                                    Department Name
                                </th>
                                <th>
                                   Major Name 
                                </th>
                                <th>
                                    Term 
                                </th>
                                 <th>
                                    Status 
                                </th>
                                <th>
                                    Submitted date 
                                </th>
                                <th>
                                    View
                                </th>
                                 <th>
                                    Edit
                                </th>
                            </tr>
                            
                            <c:forEach items="${app }" var="each">
                             <tr>
                                <td>
                                    ${each.program.department.departmentName }
                                </td>
                               
                                 <td>
                                ${each.program.majorName}
                                
                                </td>
                                 <td>
                                ${each.term}
                                </td>
                           
                                
                                
                                	<c:if test="${each.submited==false}">
                                	<td> Not Submitted</td>
                                	</c:if>
                                	<c:if test="${each.submited==true}">
                                	<td>${each.status.status }</td>
                               		</c:if>
                              <td>
                               <fmt:formatDate value="${each.createdOn}" pattern="M/d/yyyy"  /> 
                                
                                </td>
                                <td>
                                	<a href="<c:url value='/application/viewapplication.html?id=${each.id}' />">View</a>
                                </td>
                                
                                <c:if test="${each.submited==false}">
                                <td>
                               	<a href="<c:url value='/application/editapplication.html?id=${each.id}' />">Edit</a>
                                </td>
                                </c:if>
                                
                                 <c:if test="${each.submited==true}">
                                <td>
                               	
                                </td>
                                </c:if>
                                
                            </tr>
                            
                            
                            </c:forEach>
                            
                          </table>
       </div>
       
      
   </div>
    
 </div>
</c:if>
 <c:if test="${empty app }">
 <br>
                         <font color="RED"> No Application Available</font>
                          </c:if>
</div>   

</body>
</html>