<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <%@ include file="/jsp/Fragments/header.jsp"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <h1>Hello World from Show Students!</h1>
        <h3>${param.message}</h3>
    <table>
        <tr>
            <th>first name</th><th>last name</th>
        </tr>
        <c:forEach items="${usersBean.data }" var="dataPunkt">

            <tr>
                <td>${dataPunkt[1]}</td><td>${ dataPunkt[2] }</td>
            </tr>
        </c:forEach>


    </table>
            <%@ include file="/jsp/Fragments/footer.jsp"%>

    </body>
</html>