<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
<link rel="stylesheet" type="text/css" href="Add.css">
</head>
<body>
<% 
    String type = (String) session.getAttribute("type"); 
    if (type != null && type.equals("admin")) { 
%>
    <h1>Add Your Product</h1>
    <table>
        <form action="Add" method="post">
            <tr align="right">
                <td> Name: </td>
                <td> <input type="text" id="p_name" name="p_name" required> </td>
            </tr>
            <tr align="right">
                <td> Quantity: </td>
                <td> <input type="text" id="quan" name="quan" required> </td>
            </tr>
            <tr align="right">
                <td> Unit Price: </td>
                <td> <input type="number" id="price" name="price" required> </td>
            </tr>
            <tr align="right">
                <td></td>
                <td> <input type="submit" value="Add"> </td>
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