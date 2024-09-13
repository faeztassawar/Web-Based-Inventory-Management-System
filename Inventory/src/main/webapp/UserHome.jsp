<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<link rel="stylesheet" type="text/css" href="UserHome.css">
</head>
<body>
<% 
    String type = (String) session.getAttribute("type"); 
    if (type != null && type.equals("user")) { 
%>
<h1>Hello User</h1>
	<a href="Search.html"> <button name="search" id="search"> Search Product </button> </a>
	<form action="Logout" method="post">
		<button type="submit">Logout</button>
	</form>
<% 
    } else { 
        response.sendRedirect("SignIn.html");
    } 
%>
</body>
</html>