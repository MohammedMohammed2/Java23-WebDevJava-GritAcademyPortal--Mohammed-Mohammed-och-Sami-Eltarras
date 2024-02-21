<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="bodyimage">
    <%@ include file="/jsp/Fragments/header.jsp"%>
         <%@ include file="/jsp/Fragments/teacherfolder/teachernav(user).jsp"%>
          <%@ include file="/jsp/Fragments/teacherfolder/teacherpage(user).jsp"%>
          <h1> All students </h1>
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