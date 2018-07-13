<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	add Admin
	
	<!-- <form action="/HelloWorld/viewUser.html" method="post">
		<p> Tên </p> <input name="name" type="text">
		<p> Tuổi </p><input name="age" type="text">
		<input value="Sumit" type="submit"> 
		<p style="color: red">
	<html:errors/>
	</p>
	</form> -->
	<html:form action="/updateAdminPost.html" method="post">
	<html:hidden property="id" name="admin"/>
	<bean:write name="admin" property="warning" filter="false"/>
		<html:messages id="ten_error" property="admin.name.required">
			<p style="color: red">
			<bean:write name="ten_error"/>
		</p>
		</html:messages>
		<html:messages id="ten_duboule" property="admin.pass.duboule">
			<p style="color: red">
			<bean:write name="ten_duboule"/>
		</p>
		</html:messages>
		
		<p><bean:message key="admin.name"/>: <html:text name="admin" property="name" /></p>
	
		<html:messages id="pass_error" property="admin.pass.required">
			<p style="color: red">
			<bean:write name="pass_error"/>
		</p>
		</html:messages>
		<p><bean:message key="admin.pass"/>:<html:text name="admin" property="pass"  /></p>
		
		<html:messages id="sex_error" property="admin.sex.required">
			<p style="color: red">
			<bean:write name="sex_error"/>
		</p>
		</html:messages>
		
		<p><bean:message key="admin.sex"/>:<html:radio name="admin" value="Nam" property="sex">Nam</html:radio>
		<html:radio name="admin" value="Nữ" property="sex">Nữ</html:radio></p>
		
		<html:submit><bean:message key="button.submit"/></html:submit>
	</html:form>
</body>
</html>
