<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body class="bodyimage" >
    <%@ include file="/jsp/Fragments/header.jsp"%>

    <link rel="stylesheet" href="css/style.css">
    <table>

        <c:forEach items="${usersBean.data }" var="dataPunkt">

            <tr>
                <td>${dataPunkt[1]}</td><td>${ dataPunkt[2] }</td><td>${ dataPunkt[3] }</td>
            </tr>
        </c:forEach>


    </table>
    <%@ include file="/jsp/Fragments/footer.jsp"%>
    </body>
</html>