<%-- 
    Document   : logoff
    Created on : 01/11/2017, 12:37:38
    Author     : THANDER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logoff</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        %>
    </body>
</html>
