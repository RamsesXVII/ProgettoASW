<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add a new Song</title>
</head>
<body>
	<f:view>
		<h:form>
		<h1>Add a new song made by ${songController.nameArtist}</h1>
  		    <div>
				Name:
				<h:inputText value="#{songController.name}" required="true"
					requiredMessage="name is mandatory" id="name" />
				<h:message for="name" />
			</div>
			<div>
				Year:
				<h:inputText value="#{songController.year}" required="true"
					requiredMessage="year is mandatory" id="year" />
				<h:message for="year" />
			</div>
			
			<div>
			<h:commandLink action="#{songController.createSong}" value="Submit">
			<f:param name="nameArtist" value="#{songController.nameArtist}" />
			</h:commandLink>
			</div>
		</h:form>
	</f:view> 
</body>
</html>


