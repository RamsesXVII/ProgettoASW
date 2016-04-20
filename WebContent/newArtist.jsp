<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>New Artist</title>
</head>
<body>
	<f:view>
		<h:form>
  		    <div>
				Name:
				<h:inputText value="#{artistController.name}" required="true"
					requiredMessage="name is mandatory" id="name" />
				<h:message for="name" />
			</div>
			<div>
				Country:
				<h:inputText value="#{artistController.country}" required="true"
					requiredMessage="country is mandatory" id="country" />
				<h:message for="country" />
			</div>
			
			<div>
				<h:commandButton value="Submit"
					action="#{artistController.createArtist}" />
			</div>
		</h:form>
	</f:view> 
</body>
</html>