<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<jsp:useBean id="command" class="com.sun.dto.User" scope="request"></jsp:useBean> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>adduser</title>
</head>
<body>
<h2>Student Information</h2>
<form:form method="POST" action="/SpringMvc/adduser">
   <table>
    <tr>
        <td><form:label path="name">名字：</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="age">年龄：</form:label></td>
        <td><form:input path="age" /></td>
    </tr>
    <tr>
        <td><form:label path="id">编号：</form:label></td>
        <td><form:input path="id" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="提交表单"/>
        </td>
    </tr>
</table>  
</form:form>


</body>
</html>