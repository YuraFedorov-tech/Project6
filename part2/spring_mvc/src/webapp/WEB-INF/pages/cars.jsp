<%--
  Created by IntelliJ IDEA.
  User: 00sna
  Date: 01.03.2020
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${tittles}</title>
</head>
<body>
<table>
    <tr>
        <td>ID</td>
        <td>MODEL</td>
        <td>COLOR</td>

    </tr>
    <c:forEach items="${carFromServer}" var="Car">
        <tr>
            <th>${Car.id}</th>
            <th>${Car.model}</th>
            <th>${Car.color}</th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
