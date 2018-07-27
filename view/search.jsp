<%@page import="com.trongphu.Customer"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<head>
<title>Search Customer</title>
<style type="text/css">
#submit{
	width: 50px;
}
</style>
<Script type="text/javascript">
	
	
	function fncSearch(){
		var birthdayFrom = document.getElementById("birthdayFrom").value;
		var birthdayTo = document.getElementById("birthdayTo").value;;
		var regex = /^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$/;
		if(!birthdayFrom.match(regex))
		{
			alert('Invalid Birthday (From)');
			return false;
		}
		else 
		{
			if(!birthdayTo.match(regex))
			{
					alert('Invalid Birthday (To)');
					return false;
			}
			else 
			{
				if(birthdayFrom>birthdayTo)
				{
					alert('There is an error in the range input of Birthday');
					return false;
				}
				
			}
		}
		return true;
	}
	
</Script> 
<script type="text/javascript">
function checkAll()
{
	$("#chkAll").change(function () {
	    $("input:checkbox").prop('checked', $(this).prop("checked"));
	});
}

</script>

</head>
<body bgcolor="#E0F8F7">

		<table align="center" width="100%" cellspacing="0" cellpadding="10" id="body" >
			<tr>
				<td>
					<h1 style="color:red">Training</h1>
					<hr/>
					Login > Search Customer
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
					<s:form action="/search" onsubmit="return fncSearch();" method="get" >
					<table width="100%" cellspacing="0" cellpadding="3">
						<tr style="height: 20px; background-color:#0040FF;">
							<td colspan="5" style="background-color:#0040FF;">						
							</td>
						</tr>
						<tr style="height: 50px;"></tr>
						<tr>
							<td align="center" width="10%">
								<s:textfield name="customer_name" label="Customer Name" id="customerName"></s:textfield>
							</td>
							<td  align="center" width="10%">
								 <s:select name = "sex" label = "Sex" id="sex"
           							 	list="#{'':'','0':'Male', '1':'Female'}" />
           							 
							</td>
							
							<td  align="center" width="10%">
								<s:textfield name="birthdayFrom" label="Birthday" id="birthdayFrom"></s:textfield>
								<s:textfield name="birthdayTo" id="birthdayTo"></s:textfield>
								
							</td>
							<td>
							<s:submit value="Search"  style="margin-right:1250px;"></s:submit>
							</td>
						</tr>
					</table>
					</s:form>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%">
						<tr>
							
							<td align="left">
							<s:form>
								<%
								if(request.getAttribute("birthdayFrom")!=null){
									
									%>
									<s:hidden name="customer_name" value="%{customer_name}"></s:hidden>
									<s:hidden name="sex" value="%{sex}"></s:hidden>
									<s:hidden name="birthdayFrom" value="%{birthdayFrom}"></s:hidden>
									<s:hidden name="birthdayTo" value="%{birthdayTo}"></s:hidden>
									
								<% }%>
								<s:hidden name="first" value="%{first}"></s:hidden>
								<%
											if(request.getAttribute("page")!=null && request.getAttribute("last")!=null)
											{
											 int pages = (int) request.getAttribute("page");
											if(pages==1)
											{
												%>
														<s:submit value=">>" disabled="true" id="submit"></s:submit>
												<% 
											}
											else
											{
												%>
													<s:submit value=">>" id="submit"></s:submit>
											<% 
											}
											}
											else
											{
												%>
														<s:submit value=">>" id="submit"></s:submit>
												<% 
											}
											
											
										%>
							
							</s:form>
									<form action="/HelloWorldStrust2/search.action">
									<%if(request.getAttribute("page")!=null){
										%>
										<input type="hidden" name="page" value=<%=request.getAttribute("page")%> />
										<%
										}
										%>
									<%
								if(request.getAttribute("birthdayFrom")!=null){
									
									%>
									<% String customer_name = (String)request.getAttribute("customer_name"); %>
									
									<input type="hidden" name="customer_name" value="<%=customer_name%>" />
									<input type="hidden" name="sex" value="<%=request.getAttribute("sex")%>"/>
									<input type="hidden" name="birthdayFrom" value="<%=request.getAttribute("birthdayFrom")%>"/>
									<input type="hidden" name="birthdayTo" value="<%=request.getAttribute("birthdayTo")%>"/>
									
								<% }%>
									<input type="hidden" name="pre" value="pre"/>
										 
										  <%
										  if(request.getAttribute("page")!=null)
											{
											 int pages = (int) request.getAttribute("page");
											 int last =  (int) request.getAttribute("last");
											if(pages==1)
											{
												%>
													<input type="submit" value=">" disabled="disabled" id="submit"> 
													 Previous &nbsp;
												<% 
											}
											else
											{
												%>
												<input type="submit" value=">" id="submit"> 
												 Previous &nbsp;
											<% 
											}
											}
											else
											{
												%>
													<input type="submit" value=">" id="submit"> 
													 Previous &nbsp;
												<% 
											}
											
										  %>
										
										
									</form>
							
							
								
								</td>
									<td align="right">
									<form action="/HelloWorldStrust2/search">
									<%if(request.getAttribute("page")!=null){
										%>
										<input type="hidden" name="page" value=<%=request.getAttribute("page")%> />
										<%
									}
										%>
									<%
								if(request.getAttribute("birthdayFrom")!=null){
									
									%>
									<% String customer_name = (String)request.getAttribute("customer_name");
									String birthdayFrom = (String)request.getAttribute("birthdayFrom");
									String birthdayTo = (String)request.getAttribute("birthdayTo");
									%>
									
									<input type="hidden" name="customer_name" value="<%=customer_name%>"></input>
									<input type="hidden" name="sex" value="<%=request.getAttribute("sex")%>"></input>
									<input type="hidden" name="birthdayFrom" value="<%=birthdayFrom%>"/>
									<input type="hidden" name="birthdayTo" value="<%=birthdayTo%>"/>
									
								<% }%>
									<input type="hidden" name="next" value="next"/>
										Next &nbsp;
										<%
											if(request.getAttribute("page")!=null && request.getAttribute("last")!=null)
											{
											 int pages = (int) request.getAttribute("page");
											 int last =  (int) request.getAttribute("last");
											if(pages==last)
											{
												%>
													<input type="submit" disabled="disabled" value=">" id="submit"> 
												<% 
											}
											else
											{
												%>
												<input type="submit" value=">" id="submit"> 
											<% 
											}
											}
											else
											{
												%>
													<input type="submit" value=">" id="submit"> 
												<% 
											}
											
											
										%>
										
										
									</form>
									<s:form>
										<%
										if(request.getAttribute("birthdayFrom")!=null){
											
											%>
											<s:hidden name="customer_name" value="%{customer_name}"></s:hidden>
											<s:hidden name="sex" value="%{sex}"></s:hidden>
											<s:hidden name="birthdayFrom" value="%{birthdayFrom}"></s:hidden>
											<s:hidden name="birthdayTo" value="%{birthdayTo}"></s:hidden>
											
										<% }%>
											<s:hidden name="last" value="last"/>
										
										<%
											if(request.getAttribute("page")!=null && request.getAttribute("last")!=null)
											{
											 int pages = (int) request.getAttribute("page");
											 int last =  (int) request.getAttribute("last");
												if(pages==last)
												{
													%>
														<s:submit value=">>" disabled="true" id="submit"></s:submit>
													
													<%
												}
												else
												{
													%>
													<s:submit value=">>" id="submit"></s:submit>
												<% 
												}
											}
											else
											{
												%>
													<s:submit value=">>" id="submit"></s:submit>
												<% 
											}
											
											
										%>
									</s:form>
									</td>
							
						
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table style="width:100%" id="tbodySearch">
						<tr style="height: 20px; background-color:#088A08;color:#FFFFFF;">
							<td width="3%"><input type="checkbox" name="chkAllId" id="chkAll" onclick="checkAll()"/></td>
							<td width="12%">Customer ID</td>
							<td width="22%">Customer Name</td>
							<td width="13%">Sex</td>
							<td width="17%">Birthday</td>
							<td width="33%">Address</td>
						</tr>
						<% int index = 0; %>						
						<s:iterator var="customer" value="customerList" status="index">
						<s:set name="sex" value="sex"/>
						
							<% if(index % 2 == 0) { %>
							<tr style="background-color:#FFFFFF;">
							<% } else { %>
							<tr style="background-color:#A9F5F2;">
							<% } %>
								<td width="3%"><input type="checkbox"  name="chkId" value="<s:property value="customer_id" />"/></td>
								<td width="12%">
									
									<a href="add.action?id=<s:property value='customer_id'/>">	<s:property value="customer_id" /> </a>
								</td>
								<td width="22%"><s:property value="customer_name" /></td>
								<td width="13%">
								<s:if test="%{#customer.sex==0}">Male</s:if>
								<s:else>Female</s:else>
								</td>
								<td width="17%">
									<s:property value="birthday" />
								</td>
								<td width="33%"><s:property value="address" /></td>
							</tr>
							<% index++; %>
						</s:iterator>
					
					</table>
				</td>
			</tr>
			<tr style="height:5px;">
			</tr>
			<tr>
				<td style="margin-top: 50px;">
					<a href="add"><button class="button-update">Add new</button></a>
					
				</td>
				<td>
					<button style="margin-left:10px;width:70px;background-color:#888888;"  onclick="fncDelete();">Delete</button>
				</td>
			</tr>
			<tr style="height: 320px;">
			</tr>
			<tr>
				<td>
					<hr/>
					Copyright (c) 2000-2008 FUJINET, All Rights Reserved.
				</td>
			</tr>
		</table>
		<script>
		function fncDelete(){
			var listCustomerId = [];
			$('#tbodySearch :checkbox:checked').each(function(i){
		    	listCustomerId[i] = $(this).val();
		    	i++;
		    });
			var lengthTableIsCheck = ($('#tbodySearch input[type="checkbox"]:checked').length) - 1;
			if(lengthTableIsCheck < 0){
				// Neu chua check ma nhan Delete se thong bao loi
				alert("Please choose a row to delete.");
				return;
				
			}
			$.ajax({
		    	url : "/HelloWorldStrust2/search.action",
		    	type : "POST",
		    	data: {
		    		listCustomerId : JSON.stringify(listCustomerId),
		    	},
		    	success : function(value){
		    		location.reload();

		    	}
		    });
		}
	</script>
	<script src="/HelloWorldStrust2/js/jquery-1.9.1.js"></script>
</body>
</html>


