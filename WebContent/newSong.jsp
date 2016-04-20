<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>NewSong</title>
</head>
<body>
<f:view>
<h1>Select the artist</h1>
<h:form>
	<table border="1">
	<tr>
	<th>Id</th><th>Name</th><th>Country</th>
	</tr>
	<c:forEach var="artist" items="#{songController.artists}">
	<tr>
       <td>${artist.id}</td>
       <td><h:commandLink action="#{songController.selectArtist}" value="#{artist.name}">
			<f:param name="nameArtist" value="#{artist.name}" />
		</h:commandLink></td>
       <td>${artist.country}</td>
   </tr>
	</c:forEach>
</table>
</h:form>
</f:view>
</body>
</html>