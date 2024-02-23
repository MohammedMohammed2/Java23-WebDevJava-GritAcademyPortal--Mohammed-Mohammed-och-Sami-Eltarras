<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="bodyimage" >
    <%@ include file="/jsp/Fragments/header.jsp"%>

    <c:choose>
         <c:when test="${userBean.userType == 'student' && userBean.stateType == 'confirmed'}">
          <%@ include file="/jsp/Fragments/studentfolder/studentnavbarc.jsp"%>
           </c:when>
         <c:when test="${userBean.userType == 'teacher' && userBean.privilageType == 'user' && userBean.stateType == 'confirmed'}">
            <%@ include file="/jsp/Fragments/teacherfolder/teachernav(user).jsp"%>
             <%@ include file="/jsp/Fragments/teacherfolder/coursesSearchBar.jsp"%>
         <table id="data table">
         <c:forEach items="${searchACourse}" var="dataPunkt">
              <tr>
             <c:forEach items="${dataPunkt}" var="dataPunktKolumn">
                     <td>${dataPunktKolumn}</td>
             </c:forEach>
              </tr>
         </c:forEach>
         </c:when>
           </c:choose>
           <h1>All Courses</h1>

    <%@ include file="/jsp/Fragments/footer.jsp"%>
    </body>
</html>