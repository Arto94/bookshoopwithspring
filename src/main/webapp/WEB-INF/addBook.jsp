<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 11.02.2018
  Time: 2:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book</title>
</head>
<body>


<spring:form action="/saveBook" modelAttribute="book" method="post">
    <spring:input path="title" title="title"/><br>
    <spring:input path="text" title="text"/><br>
    <spring:select path="author">
        <c:forEach items="${authors}" var="author">
            <spring:option value="${author}">${author.name}</spring:option>
        </c:forEach>
    </spring:select>
    <input type="submit" value="Save"/>
</spring:form>

</body>
</html>
