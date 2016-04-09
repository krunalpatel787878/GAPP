<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
       
         
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function Save() {
    alert("Application is Saved!");
}
function Submit() {
    alert("Application is submitted!");
}
function validateGpa(a) {
	
	var re = /^[-+]?(\d*[.])?\d+$/;
	if(!re.test(a.value)){
    alert("GPA:Enter a number!");
	}
}
function validateToefl(a) {
	
	var re =/^[0-9]+$/;
	if(!re.test(a.value)){
    alert("TOEFL:Enter a number!");
	}
}
</script>




<title>Apply</title>
<!-- <script type="text/javascript" src="../javascript/jquery-2.1.1.min.js"></script> -->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">

function f(){
	get();
	getAdd();
}

function get(){
	var id = $('#dept').val();
	$.ajax({
		type  : "POST",
		url : "/gapp/application/getprogram.html",
		datatype : "json",
		data : "id=" + id ,
		success : function(response){
			var list= "";
			
			for(var i=0;i<response.length;i++){
				
				list +="<option value='"+response[i].id+"'>"+response[i].majorName+"</option>";
			}
			$("#program").html(list);
		},
		error : function(e){
			alert('error:'+e)
		}
		
	});	
}

$(document).ready(function()
		{
	get();
		});

</script>


<script type="text/javascript">
function getAdd(){
	var id = $('#dept').val();
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
					r="required='required'";
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
   <li class="active"><a href="apply.html">Apply for Admission <span class="sr-only">(current)</span></a></li>
  
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
     <li><p class="navbar-text navbar-right" style="margin-right:10px;">Signed in as ${user.firstName} ${user.lastName}</p></li>
     <li><p class="navbar-text navbar-right" style="margin-right:10px;">Student</p></li>
     
    <a href="<c:url value='/user/login.html' />"><button type="button" class="btn btn-default navbar-btn">Logout</button></a>
     </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>




		
		<!-- <h3 style="width:500px;text-align: left;margin-left:20px;">Apply For Admission</h3>
 -->
 <div class="col-md-5 col-md-offset-0"> 
    <div style="width:500px;text-align:left">
    <h3 class="page-header">
                           Apply For Admission
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
		
			<select name="dept" id="dept" class="form-control" onchange="return f();">
			
			<c:forEach items="${dept}" var="each">
			<option value="${each.id}"> ${each.departmentName} </option>
			</c:forEach>
			</select>
		</div>
</div>


 <div class="form-group">
 	<label class="control-label col-sm-2">Major Name</label>
		<div class="col-sm-10">
			<select name="program" id="program" class="form-control">
			 
			
			</select>
		</div>
</div>

 <div class="form-group">
 	<label class="control-label col-sm-2">Term</label>
		<div class="col-sm-10">
			<select name="term" name="term" id="term" class="form-control">
			 <option value="Fall 2016">Fall 2016</option>
			 <option value="Spring 2017">Spring 2017</option>
			 <option value="Fall 2017">Fall 2017</option>
			
			</select>
		</div>
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
			<input name="fn" class="form-control"  placeholder="First Name" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Last Name*</label>
 		<div class="col-sm-10">
			<input name="ln" class="form-control"  placeholder="Last Name" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">CIN</label>
 		<div class="col-sm-10">
			<input name="cin" class="form-control"  placeholder="CIN"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Phone Number*</label>
 		<div class="col-sm-10">
			<input name="phone" class="form-control"  placeholder="Phone Number" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Email*</label>
 		<div class="col-sm-10">
			<input name="email" class="form-control"  placeholder="Email" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Gender*</label>
		<div class="col-sm-10">
			<select  name="gender" id="gender" class="form-control">
			 <option value="Male">Male</option>
			 <option value="Female">Female</option>
	
			</select>
		</div>
</div>


<div class="form-group">
 	<label class="control-label col-sm-2">Date of Birth*</label>
 		<div class="col-sm-10">
			<input type="text"  name="dob" class="form-control"  placeholder="Date of Birth(MM/dd/yyyy)" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Citizenship*</label>
 		<div class="col-sm-10">
			<input name="citizen" class="form-control"  placeholder="Citizenship" required="required"/> 
		</div>
</div>
<div class="form-group">
 	<label class="control-label col-sm-2">International*</label>
		<div class="col-sm-10">
			<select  name="international" id="international" class="form-control">
			 <option value="true">Yes</option>
			 <option value="false">No</option>
	
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
Education Information
                        </div>
    <div class="panel-body">
<div class="form-group">
 	<label class="control-label col-sm-2">College Name*</label>
 		<div class="col-sm-10">
			<input name="clg" class="form-control"  placeholder="College Name" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Duration*</label>
 		<div class="col-sm-10">
			<input name="duration" class="form-control"  placeholder="Duration" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Degree Earned*</label>
 		<div class="col-sm-10">
			<input name="degree" class="form-control"  placeholder="Degree Earned" required="required"/> 
		</div>
</div>

<div class="form-group">
 	<label class="control-label col-sm-2">Major*</label>
 		<div class="col-sm-10">
			<input name="major" class="form-control"  placeholder="Major" required="required"/> 
		</div>
</div>

<div style="width:500px;text-align:left">
    <h5 class="page-header">
                           Additional Education Information-1(Optional)
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
                           Additional Education Information-2(Optional)
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
			<input name="GPA" class="form-control" onblur="validateGpa(this)"  placeholder="GPA" required="required"/> 
		</div>
</div>

	<div class="form-group">
                               <label class="control-label col-sm-2">Transcript*</label>
                               <div class="col-sm-10">
                                <input type="file" name="file"  class="form-control" required="required">
                          </div>
                            </div>
                            
                            
                            <div class="form-group">
 	<label class="control-label col-sm-2">TOEFL</label>
 		<div class="col-sm-10">
			<input name="TOEFL" class="form-control"   placeholder="TOEFL" /> 
		</div>
</div>


	
</div>
</div>	




<div class="col-md-16 col-md-offset-0">
    
<div >
<div class="panel panel-default">
 <div class="panel-heading">
                           Additional Information
                        </div>
    <div class="panel-body" id="add">

</div>
</div>
</div>
</div>



</div>


<div class="form-group"> 
    <div class="col-sm-offset-2 col-sm-10">
		<input type="submit" name="action" value="Submit" onclick="Submit()" class="btn btn-default">  
		<input type="submit" name="action" value="Save" onclick="Save()" class="btn btn-default">  
	</div>
</div>


<div class="col-md-4 col-md-offset-7">
</div>



</div>


</form:form>


</body>
</html>