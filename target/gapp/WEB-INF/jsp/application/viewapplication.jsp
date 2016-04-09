<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Application</title>
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
        <li ><a href="<c:url value='/user/homestudent.html' />">Home </a></li>
   <li class="active"><a href="viewapplication.html?id=${app.id}">View Application <span class="sr-only">(current)</span></a></li>
  
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
     <li><p class="navbar-text navbar-right" style="margin-right:10px;">Signed in as ${user.firstName} ${user.lastName}</p></li>
     <li><p class="navbar-text navbar-right" style="margin-right:10px;">Student</p></li>
     
   <a href="<c:url value='/user/login.html' />"><button type="button" class="btn btn-default navbar-btn">Logout</button></a>
     </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<div class="col-md-5 col-md-offset-0"> 
    <div style="width:500px;text-align:left">
    <h4 class="page-header">
                           View Application
                        </h4>
	</div>
	</div>
	<div class="col-md-4 col-md-offset-7">
</div>
	<div class="col-lg-6 ">


                       
<c:if test="${not empty app }">
 <div class="panel panel-default">
 <div class="panel-heading">
                            Personal Details
                        </div>
    <div class="panel-body">
           <div class="form-group">
                        <table class="table table-striped">
                         
                            
                          <%--   <c:forEach items="${app }" var="each"> --%>
                           
                            
                            <tr>
                                <th>
                                    Student Name:
                                </th>
                               <td>
                                ${app.student.firstName }  ${app.student.lastName }
                               </td>
                            </tr>
                            
                              <tr>
                                <th>
                                    CIN:
                                </th>
                               <td>
                                ${app.student.CIN }
                               </td>
                            </tr>
                            
                            <tr>
                                <th>
                                    Phone:
                                </th>
                               <td>
                                ${app.student.phone }
                               </td>
                            </tr>
                            
                            <tr>
                                <th>
                                    Gender:
                                </th>
                               <td>
                                ${app.student.gender }
                               </td>
                            </tr>
                            
                            <tr>
                                <th>
                                    Citizenship:
                                </th>
                               <td>
                                ${app.student.citizenship }
                               </td>
                            </tr>
                             <tr>
                                <th>
                                    International:
                                </th>
                               <td>
                                ${app.student.international }
                               </td>
                            </tr>
                            
                            <tr>
                                <th>
                                    Date Of Birth:
                                </th>
                               <td> <fmt:formatDate value="${app.student.DOB }" pattern="M/d/yyyy"  /> 
                                
                              
                               </td>
                            </tr>
                           <%--  </c:forEach> --%>
                            </table>
                            </div>
                            </div>
                            </div>
                            </c:if>
                            </div>
                            
                            
                            <div class="col-lg-6">
					
					<c:if test="${not empty app }">
					 <div class="panel panel-default">
					  <div class="panel-heading">
                            Application Details
                        </div>
					    <div class="panel-body">
					           <div class="form-group">
                            <table class="table table-striped">
                         
                            
                           <%--  <c:forEach items="${app }" var="each"> --%>
                            
                            
                            
                               <tr>
                                <th>
                                    Department Name:
                                </th>
                               <td>
                                ${app.program.department.departmentName }
                               </td>
                            </tr>
                            
                               <tr>
                                <th>
                                    Program Name:
                                </th>
                               <td>
                                ${app.program.majorName}
                               </td>
                            </tr>
                            
                               <tr>
                                <th>
                                   Term:
                                </th>
                               <td>
                                ${app.term}
                               </td>
                            </tr>
                            
                             <tr>
                                <th>
                                   Status:
                                </th>
                               <c:if test="${app.submited==false}">
                                	<td> Not Submitted</td>
                                	</c:if>
                                	<c:if test="${app.submited==true}">
                                	<td>${app.status.status }</td>
                               		</c:if>
                            </tr>
                            
                             <tr>
                                <th>
                                   Submitted Date:
                                </th>
                               <td>
                                 <fmt:formatDate value="${app.createdOn}" pattern="M/d/yyyy"  /> 
                                
                               </td>
                            </tr>
                            
                            <tr>
                                <th>
                                   GPA:
                                </th>
                               <td>
                                 ${app.GPA } 
                                
                               </td>
                            </tr>
                            
                             <tr>
                                <th>
                                   Transcript:
                                </th>
                               <td>
                               <a href="download.html?filename=${app.transcript }">View a File</a>  (${app.transcript }) 
                                
                               </td>
                            </tr>
                            
                              <tr>
                                <th>
                                   TOEFL:
                                </th>
                               <td>
                                 ${app.TOEFL } 
                                
                               </td>
                            </tr>
                            
                            
                            <%-- </c:forEach> --%>
                            
                          </table>
       </div>
       
      
   </div>
    
 </div>
</c:if>
 <c:if test="${empty app }">
 <br>
                         <font color="RED"> No Data Available</font>
                          </c:if>
</div>   



<div class="col-lg-6">

<c:if test="${not empty app }">
 <div class="panel panel-default">
 <div class="panel-heading">
                            Details of Education
                        </div>
    <div class="panel-body">
    
           <div class="form-group">
                       
                         
                           <table class="table table-striped">  
                           <tr>
                           <th>
                                    College Name
                                </th>
                           <th>
                                    Degree Earned
                                </th>
                           <th>
                                    Major
                                </th>
                                <th>
                                    Duration
                                </th>
                           </tr>
                            <c:forEach items="${info }" var="each">
                            
                            	
                               <tr>
                                                               <td>
                                ${each.collegeName}
                               </td>
                            
                                
                               <td>
                                ${each.degreeEarned}
                               </td>
                            
                                
                               <td>
                                ${each.major}
                               </td>
                           
                                
                               <td>
                                ${each.duration}
                               </td>
                            </tr>
                            
                           
                            </c:forEach>
                         </table>   
                          
       </div>
       
         </c:if>
 <c:if test="${empty info }">
 <br>
                         <font color="RED"> No Data Available</font>
                          </c:if>
   </div>

    
 </div>

</div>  


<div class="col-lg-6">

<c:if test="${not empty additional }">
 <div class="panel panel-default">
 <div class="panel-heading">
                            Details of Additional Requirement
                        </div>
    <div class="panel-body">
     
           <div class="form-group">
                        <table class="table table-striped">
                         
                            <tr>
                                <th>
                                     Name
                                </th>
                                <th>
                                    Score
                                </th>
                                </tr>
                            <c:forEach items="${additional }" var="each">
                            	
                               <tr>
                               <td>
                                ${each.info.name}
                               </td>
                            
                                
                                <c:if test="${each.info.type=='File'}">
                               <td>
                                ${each.value} &nbsp; 
                                <a href="download.html?filename=${each.value }">View a File</a> 
                               </td>
                               </c:if>
                               
                                <c:if test="${each.info.type=='Text' || each.info.type=='Number'}">
                               <td>
                                ${each.value} 
                               </td>
                               </c:if>
                               
                            </tr>
                            
                        
                            
                            
                            </c:forEach>
                            
                          </table>
       </div>
       </c:if>
 <c:if test="${empty additional }">
 <br>
                         <font color="RED"> No Data Available</font>
                          </c:if>
      
   </div>
    
 </div>

</div>  


</body>
</html>