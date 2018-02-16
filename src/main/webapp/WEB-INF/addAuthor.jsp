<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<spring:form action="/saveAuthor" modelAttribute="author" method="post" enctype="multipart/form-data">
    <spring:input path="name" title="name"/><br>
    <spring:input path="surname" title="surname"/><br>
    <input type="number" title="age"><br>
    <input type="file" name="picture"><br>
    <input type="submit" value="Save"/>
</spring:form>

</body>
</html>
