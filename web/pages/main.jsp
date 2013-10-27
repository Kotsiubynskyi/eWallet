<%-- 
    Document   : loginsuccess
    Created on : 08.10.2013, 0:59:09
    Author     : Eugene
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
        <style type="text/css">
            BODY {
                background: white; /* Цвет фона веб-страницы */
            }
            TABLE {
                width: 300px; /* Ширина таблицы */
                border-collapse: collapse; /* Убираем двойные линии между ячейками */
                border: 2px solid white; /* Прячем рамку вокруг таблицы */
            }
            TD, TH {
                padding: 3px; /* Поля вокруг содержимого таблицы */
                border: 1px solid maroon; /* Параметры рамки */
                text-align: left; /* Выравнивание по левому краю */
            }
        </style>
    </head>
    <body>
        <h3>Welcome, <c:out value="${userInfo.firstName}"/></h3>
        <table>
            <tr>
                <td><b>First name: </b></td>
                <td><c:out value="${userInfo.firstName}"/></td>
            </tr>
            <tr>
                <td><b>Second name: </b></td>
                <td><c:out value="${userInfo.lastName}"/></td>
            </tr>
            <tr>
                <td><b>Account Id: </b></td>
                <td><c:out value="${accInfo.accountId}"/></td>
            </tr>
            <tr>
                <td><b>Wallet Id: </b></td>
                <td><c:out value="${accInfo.walletId.walletId}"/></td>
            </tr>
        </table>
    </body>
</html>
