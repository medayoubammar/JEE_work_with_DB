<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  

    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>View</title>
<style type="text/css">
.added{
margin-left : 100px;
}
</style>
</head>
<body class="container bg-dark
">
<br>
<form action="Controler">
<label class="text-info">Keyword :</label>
<input type="text" name="key"/> <label> </label> <input type="submit" class="btn btn-info" value="Search" name="click">
<br>
<hr><br>
</form>
<table border="1" class="table table-info">
<tr>
<th>ID </th>
<th>Designation</th>
<th>Prix </th>
<th>Quant</th>
<th></th>
</tr>
<c:forEach var="p" items="${requestScope.PRODUCTS}">

<tr>
<td>${p.id}</td>
<td> ${p.designation}</td>
<td>${p.prix} </td>
<td>${p.quant}</td>
<td class="btn btn-danger btn-sm text-success"><a href="Controler?action=Remove&id=${p.id}">Delete</a></td>
</tr>
</c:forEach>

</table>
<br>
<hr>

<form action="Controler" method="post">

<label class="text-info">Designation :</label> <br>
<input type="text" name="designation"/>  <br>
<label class="text-info">prix :</label>  <br> 
<input type="number" name="prix"> 
<input type="submit" class="btn btn-primary btn-lg added" value="Add Product" name="add">
<label class="text-info">quantité :</label> <br>
<input type="number" name="quant"/> 
 <br>


<br>

</form>


</body>
</html>