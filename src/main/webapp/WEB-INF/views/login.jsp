<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
        <title>Home</title>
    </head>
    <body>  
        
        <form:form method="POST" commandName="user" action="check-user" class="box login">
            <span style="float: right">
                <a href="?lang=en">en</a>
                <a href="?lang=ru">ru</a>
            </span>
            <fieldset class="boxBody">
                <form:label path="name"><spring:message code="username" />: </form:label>
                <form:input path="name" />
                <form:errors path="name" cssClass="error" />
                <form:label path="password"><spring:message code="password" />: </form:label>
                <form:input path="password" />
                <form:errors path="password" cssClass="error" />                
            </fieldset>
            <footer>
                <form:checkbox path="admin" checked="checked" />
                <form:label path="admin"><spring:message code="admin" />: </form:label>
                <input type="submit" class="btnLogin" value="<spring:message code="login" />" >
            </footer>
        </form:form>

    </body>
</html>