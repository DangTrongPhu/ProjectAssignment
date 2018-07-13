<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết Admin</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h2>Chi tiết Admin</h2>
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>SEX</th>
        <th>PASS</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td><bean:write name="a" property="id" scope="request"/></td>
        <td><bean:write name="a" property="name" scope="request"/></td>
        <td><bean:write name="a" property="sex" scope="request"/></td>
        <td><bean:write name="a" property="pass" scope="request"/></td>
      </tr>
    </tbody>
  </table>
</div>
</body>
</html>
