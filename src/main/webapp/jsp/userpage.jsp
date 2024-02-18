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
    <c:choose>
     <c:when test="${userBean.userType == 'student'}">
        <%@ include file="/jsp/Fragments/studentfolder/studentpage.jsp"%>
     </c:when>
     <c:when test="${userBean.userType == 'teacher' && userBean.privilagetype == 'user'}">
          <%@ include file="/jsp/Fragments/teacherfolder/teacherpage(user).jsp"%>
     </c:when>
       </c:choose>
    <%@ include file="Fragments/footer.jsp" %>
    </body>
</html>