<%-- 
    Document   : index
    Created on : 05 Jun 2022, 4:55:54 AM
    Author     : Litania Chauke
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Input data</title>
    </head>
    <body>
        <h1>User Details</h1>
        <form method= POST action="resources/applicant/appform">
            <p>name: <input type="text" name ="name"/> </p>
            <p>address: <input type="text" name ="surname"/> </p>
            <p>resume: <input type="text" name="resume"/></p>
            <p><input type="submit"/> </p>
        </form>
    </body>
</html>
