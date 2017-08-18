<%-- 
    Document   : sair
    Created on : 20/11/2016, 20:46:57
    Author     : xino
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <% HttpSession sessao = request.getSession();
        sessao.invalidate();
         response.sendRedirect("validar.jsp");
        %>
        
    </body>
</html>
