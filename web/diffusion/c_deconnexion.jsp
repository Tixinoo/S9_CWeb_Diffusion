<%-- 
    Document   : c_deconnexion
    Created on : 16 nov. 2016, 08:04:04
    Author     : antoine-xubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getSession().invalidate();
    response.sendRedirect("../index.html");
%>
