<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${books}" var="book">
    <span>${book.title}</span><br>
    <span>${book.text}</span><br>
    <span>${book.author.name}</span><br>
</c:forEach>
</body>
</html>
