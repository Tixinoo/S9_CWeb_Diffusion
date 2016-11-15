<%-- 
    Document   : c_inscription
    Created on : 15 nov. 2016, 14:57:09
    Author     : Maxime BLAISE
    Author     : Antoine NOSAL
--%>

<jsp:useBean id="unAbon" scope="session" class="entity.Abonne"/>

<jsp:setProperty name="unAbon" property="*" />

<%
    // Sauvegarde de l'abonné dans la base
    unAbon.save();
    
    // Redirection vers la page de connexion
    pageContext.forward("v_connexion.jsp");
%>