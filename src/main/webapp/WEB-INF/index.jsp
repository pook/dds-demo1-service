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
<div align="center">
 <form:form action="welcome" method="post" modelAttribute="user">
 	<table>
 		<tbody>
 		<tr> 		
            <td><form:label path="userFname">ชื่อ:</form:label></td>
            <td><form:input path="userFname"/></td>
        </tr>
         <tr>
           <td> <form:label path="userLName">นามสกุล:</form:label></td>
           <td> <form:input path="userLName"/></td>
        </tr>
        <tr>    
             <td> <form:label path="userId">id:</form:label></td>
            <td><form:input path="userId"/></td>
          </tr>
          <tr>   
            <td> <form:label path="age">อายุ:</form:label></td>
            <td><form:input path="age"/></td>
           </tr>
           <tr>
            <td><form:label path="address">ที่อยู่:</form:label></td>
            <td><form:input path="address"/></td>
             </tr>
            </tbody>
            <tfoot>
             <tr>    
            <td><form:button>เพิ่ม/แก้ไข</form:button></td>
            </tr>
            </tfoot>
          </table>
        </form:form>
  </div>
</body>
</html>