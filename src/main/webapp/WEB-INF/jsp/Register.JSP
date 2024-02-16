<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Hello World from Register!</h1>
        <form action="/Register" method="POST">
            <label for="fname">First name:</label>
            <input type="text" id="fname" name="fname"></input>
            <label for="lname">Last name:</label>
            <input type="text" id="lname" name="lname"></input>
            <input type="submit" name="register" value="Register"></input>
        </form>
    </body>
</html>