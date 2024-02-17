<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <%@ include file="Fragments/header.jsp" %>
    <body>
        <h1>Hello World On your page !</h1>
        <table>

             <c:forEach items="${userBean.data }" var="dataPunkt">

                 <tr>
                     <td>${dataPunkt[1]}</td>
                     <td>${ dataPunkt[2] }</td>
                     <td>${ dataPunkt[3] }</td>
                     <td>${ dataPunkt[4] }</td>
                     <td>${ dataPunkt[5] }</td>
                     <td>${ dataPunkt[6] }</td>
                 </tr>
             </c:forEach>


         </table>
    <%@ include file="Fragments/footer.jsp" %>
    </body>
</html>