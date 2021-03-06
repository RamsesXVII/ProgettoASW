<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Songs</title>
</head>
<body>
<f:view>
<h1>Songs</h1>
<h:form>
	<table border="1">
	<tr>
	<th>Id</th><th>Name</th><th>Year</th><th>Artist</th>
	</tr>
	<c:forEach var="song" items="#{songController.songs}">
	<tr>
       <td>${song.id}</td>
       <td>${song.name}</td>
       <td>${song.year}</td>
       <td>${song.artist.name}</td>
   </tr>
	</c:forEach>
</table>
</h:form>
</f:view>
</body>
</html>