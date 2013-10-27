<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><title>Login Error</title>
    <meta http-equiv="refresh" content="4; url='/index.jsp'">
    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
    <script>
        var x = 3;
        function a()
        {
            if (x > 0) {
                document.getElementById('countdiv').innerHTML = "<b>Error while authorization<b>.<br> In <b>" + x + "</b> seconds you will be redirected to login page.";
            } else if (x > -5) {
                document.getElementById('countdiv').innerHTML = "";
            } else {
                document.getElementById('countdiv').innerHTML = "Reload page for continuing";
                window.clearInterval(timer);
            }
            x -= 1;
        }
    </script>
</head>
<body onload="javascript: timer = setInterval('a()', 1000);"><br>
    <div align=center id=countdiv></div>
</body>
</html>