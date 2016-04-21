<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insertion completed</title>
	</head>
	<body>
		<c:if test="${(songController.name!=null)||(artistController.name!=null)}">
			<h1>The insertion has been successfully completed</h1>
			<h2>Thanks for using our app</h2>
			<h3>Come back soon</h3>	
			<h4>Bye</h4>
			<h5>:)</h5>
		</c:if>
		<c:if test="${(songController.name!=null)&&(artistController.name!=null)}">
			<h1>The insertion has not been successfully completed</h1>
		</c:if>
		<a href="index.html">Back to index</a>
	</body>
</html>