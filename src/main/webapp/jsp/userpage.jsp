<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>
    <%@ include file="/jsp/Fragments/header.jsp"%>
       <table id="courses table">
           <c:forEach items="${data}" var="dataPunkt">
               <tr>
                   <td>${dataPunkt[0]}</td>
                   <td>${dataPunkt[1]}</td>
                   <td>${dataPunkt[2]}</td>
                   <td>${dataPunkt[3]}</td>
               </tr>
           </c:forEach>
       </table>
    <%@ include file="Fragments/footer.jsp" %>
    </body>
</html>