<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
    <head>
        <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
        <title>Home</title>
    </head>
    <body>
        <form:form method="POST" commandName="user" action="check-user" class="box login">
            <fieldset class="boxBody">
                <form:label path="name">Имя: </form:label>
                <form:input path="name" />
                <form:label path="password">Пароль: </form:label>
                <form:input path="password" />                
            </fieldset>
            <footer>
                <form:checkbox path="admin" />
                <form:label path="admin">Администратор: </form:label>
                <input type="submit" class="btnLogin" value="Login">
            </footer>
        </form:form>

    </body>
</html>