<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function colorsCal() 
{ 
	document.getElementById("sname").value="Kiran";
	document.location.href='./processInsert.do?sname='+document.getElementById("sname").value+'&rno='+document.getElementById("rno").value+'&marks='+document.getElementById("marks").value;
}
</script>


</head>
<body>
Student Name <input type='text' name='sname' id='sname'> <br>
Rollnumber   <input type='text' name='rno' id='rno'><br>
Student Marks <input type='text' name='marks' id='marks'><br>

		<br><input type='button' value="MyButton" onClick="colorsCal();">
</body>
</html>