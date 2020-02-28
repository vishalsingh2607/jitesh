<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<html>
<body>
<form:form modelAttribute="user">
		<form:input type="text" path="username"/>
		<form:input type="password" path="password"/>
		<form:input type="submit" path=""/>
        <form:errors path="username"/>
</form:form>
</body>
</html>