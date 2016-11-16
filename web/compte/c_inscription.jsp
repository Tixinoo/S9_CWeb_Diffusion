<%-- 
    Document   : c_inscription
    Created on : 15 nov. 2016, 14:57:09
    Author     : Maxime BLAISE
    Author     : Antoine NOSAL
--%>

<%@page import="org.hibernate.Transaction"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<jsp:useBean id="unAbon" scope="session" class="entity.Abonne"/>

<jsp:setProperty name="unAbon" property="*" />

<%
    // Sauvegarde de l'abonné dans la base
    final Session s = HibernateUtil.currentSession();
    try {
        final Transaction tx = s.beginTransaction();
        try {
            // The real work is here
            s.save(unAbon);
            tx.commit();
        } catch (Exception ex) {
            // Log the exception here
            tx.rollback();
            throw ex;
        }
    } finally {
        HibernateUtil.closeSession();
    }
    
    // Redirection vers la page de connexion
    pageContext.forward("v_connexion.jsp");
%>