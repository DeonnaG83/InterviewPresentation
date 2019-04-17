<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Page</title>
</head>
<body>
	<h1>Edit Page</h1>
	
	<form action="/loginregistration/editUser?id=${userToUpdate.userId}" method="post">
		<div>
			<label>User Name:</label>
			<input type="text" name="userName" value="${userToUpdate.userName}"/>
		</div>
		<div>
			<label>Password:</label>
			<input type="text" name="password" value="${userToUpdate.password}"/>
		</div>
		<div>
			<label>City:</label>
			<input type="text" name="locationCity" value="${userToUpdate.locationCity}"/>
		</div>
		<div>
			<label>State:</label>
			<input type="text" name="locationState" value="${userToUpdate.locationState}"/>
		</div>
		<div>
			<input type="submit" value="Update" />
		</div>
	</form>
	<a href="/loginregistration/showWelcomePage">Cancel</a>
</body>
</html>