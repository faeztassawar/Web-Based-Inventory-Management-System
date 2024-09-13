<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<link rel="stylesheet" type="text/css" href="AdminHome.css">
</head>
<body>
<% 
    String type = (String) session.getAttribute("type"); 
    if (type != null && type.equals("admin")) { 
%>
<h1>Hello Admin</h1>
	<a href="Add.jsp"> <button> Add Product </button> </a>
	<a href="Delete.jsp"> <button> Delete Product </button> </a>
	<a href="Search.html"> <button> Search Product </button> </a>
	<a href="Update.jsp"> <button> Update Product </button> </a>
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