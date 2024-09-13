<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet" type="text/css" href="Update.css">
</head>
<body>
<table>
<% 
    String type = (String) session.getAttribute("type"); 
    if (type != null && type.equals("admin")) { 
%>
<h1>Update Your Product</h1>
		<form action="Update" method="post">
			<tr align="right">
				<td> ID: </td>
				<td> <input type="number" id="id" name="id" required> </td>
			</tr>
        	<tr align="right">
				<td> New Name: </td>
				<td> <input type="text" id="p_name" name="p_name" required> </td>
			</tr>
        	<tr align="right">
				<td> New Quantity: </td>
				<td> <input type="number" id="quan" name="quan" required> </td>
			</tr>
			<tr align="right">
				<td> New Unit Price: </td>
				<td> <input type="number" id="price" name="price" required> </td>
			</tr>
			<tr align="right">
				<td></td>
				<td> <input type="submit" value="Update"> </td>
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