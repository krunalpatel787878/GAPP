<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Application</title>

 <script src="../javascript/jquery-1.9.1.min.js"></script>
<script>
function Save() {
    alert("Application is updated!");
}
function validateGpa(a) {
	
	var re = /^[-+]?(\d*[.])?\d+$/;
	if(!re.test(a.value)){
    alert("Enter a number!");
	}
}
function validateToefl(a) {
	
	var re =/^[0-9]+$/;
	if(!re.test(a.value) && a.value!=null){
    alert("TOEFL:Enter a number!");
	}
}
function Submit() {
    alert("Application is submitted!");
}

</script>
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
   <li class="active"><a href="editapplication.html?id=${app.id}">Edit Application <span class="sr-only">(current)</span></a></li>
  
        
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
    <h3 class="page-header">
                           Edit Admission
                        </h3>
	</div>
	</div>
	<div class="col-md-4 col-md-offset-7">
</div>
<form:form class="form-horizontal" role="form" enctype="multipart/form-data">	
	<!--  <div class="col-md-5 col-md-offset-3"> -->
	<div class="col-md-5 col-md-offset-0"> 
    
<div >

<div class="panel panel-default">
 <div class="panel-heading">
Application Information
                        </div>
    <div class="panel-body">
 <div class="form-group">
 	<label class="control-label col-sm-2"> Department Name</label>
		<div class="col-sm-10">
		     <input type="hidden" value="${app.program.department.id}" id="deptid"/>
			<input name="dept" class="form-control"  value="${app.program.department.departmentName}" readonly="readonly"/> 
			<input name="app_id" value="${app.id }" type="hidden"/>
		</div>
</div>


 <div class="form-group">
 	<label class="control-label col-sm-2">Major Name</label>
		<div class="col-sm-10">
			<select name="program" id="program" class="form-control">
			 <c:forEach items="${major}" var="each">
			 <option value="${each.id}" ${each.majorName == app.program.majorName ?'selected' : '' } >${each.majorName }</option>
			 </c:forEach>
			
			</select>
		</div>
</div>

 <div class="form-group">
 	<label class="control-label col-sm-2">Term</label>
		<div class="col-sm-10">
			<select name="term" name="term" id="term" class="form-control">
			 <option value="Fall 2016" ${app.term == 'Fall 2016' ?'selected' : '' }>Fall 2016</option>
			 <option value="Spring 2017" ${app.term == 'Spring 2017' ?'selected' : '' }>Spring 2017</option>
			 <option value="Fall 2017" ${app.term == 'Fall 2017' ?'selected' : '' }>Fall 2017</option>
			
			</select>
		</div>
</div>




	</div>
	

</div>
</div>
</div>

<div class="col-md-4 col-md-offset-7">
</div>





<div class="col-md-5 col-md-offset-0">
   
<div >
<div class="panel panel-default">
 <div class="panel-heading">
 Personal Information
                        </div>
    <div class="panel-body">
<div class="form-group">
 	<label class="control-label col-sm-2">First Name*</label>
 		<div class="col-sm-10">
			<input name="fn" class="form-control" value="${app.student.firstName }" placeholder="First Name" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Last Name*</label>
 		<div class="col-sm-10">
			<input name="ln" class="form-control" value="${app.student.lastName }" placeholder="Last Name" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">CIN</label>
 		<div class="col-sm-10">
			<input name="cin" class="form-control" value="${app.student.CIN }" placeholder="CIN" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Phone Number*</label>
 		<div class="col-sm-10">
			<input name="phone" class="form-control" value="${app.student.phone }" placeholder="Phone Number" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Email*</label>
 		<div class="col-sm-10">
			<input name="email" class="form-control" value="${app.student.email }" placeholder="Email" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Gender*</label>
		<div class="col-sm-10">
			<select  name="gender" id="gender" class="form-control">
			 <option value="Male" ${app.student.gender == 'Male' ?'selected' : '' }>Male</option>
			 <option value="Female" ${app.student.gender == 'Female' ?'selected' : '' }>Female</option>
	
			</select>
		</div>
</div>


<div class="form-group">
 	<label class="control-label col-sm-2">Date of Birth*</label>
 		<div class="col-sm-10">
 		<c:if test="${not empty s}">
			<input name="dob" class="form-control" value="${s }" placeholder="Date of Birth(MM/dd/yyyy)" required="required"/> 
			</c:if>
			<c:if test="${empty s}">
			<input name="dob" class="form-control"  placeholder="Date of Birth(MM/dd/yyyy)" required="required"/> 
			</c:if>
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Citizenship*</label>
 		<div class="col-sm-10">
			<input name="citizen" class="form-control" value="${app.student.citizenship }"  placeholder="Citizenship" required="required"/> 
		</div>
</div>
<div class="form-group">
 	<label class="control-label col-sm-2">International*</label>
		<div class="col-sm-10">
			<select  name="international" id="international" class="form-control">
			 <option value="true" ${app.student.international == 'true' ?'selected' : '' }>Yes</option>
			 <option value="false" ${app.student.international == 'false' ?'selected' : '' }>No</option>
	
			</select>
		</div>
</div>
</div>
</div>

</div>
</div>


<div class="col-md-4 col-md-offset-7">
</div>

<div class="col-lg-16">
<c:if test="${not empty info }">
<div class="col-md-5 col-md-offset-0">
 
<div >
 <div class="panel panel-default">
  <div class="panel-heading">
Education Record
                        </div>
 <div class="panel-body">
         
           <div class="form-group">
                        <table class="table table-striped">
                            <tr>
                                <th>
                                    College Name
                                </th>
                                <th>
                                   Degree 
                                </th>
                                <th>
                                    Duration
                                </th>
                                 <th>
                                    Major
                                </th>
                                
                                <th>
                                    Remove
                                </th>
                            </tr>
                            
                            <c:forEach items="${info }" var="each">
                            <tr>
                            <td> ${each.collegeName}</td>
                            <td> ${each.degreeEarned}</td>
                            <td> ${each.duration}</td>
                            <td> ${each.major}</td>
                            <td> <a href="inforemove.html?id=${each.id}&appid=${app.id}">Remove</a></td>
                            </tr>
                             
                            </c:forEach>
                            
                          </table>
       </div>
 </div>
 </div>
 </div>
 </div>      
 </c:if>     
 </div>   


<div class="col-md-4 col-md-offset-7">
</div>


<div class="col-md-5 col-md-offset-0">
  
<div >
<div class="panel panel-default">
 <div class="panel-heading">
Add More Education Information(Optional)
                        </div>
    <div class="panel-body">
<div class="form-group">
 	<label class="control-label col-sm-2">College Name</label>
 		<div class="col-sm-10">
			<input name="clg" class="form-control"  placeholder="College Name" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Duration</label>
 		<div class="col-sm-10">
			<input name="duration" class="form-control"  placeholder="Duration" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Degree Earned</label>
 		<div class="col-sm-10">
			<input name="degree" class="form-control"  placeholder="Degree Earned" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Major</label>
 		<div class="col-sm-10">
			<input name="major" class="form-control"  placeholder="Major" /> 
		</div>
</div>

<div style="width:500px;text-align:left">
    <h5 class="page-header">
                           Additional Education Information(Optional)
                        </h5>
	</div>

<div class="form-group">
 	<label class="control-label col-sm-2">College Name</label>
 		<div class="col-sm-10">
			<input name="clg1" class="form-control"  placeholder="College Name" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Duration</label>
 		<div class="col-sm-10">
			<input name="duration1" class="form-control"  placeholder="Duration" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Degree Earned</label>
 		<div class="col-sm-10">
			<input name="degree1" class="form-control"  placeholder="Degree Earned" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Major</label>
 		<div class="col-sm-10">
			<input name="major1" class="form-control"  placeholder="Major" /> 
		</div>
</div>



<div style="width:500px;text-align:left">
    <h5 class="page-header">
                           Additional Education Information(Optional)
                        </h5>
	</div>

<div class="form-group">
 	<label class="control-label col-sm-2">College Name</label>
 		<div class="col-sm-10">
			<input name="clg2" class="form-control"  placeholder="College Name" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Duration</label>
 		<div class="col-sm-10">
			<input name="duration2" class="form-control"  placeholder="Duration" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Degree Earned</label>
 		<div class="col-sm-10">
			<input name="degree2" class="form-control"  placeholder="Degree Earned" /> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Major</label>
 		<div class="col-sm-10">
			<input name="major2" class="form-control"  placeholder="Major" /> 
		</div>
</div>


</div>
</div>

</div>

</div>

<div class="col-md-4 col-md-offset-7">
</div>


<div class="col-md-5 col-md-offset-0">
 
<div >
<div class="panel panel-default">
 <div class="panel-heading">
Record Information
                        </div>
                          <div class="panel-body">
<div class="form-group">
 	<label class="control-label col-sm-2">GPA*</label>
 		<div class="col-sm-10">
			<input name="GPA" class="form-control" value="${app.GPA }" onblur="validateGpa(this)" placeholder="GPA"  required="required"/> 
		</div>
</div>

	<div class="form-group">
                               <label class="control-label col-sm-2">Transcript*</label>
                               <div class="col-sm-10">
                                <input type="file" name="file"  title="${app.transcript}" class="form-control" >
                                <label>Uploaded:</label>&nbsp;<a href="download.html?filename=${app.transcript }">View a File</a>&nbsp;<label>(${app.transcript})</label>
                                <input name="file_name" value="${app.transcript }" type="hidden"/>
                          </div>
                            </div>
                            
                            
                            <div class="form-group">
 	<label class="control-label col-sm-2">TOEFL</label>
 		<div class="col-sm-10">
			<input name="TOEFL" class="form-control" value="${app.TOEFL }"  placeholder="TOEFL" /> 
		</div>
</div>


</div>


</div>


<div class="col-md-16 col-md-offset-0">
    
<div >
<div class="panel panel-default">
 <div class="panel-heading">
                           Additional Requirement
                        </div>
    <div class="panel-body" id="add">

</div>
</div>
</div>
</div>

<div class="col-lg-16">
<c:if test="${not empty records }">
<div class="col-md-13 col-md-offset-0">
 
<div >
 <div class="panel panel-default">
  <div class="panel-heading">
Additional Requirement Information
                        </div>
 <div class="panel-body">
         
           <div class="form-group">
                        <table class="table table-striped">
                          
                            
                            <c:forEach items="${records }" var="each">
                            <tr>
                            <th> ${each.info.name}</th>
                            <c:if test="${each.info.type=='File'}">
                            <td> ${each.value}&nbsp; <a href="download.html?filename=${each.value }">View a File</a></td>
                           </c:if>
                           <c:if test="${each.info.type=='Text' || each.info.type=='Number'}">
                            <td> ${each.value}</td>
                           </c:if>
                            <td> <a href="additionalremove.html?id=${each.id}&appid=${app.id}">Remove</a></td>
                            </tr>
                             
                            </c:forEach>
                            
                          </table>
       </div>
 </div>
 </div>
 </div>
 </div>      
 </c:if>     
 </div>   



<div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
		<input type="submit" name="action" value="Submit" onclick="Submit()" class="btn btn-default">  
		<input type="submit" name="action" value="Save" onclick="Save()" class="btn btn-default">  
	</div>
	
	

</div>
</div>
</div>


</form:form>


</body>

<script type="text/javascript">
function getQueryStrings() { 
	  var assoc  = {};
	  var decode = function (s) { return decodeURIComponent(s.replace(/\+/g, " ")); };
	  var queryString = location.search.substring(1); 
	  var keyValues = queryString.split('&'); 

	  for(var i in keyValues) { 
	    var key = keyValues[i].split('=');
	    if (key.length > 1) {
	      assoc[decode(key[0])] = decode(key[1]);
	    }
	  } 

	  return assoc; 
	} 

function getAdd(){
	var id = $('#deptid').val();
	var s= 'String';
	 var container = document.getElementById("add");
	$.ajax({
		type  : "POST",
		url : "/gapp/application/getAdd.html",
		datatype : "json",
		data : "id=" + id ,
		success : function(response){
var list= "";
var r="";
			
			for(var i=0;i<response.length;i++){
				
				if(response[i].required==true){
					r="";
				}
				else{
					r="";
				}
				
				
				if(response[i].type=="number" || response[i].type=="Number")
				{
				list +="<div class='form-group'><label class='control-label col-sm-2'>"+response[i].name+"</label><div class='col-sm-10'><input type='text' name='"+response[i].name+"' placeholder='"+response[i].name+"' class='form-control' "+r+" /> </div></div>";
				}
				else if(response[i].type=="Text"){
					list +="<div class='form-group'><label class='control-label col-sm-2'>"+response[i].name+"</label><div class='col-sm-10'><input type='text' name='"+response[i].name+"' placeholder='"+response[i].name+"' class='form-control'"+r+" /> </div></div>";
					
					
				}
				else
					{
					list +="<div class='form-group'><label class='control-label col-sm-2'>"+response[i].name+"</label><div class='col-sm-10'><input type='file' name='req' class='form-control'"+r+" /> </div></div>";
					
					}
				
				}
			$("#add").html(list);
		},
		error : function(e){
			alert('error:'+e)
		}
		
	});	
}

$(document).ready(function()
		{
	getAdd();
		});


</script>

</html>