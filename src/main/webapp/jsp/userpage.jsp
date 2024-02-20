<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>

    <body>

    <c:choose>
     <c:when test="${userBean.userType == 'student'}">

      <%@ include file="/jsp/Fragments/studentfolder/studentnavbar.jsp"%>
       <%@ include file="/jsp/Fragments/studentfolder/studentpage.jsp"%>

     </c:when>
     <c:when test="${userBean.userType == 'teacher' && userBean.privilageType == 'user'}">
        <%@ include file="/jsp/Fragments/teacherfolder/teachernav(user).jsp"%>
          <%@ include file="/jsp/Fragments/teacherfolder/teacherpage(user).jsp"%>
     </c:when>
       <c:when test="${userBean.userType == 'teacher' && userBean.privilageType == 'admin'}">
             <%@ include file="/jsp/Fragments/teacherfolder/teacheradmin.jsp"%>
               <%@ include file="/jsp/Fragments/teacherfolder/teacherpage(user).jsp"%>
          </c:when>
       </c:choose>
    <%@ include file="Fragments/footer.jsp" %>
    </body>
</html>