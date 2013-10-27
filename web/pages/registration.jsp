<%-- 
    Document   : registration
    Created on : 08.10.2013, 16:39:22
    Author     : Eugene
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h2 align="center" style="color: royalblue">Registration Form</h2>
        <form method="POST" action="/MyServlet" accept-charset="UTF-8">
            <input type="hidden" name="command" value="registration">
            <hr>
            <table width="100%" cellspacing="0" cellpadding="4">
                <tr> 
                    <td align="right" width="100">Login:</td>
                    <td><input type="text" name="login" size="20"></td>
                </tr>
                <tr> 
                    <td align="right">Password:</td>
                    <td><input type="text" name="password" maxlength="50" size="20">
                    </td>
                </tr>
                <tr> 
                    <td align="right">E-mail:</td>
                    <td><input type="text" name="email" maxlength="50" size="20">
                    </td>
                </tr>
                <tr> 
                    <td align="right">Account type:</td>
                    <td><select size="1" name="account_type_id">
                            <option disabled selected>Choose account type:</option>
                            <option value="bronze">Bronze</option>
                            <option value="silver">Silver</option>
                            <option value="gold">Gold</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td align="right">First name:</td>
                    <td><input type="text" name="first_name" maxlength="50" size="20">
                    </td>
                </tr>
                <tr> 
                    <td align="right">Last Name:</td>
                    <td><input type="text" name="last_name" maxlength="50" size="20">
                    </td>
                </tr>
                <tr> 
                    <td align="right">Wallet currency:</td>
                    <td><select size="1" name="wallet_currency" style="size: 30px">
                            <option disabled selected>Choose wallet currency:</option>
                            <option value="USD">USD</option>
                            <option value="EUR">EUR</option>
                            <option value="UAH">UAH</option>
                            <option value="RUB">RUB</option>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td></td>
                    <td><input type="submit" name="registration" value=" Confirm "></td>
                </tr>
            </table>
            <hr>
        </form>
    </body>
</html>
