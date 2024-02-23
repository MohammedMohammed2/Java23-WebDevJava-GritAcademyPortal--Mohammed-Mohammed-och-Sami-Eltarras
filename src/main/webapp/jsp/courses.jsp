<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="bodyimage" >
    <%@ include file="/jsp/Fragments/header.jsp"%>

           <h1>All Courses</h1>

         <table id="data table">
         <c:forEach items="${userbean.data}" var="dataPunkt">
              <tr>
             <c:forEach items="${dataPunkt}" var="dataPunktKolumn">
                     <td>${dataPunktKolumn}</td>
             </c:forEach>
              </tr>
         </c:forEach>
    <%@ include file="/jsp/Fragments/footer.jsp"%>
    </body>
</html>