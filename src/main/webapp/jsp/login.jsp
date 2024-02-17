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
        <h1>Hello World from Sign In!</h1>
        <form action="/login" method="POST">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username"></input>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password"></input>
            <input type="submit" name="logIn" value="Log In"></input>
        </form>
         <%@ include file="/jsp/Fragments/footer.jsp"%>
    </body>
</html>