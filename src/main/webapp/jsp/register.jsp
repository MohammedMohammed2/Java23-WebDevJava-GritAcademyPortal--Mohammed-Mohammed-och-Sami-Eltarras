<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body class="bodyimage">
    <%@ include file="/jsp/Fragments/header.jsp"%>
        <h1>Hello World from Register!</h1>
        <form action="/register" method="GET">
            <label for="fname">First name:</label>
            <input type="text" id="fname" name="fname"></input>
            <label for="lname">Last name:</label>
            <input type="text" id="lname" name="lname"></input>
            <input type="submit" name="register" value="register"></input>
        </form>


        <%@ include file="/jsp/Fragments/footer.jsp"%>
    </body>
</html>