<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form:form action="welcome" method="post" modelAttribute="user">
            <form:label path="userFname">ชื่อ:</form:label>
            <form:input path="userFname"/><br/>
             
            <form:label path="userLName">นามสกุล:</form:label>
            <form:input path="userLName"/><br/>
             
           
                 
            <form:button>Register</form:button>
        </form:form>
   
</body>
</html>