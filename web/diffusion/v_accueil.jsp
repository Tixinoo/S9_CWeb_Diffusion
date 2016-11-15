<%-- 
    Document   : diffusion
    Created on : 15 nov. 2016, 14:48:38
    Author     : Maxime BLAISE
    Author     : Antoine NOSAL
--%>

<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page import="entity.Message"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Espace de diffusion</title>
    </head>
    <body>
        <h1>Accueil</h1>
        <h2>Liste des messages</h2>
        <ul>
            <c:forEach items="${messages}" var="message" >
                <li><c:out value="${message.corps}"/></li>
            </c:forEach>
        </ul>
        <h2>Envoyer un nouveau message</h2>
        <form action="c_accueil_addmessage.jsp">
            <p> Objet : <input type="text" name="objet" /></p>
            <p> Corps : <input type="text" name="corps" /></p>
            <input type="submit" value="Envoyer ce message" />
        </form>
    </body>
</html>
