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
            <h1> All students </h1>
             <%@ include file="/jsp/Fragments/teacherfolder/studentSearchBar.jsp"%>
          <%@ include file="/jsp/Fragments/teacherfolder/teacherpage(user).jsp"%>

     <table id="data table">
         <c:forEach items="${searchAStudent}" var="dataPunkt">
              <tr>
             <c:forEach items="${dataPunkt}" var="dataPunktKolumn">
                     <td>${dataPunktKolumn}</td>
             </c:forEach>
              </tr>
         </c:forEach>
     </table>
        <%@ include file="/jsp/Fragments/footer.jsp"%>
    </body>
</html>