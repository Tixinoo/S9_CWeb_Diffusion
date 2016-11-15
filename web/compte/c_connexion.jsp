<%-- 
    Document   : c_connexion
    Created on : 15 nov. 2016, 14:54:31
    Author     : Maxime BLAISE
    Author     : Antoine NOSAL
--%>

<jsp:useBean id="unAbon" scope="session" class="entity.Abonne"/>

<jsp:setProperty name="unAbon" property="*" />

<%
    if (!unAbon.exists()) {
        // Redirection vers la page de connexion
        pageContext.forward("v_connexion.jsp");
    } else {
        // Redirection vers l'accueil
        pageContext.forward("../diffusion/v_accueil.jsp");
    }
%>