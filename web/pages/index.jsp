<%-- 
    Document   : index
    Created on : 07.10.2013, 22:00:53
    Author     : Eugene
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2 align="center" style="color: royalblue">Authorization Form</h2>
        <form method="post" action="/MyServlet">
            <input type="hidden" name="command" value="login">
            <hr>
            <table width="100%" cellspacing="0" cellpadding="4">
                <tr> 
                    <td align="right" width="100">Login:</td>
                    <td><input type="text" name="login" size="20"></td>
                </tr>
                <tr> 
                    <td align="right">Password:</td>
                    <td><input type="password" name="password" maxlength="50" size="20"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="login" value=" Login "></td>
                </tr>
            </table>
            <a href="/registration.jsp">Registration</a>
            <hr>
        </form>
    </body>
</html>
