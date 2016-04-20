<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ProgettoASW</title>
</head>
<body>
	<f:view>
		<h1>Architectures for Software Systems</h1>
		<h2>A fantastic music app!</h2>
	 	<ul>
		<h:form>
			<li><a href='<c:url value="/faces/newArtist.jsp" />'>Insert a new artist into music library</a></li>
			<li><h:commandLink action="#{songController.listArtists}" value="Insert a new song" /></li>
			<li><h:commandLink action="#{artistController.listArtists}" value="List all artists" /></li>
			<li><h:commandLink action="#{songController.listSongs}" value="List all songs" /></li>
		</h:form>
		</ul> 
	</f:view> 
</body>
</html>

