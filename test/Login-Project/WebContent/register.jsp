<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body bgcolor=#AABB>
	<pre>
<form action="saveUser.do" method="post">
Name : <input type="text" name="name" placeholder="Name"/>
Email-Id : <input type="text" name="eMail" placeholder="Email-Id" />
Mobile No. : <input type="text" name="mobileNumber" placeholder="Mobile No." />
Role : <input type="text" name="role" placeholder="Role" />
Password : <input type="password" name="password" placeholder="Password" /> 
<br></br>
<input type="submit" value="Login">
</form>
</pre>
</body>
</html>