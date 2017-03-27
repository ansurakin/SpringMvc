<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>main</title>
    </head>
    <body>
        <p>Ваше имя: ${user.name}</p>
        <p>Ваш пароль: ${user.password}</p>
        <p>Администратор: ${user.admin}</p>
        <p>${locale}</p>
        
        <p><a href="downloadPDF">Download PDF Document</a></p>

    <form:form method="POST" enctype="multipart/form-data" modelAttribute="uploadedFile" action="uploadFile">
        <table>
            <tr>
                <td>Upload File:</td>
                <td><input type="file" name="file" /></td>
                <td style="color: red; font-style: italic;">
            <form:errors path="file" /></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Upload" /></td>
                <td></td>
            </tr>
        </table>
    </form:form>

</body>
</html>
