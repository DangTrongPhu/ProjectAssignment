<%@page import="org.apache.jasper.tagplugins.jstl.core.If"%>
<%@page import="com.trongphu.Customer"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>Edit</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<Script type="text/javascript">
function fncEdit(){
	document.getElementById("errorBirthday").value= "none";
	document.getElementById("errorEmail").value= "none";
	var birthday = document.getElementById("birthday").value;
	var email = document.getElementById("email").value;
	var name = document.getElementById("customer_name").value;
	var address=document.getElementById("address").value;
	var regexBirthday = /^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$/;
	var regexEmail  = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	// Neu customer_name bang rong
	if(name=="")
	{
		document.getElementById("nullName").innerHTML= "Please input name.";
		return false;
		
	}
	else{
		document.getElementById("nullName").innerHTML= "";
	}
	
	
	// Neu birthday khac ding dang YYYY/MM/DDD
	if(!birthday.match(regexBirthday)){
		document.getElementById("errorBirthday").innerHTML= "Invalid Birthday.";
		document.getElementById("birthday").focus();
		return false;
	}else{
		document.getElementById("errorBirthday").innerHTML= "";
	}
	
	// Neu email bang rong 
	if(email=="")
	{
		document.getElementById("nullEmail").innerHTML= "Please input email.";
		return false;
	}
	else{
		document.getElementById("nullEmail").innerHTML= "";
		
	}
	
	// Neu khac dinh dang email
	if(!email.match(regexEmail)){
		document.getElementById("errorEmail").innerHTML= "Invalid Email Address.";
		document.getElementById("email").focus();
		return false;
	}else{
		document.getElementById("errorEmail").innerHTML= "";
	}
	
	// Neu address tren 256 ky tu
	if(address.length>256)
	{
		document.getElementById("errorAdress").innerHTML= "Address is greater than 256 characters";
		return false;
	}
	else{
		document.getElementById("errorAdress").innerHTML= "";
		
	}
	
	
}





</Script> 
	<script>
	
	$(document).ready(function(){
		$('#btnClear').click(function(){				
				/*Clear all input type="text" box*/
				$('#form1 input[type="text"]').val('');
				/*Clear textarea using id */
				$('#form1 #address').val('');					
		});
	});
</script>
</head>
<body bgcolor="#E0F8F7">
		
	<s:form  action="/register" onsubmit="return fncEdit();" id="form1">
		<table align="center" width="100%" cellspacing="0" cellpadding="10">
			<tr>
				<td>
					<h1 style="color:red">Training</h1>
					<hr/>
					Login > Search Customer > Edit Customer Info
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" cellspacing="0" cellpadding="3">
						<tr>
							<td align="left">
								Welcome &nbsp; 
								<s:property value="#session.user.username" />
							</td>
							<td align="right">
								<a href="logout">Logout</a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table width="100%" cellspacing="0" cellpadding="3">
						<tr style="height: 20px; background-color:#0040FF;">
							<td colspan="4" style="background-color:#0040FF;color: white;">	
									<%=request.getAttribute("status")%>
							</td>
						</tr>
						
					</table>
				</td>
			</tr>
			<tr style="text-align: center;">
							<td style="color: red;">
							<p id="errorBirthday" class="error">

							</p>
							<p id="errorEmail" class="error">
					
								
							</p>
							<p id="nullEmail" class="error">
					
							</p>
							<p id="nullName" class="error">
					
							</p>
							<p id="errorAdress" class="error">
					
							</p>
							</td>
			</tr>
			<tr>
				<td>
					<table align="center" width="30%" cellspacing="10" cellpadding="3">
						<tr>
							<td>
								<%if(request.getParameter("id")!=null)
								{
									%>
									<s:label name="customer_id" label="Customer Id" value="%{customer.customer_id}"></s:label>
									<s:hidden name="customer_id" value="%{customer.customer_id}"></s:hidden>
									<%
								}
								%>
							 </td>
						</tr>
						
						<tr>
							
							<td width="55%"><s:textfield name="customer_name" id="customer_name" label="Customer Name" value="%{customer.customer_name}"></s:textfield></td>
						</tr>
						<tr>
							<td width="55%">
									<s:select label="Sex" 
									headerKey="" 
									list="#{'0':'Male', '1':'Female'}" 
									name="sex" 
									value="%{customer.sex}" />

								
           							
								
							</td>
						</tr>
						<tr>
							<td width="55%"><s:textfield name="birthday" id="birthday" label="Birthday" value="%{customer.birthday}"></s:textfield></td>	
						</tr>
						<tr>
							<td><s:textfield name="email" label="Email" id="email" value="%{customer.email}" size="30"></s:textfield></td>
						</tr>
						<tr valign="top">
							<td width="50%"><s:textarea name="address" id="address" value="%{customer.address}" style="width: 250px;" rows="3" label="Address"></s:textarea>
								<s:submit value="Save">
							</s:submit> 
							</td>
						</tr>
						<tr>
				
						<td colspan="2">
							
							
						
							</td>
						
							<td><button type="button" id="btnClear"  value="Clear" style="margin-left:-140px;margin-top: -36px;">Clear</button></td>
						</tr>
						
					</table>
				</td>
			</tr>
			<tr style="height: 170px;">
			</tr>
			<tr>
				<td>
					<hr/>
					Copyright (c) 2000-2008 FUJINET, All Rights Reserved.
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>


