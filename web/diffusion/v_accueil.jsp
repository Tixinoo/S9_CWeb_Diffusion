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
<jsp:useBean id="unAbon" scope="session" class="entity.Abonne"/>
<%
    pageContext.setAttribute("login", unAbon.getLogin());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diffusion - Accueil</title>
    </head>
    <body>
        <div style="text-align:right">Connecté en tant que <b>${login}</b>
            <form method="link" action="c_deconnexion.jsp">
                <input type="submit" value="Déconnexion"/>
            </form>
        </div>
        <hr>
        <h1 style="text-align:center;">Accueil</h1>

        <div style="width:20%;display:inline;float:left;">
            <h2 style="text-align:center;">Diffuser un message</h2>
            <div style="margin-top:-12px;margin-bottom:15px;width:75%;margin-left:auto;margin-right:auto;"><hr></div>
            <form action="c_accueil_addmessage.jsp">
                <table style="margin-left:auto;margin-right:auto;">
                    <tr>
                        <td>Objet :</td>
                        <td><input type="text" name="objet" /></td>
                    </tr>
                    <tr>
                        <td>Corps :</td>
                        <td><input type="text" name="corps" /></td>
                    </tr>
                    <tr>
                        <td colspan=2><input style="width:100%" type="submit" value="Envoyer ce message" /></td>
                    </tr>
                </table>
            </form>
        </div>

        <div style="width:80%;display:inline;float:left;">
            <h2 style="text-align:center;">Messages diffusés</h2>
            <div style="margin-top:-12px;width:20%;margin-left:auto;margin-right:auto;"><hr></div>
            <table style="width:80%;margin-left:auto;margin-right:auto;">
                <c:forEach items="${messages}" var="message" >
                    <tr>
                        <td style="width:15%;">Expéditeur :</td>
                        <td><c:out value="${message.expediteur.login}"/></td>
                    </tr>
                    <tr>
                        <td>Objet :</td>
                        <td><c:out value="${message.objet}"/></td>
                    </tr>
                    <tr>
                        <td>Corps :</td>
                        <td><c:out value="${message.corps}"/></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
