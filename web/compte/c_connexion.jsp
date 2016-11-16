<%-- 
    Document   : c_connexion
    Created on : 15 nov. 2016, 14:54:31
    Author     : Maxime BLAISE
    Author     : Antoine NOSAL
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.Abonne"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="entity.Message"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<jsp:useBean id="unAbon" scope="session" class="entity.Abonne"/>

<jsp:setProperty name="unAbon" property="*" />

<%!
    public boolean exists(Abonne unAbon) {
        List<Abonne> abonnes = new ArrayList<Abonne>();
        final Session s = HibernateUtil.currentSession();
        abonnes = s.createQuery("FROM Abonne WHERE login='" + unAbon.getLogin() + "' AND mdp='" + unAbon.getMdp() + "'").list();   
        HibernateUtil.closeSession();
        return !abonnes.isEmpty();
    }
%>

<%
    if (!exists(unAbon)) {
        // Redirection vers la page de connexion
        pageContext.forward("v_connexion.jsp");
    } else {
        // Redirection vers l'accueil
        // pageContext.forward("../diffusion/v_accueil.jsp");
        response.sendRedirect("../diffusion/c_accueil_messages.jsp");
    }
%>