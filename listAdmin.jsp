<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<logic:empty name="adminsList">
		<p>Không có người dùng nào</p>
	</logic:empty>
	<bean:write name="admin" property="warning" filter="false"/>
	<logic:notEmpty name="adminsList">
		<table>
			<tr>
				<th>ID</th>
				<th>TEN</th>
				<th>SEX</th>
				<th>PASS</th>
				<th>Role</th>
				<th>Chooose</th>
			</tr>
			<logic:iterate id="user" name="adminsList">
				<tr>
					<td><bean:write name="user" property="id"/>
					</td>
					<td><bean:write name="user" property="name"/>
					</td>
					<td><bean:write name="user" property="sex"/>
					</td>
					<td><bean:write name="user" property="pass"/>
					</td>
					<td><logic:equal value="Nam" name="user" property="sex">
						<bean:message key="user.role.admin"/>
					</logic:equal> 
					<logic:equal value="Nữ" name="user" property="sex">
						<bean:message key="user.role.user"/>
					</logic:equal> 
					</td>
					<td><html:link action="/viewAdmin.html" paramId="adminId" paramName="user" paramProperty="id"><bean:message key="button.view"/></html:link>| <html:link action="/updateAdmin.html" paramId="adminId" paramName="user" paramProperty="id"><bean:message key="button.edit"/></html:link>|  | <html:link action="/deleteAdmin.html" paramId="adminId" paramName="user" paramProperty="id"><bean:message key="button.delete"/></html:link> </td>
				</tr>
			</logic:iterate>
			
		</table>
	</logic:notEmpty>
</body>                       
</html>
