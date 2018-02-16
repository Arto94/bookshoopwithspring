<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Authors</title>
</head>
<body>
<span>All Authors</span>

<ul>
    <c:forEach items="${authors}" var="author">
       <img src="/image?fileName=${author.picUrl}" width="100px"/>
        <li>${author.name} ${author.surname}</li>
    </c:forEach>
</ul>
</body>
</html>
