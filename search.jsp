<%@page import="com.example.javawebtutor.form.Mstcustomer"%>
<%@page import="com.example.javawebtutor.form.Mstuser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Search Customer</title>
<style>
	*{
	margin: 0 auto;;
	padding: 0px;
	}
</style>
<script>
	function checkAll()
	{
		$("#chkAll").change(function () {
		    $("input:checkbox").prop('checked', $(this).prop("checked"));
		});
	}
	function checkSeach()
	{
		var birthdayFrom = document.getElementById("birthdayFrom").value;
		var birthdayTo = document.getElementById("birthdayTo").value;;
		var regex = /^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$/;
		if(!birthdayFrom.match(regex))
		{
			alert("Invalid Birthday From");
			return false;
		}
		else 
		{
			if(!birthdayTo.match(regex))
			{
					alert("Invalid Birthday To");
					return false;
			}
			else 
			{
				if(birthdayFrom>birthdayTo)
				{
					alert("There is an error in the range input of Birthday");
					return false;
				}
				
			}
		}
		
	}
</script>

</head>
<body style="background-color: #99CCFF;">
<%
	Mstuser mstuser = new Mstuser();
	if(session.getAttribute("mstuser")!=null)
	{
		mstuser =(Mstuser) session.getAttribute("mstuser");
	}
%>
<jsp:include page="header.jsp"></jsp:include>
<div style="margin-left: 50px;margin-right: 50px;">
<div>Login > Search Customer</div>
<div style="height: 100px;">
<div style="float: left;margin-top: 50px;">Welcome :<%if(mstuser!=null){
	%>
	<span style="color: red;"><%=mstuser.getUSERNAME()%></span>

<% }%>
</div>

<div style="float: right;margin-top: 50px;"><html:link page="/logout.html">Logout</html:link> </div>


<br/>
</div>
<div style="background-color:blue;height: 15px;"></div>
<div  style="background-color:#FFFF99;height: 100px; width: 1200px;margin-top: 50px;padding-left: 10px;padding-top: 50px;">
	<html:form onsubmit="return checkSeach();" styleId="contact1" action="/search.html">
		<html:hidden property="page" name="customer" value="1"/>
		Customer Name:<html:text property="CUSTOMER_NAME" name="customer"  maxlength="50" style=" margin-right:50px;width:100px;"></html:text>
		Sex:<html:select property="SEX" name="customer" style="width:70px;margin-right:50px;">
				<html:option value=""></html:option>
				<html:option value="0">Male</html:option>
				<html:option value="1">Female</html:option>
			</html:select>
		Birthday:<html:text property="birthdayFrom" name="customer" maxlength="10" style="width:100px;" styleId="birthdayFrom">
				</html:text>~<html:text property="birthdayTo" name="customer" maxlength="10" styleId="birthdayTo" style="width:100px;"></html:text>
				<html:hidden name="customer" property="mode" value="1" styleId="mode"/>
				<html:submit style="margin-left:50px;width:70px;">Search</html:submit>
	</html:form>
	
</div>
<%Mstcustomer mstcustomer =(Mstcustomer)request.getAttribute("customer"); %>
<div style="width: 1200px;margin-top: 10px;height: 50px;">
	<div style="float: left;height: 50px;margin-top: 18px;">
	<html:form action="/search.html">
		<html:hidden property="page" name="customer" value="1"/>
		<%if(mstcustomer.getBirthdayFrom()!=null && mstcustomer.getBirthdayFrom().length()>0){
		%>
			<html:hidden property="birthdayFrom" name="customer"/>
			<html:hidden property="birthdayTo" name="customer"/>
		<% }%>
			<%if(mstcustomer.getCUSTOMER_NAME()!=null && mstcustomer.getCUSTOMER_NAME().length()>0){
		%>
			<html:hidden property="CUSTOMER_NAME" name="customer"/>
		<% }%>
				<%if(mstcustomer.getSEX()!=null && mstcustomer.getSEX().length()>0){
		%>
			<html:hidden property="SEX" name="customer"/>
		<% }%>
		<logic:equal property="page" name="customer" value="1">
		<html:submit property="" style="width:50px;background-color:#BBBBBB;" disabled="true"><<</html:submit>
		</logic:equal>
		<logic:notEqual property="page" name="customer" value="1">
			<html:submit property="" style="width:50px;background-color:#BBBBBB;" ><<</html:submit>
		</logic:notEqual>
	</html:form>
	</div>
	<div style="float: left;height: 50px;margin-top: 18px;">
	<span style="margin-left: 70px;">Previous</span>
	<html:form action="/search.html" style="margin-top:-18px;">
		<html:hidden property="page" name="customer"/>
		
		<html:hidden property="pre" name="customer"/>
		<%if(mstcustomer.getBirthdayFrom()!=null && mstcustomer.getBirthdayFrom().length()>0){
		%>
			<html:hidden property="birthdayFrom" name="customer"/>
			<html:hidden property="birthdayTo" name="customer"/>
		<% }%>
			<%if(mstcustomer.getCUSTOMER_NAME()!=null && mstcustomer.getCUSTOMER_NAME().length()>0){
		%>
			<html:hidden property="CUSTOMER_NAME" name="customer"/>
		<% }%>
				<%if(mstcustomer.getSEX()!=null && mstcustomer.getSEX().length()>0){
		%>
			<html:hidden property="SEX" name="customer"/>
		<% }%>
		<logic:equal property="page" name="customer" value="1">
		<html:submit property="" style="width:50px;background-color:#BBBBBB;" disabled="true"><</html:submit>
		</logic:equal>
		<logic:notEqual property="page" name="customer" value="1">
		<html:submit property="" style="width:50px;background-color:#BBBBBB;"><</html:submit>
		</logic:notEqual>
		
	</html:form>
	
	 </div>

	 <div style="float: right;height: 50px;margin-top: 18px;margin-right: 5px;">
	<html:form action="/search.html">
		<html:hidden property="last" name="customer" />
		<%if(mstcustomer.getBirthdayFrom()!=null && mstcustomer.getBirthdayFrom().length()>0){
		%>
			<html:hidden property="birthdayFrom" name="customer"/>
			<html:hidden property="birthdayTo" name="customer"/>
		<% }%>
			<%if(mstcustomer.getCUSTOMER_NAME()!=null && mstcustomer.getCUSTOMER_NAME().length()>0){
		%>
			<html:hidden property="CUSTOMER_NAME" name="customer"/>
		<% }%>
				<%if(mstcustomer.getSEX()!=null && mstcustomer.getSEX().length()>0){
		%>
			<html:hidden property="SEX" name="customer"/>
		<% }%>
		<logic:equal property="page" name="customer" value="${customer.last }">
		<html:submit property="" style="width:50px;background-color:#BBBBBB;" disabled="true">>></html:submit>
		</logic:equal>
		<logic:notEqual property="page" name="customer" value="${customer.last }">
		<html:submit property="" style="width:50px;background-color:#BBBBBB;">>></html:submit>
		</logic:notEqual>
	</html:form>
	
	 </div>
	 	 <div style="float: right;height: 50px;">
	 	
	  	<span style="padding-right: 20px;">Next</span>
		<html:form action="/search.html">
			<html:hidden property="page" name="customer"/>
			<html:hidden property="next" name="customer"/>
			<%if(mstcustomer.getBirthdayFrom()!=null && mstcustomer.getBirthdayFrom().length()>0){
			%>
				<html:hidden property="birthdayFrom" name="customer"/>
				<html:hidden property="birthdayTo" name="customer"/>
			<% }%>
				<%if(mstcustomer.getCUSTOMER_NAME()!=null && mstcustomer.getCUSTOMER_NAME().length()>0){
			%>
				<html:hidden property="CUSTOMER_NAME" name="customer"/>
			<% }%>
					<%if(mstcustomer.getSEX()!=null && mstcustomer.getSEX().length()>0){
			%>
				<html:hidden property="SEX" name="customer"/>
			<% }%>
	
			<logic:equal property="page" name="customer" value="${customer.last }">
			<html:submit property="" style="width:50px;background-color:#BBBBBB;" disabled="true">></html:submit>
			</logic:equal>
			<logic:notEqual property="page" name="customer" value="${customer.last }">
			<html:submit property="" style="width:50px;background-color:#BBBBBB;">></html:submit>
			</logic:notEqual>
		
		</html:form>
	</div>
</div>
<div style="width: 1200px;" id="divSearch">



<table border="1" style="width: 1200px;margin-top: 10px;text-align: center;">
	<tr style="background-color: green;">
		<td><html:checkbox property="chkAllId" name="customer" styleId="chkAll" onclick="checkAll()"></html:checkbox></td>
		<td>Customer ID</td>
		<td>Customer Name</td>
		<td>Sex</td>
		<td>Birthday</td>
		<td>Address</td>
	</tr>
	<logic:empty name="customerList">
		<tr>
	<td colspan="6">
	
			<p>Không có người dùng nào</p>
	
	</td>
	</tr>
	</logic:empty>
	<logic:notEmpty name="customerList">
	<tbody id="tbodySearch">
	<%int i=1; %>
	<logic:iterate id="customer" name="customerList">

	<%if(i%2!=0){ %>
	<tr style="background-color: white;">
	
		<td><html:checkbox property="chkId" name="customer" value="${customer.CUSTOMER_ID}"></html:checkbox></td>
		<td><html:link action="/add.html" paramId="id" paramName="customer" paramProperty="CUSTOMER_ID"><bean:write name="customer" property="CUSTOMER_ID"/></html:link></td>
		<td><bean:write name="customer" property="CUSTOMER_NAME"/> </td>
		<td><logic:equal name="customer" property="SEX" value="0">
			Male
			</logic:equal>
			<logic:equal name="customer" property="SEX" value="1">
			Female
			</logic:equal></td>
		<td><bean:write name="customer" property="BIRTHDAY"/></td>
		<td><bean:write name="customer" property="ADDRESS"/></td>
	</tr>
	<%}
	else
	{
		%>
			<tr style="background-color: #99FFFF;">
	
		<td><html:checkbox property="chkId" name="customer" value="${customer.CUSTOMER_ID}"></html:checkbox></td>
				<td><html:link action="/add.html" paramId="id" paramName="customer" paramProperty="CUSTOMER_ID"><bean:write name="customer" property="CUSTOMER_ID"/></html:link></td>
		<td><bean:write name="customer" property="CUSTOMER_NAME"/> </td>
		<td><logic:equal name="customer" property="SEX" value="0">
			Male
			</logic:equal>
			<logic:equal name="customer" property="SEX" value="1">
			Female
			</logic:equal></td>
		<td><bean:write name="customer" property="BIRTHDAY"/></td>
		<td><bean:write name="customer" property="ADDRESS"/></td>
	</tr>
		<%
	}
	%>
	<%i++; %>
	</logic:iterate>
	</tbody>
	</logic:notEmpty>
</table>


<div style="margin-top: 20px;">
<button style="margin-left:10px;width:70px;background-color:#888888;"><a href="/HelloWorld/add.html?id=add">Add new </a></button>
<logic:empty name="customerList"><html:button style="margin-left:10px;width:70px;background-color:#888888;" property=""  disabled="true">Delete</html:button></logic:empty>
	<logic:notEmpty name="customerList"><html:button style="margin-left:10px;width:70px;background-color:#888888;" property="" onclick="fncDelete();">Delete</html:button></logic:notEmpty>
</div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</div>
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
		alert("<bean:message key='ERRORS.DELETE.BLANK'/>");
		return;
		
	}
	var value=3;
	$.ajax({
    	url : "/HelloWorld/search.html",
    	type : "POST",
    	data: {
    		listCustomerId : JSON.stringify(listCustomerId),
    		value:value
    	},
    	success : function(value){
    		alert('Delete customer success');
    	}
    });
}
</script>
<script src="js/jquery-1.9.1.js"></script>
</body>
</html>
