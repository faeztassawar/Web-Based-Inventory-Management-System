<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
<link rel="stylesheet" type="text/css" href="Delete.css">
</head>
<body>
<table>
<% 
    String type = (String) session.getAttribute("type"); 
    if (type != null && type.equals("admin")) { 
%>
<h1>Delete Your Product</h1>
		<form action="Delete" method="post">
			<tr align="right">
				<td> Name: </td>
				<td> <input type="text" id="p_name" name="p_name" required> </td>
			</tr>
        	<tr align="right">
				<td> ID: </td>
				<td> <input type="number" id="id" name="id" required> </td>
			</tr>
			<tr align="right">
				<td></td>
				<td> <input type="submit" value="Delete"> </td>
			</tr>
    	</form>
	</table>
<% 
    } else { 
        response.sendRedirect("SignIn.html");
    } 
%>
</body>
</html>