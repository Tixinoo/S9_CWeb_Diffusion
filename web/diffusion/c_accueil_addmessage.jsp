<%-- 
    Document   : c_accueil
    Created on : 15 nov. 2016, 16:48:12
    Author     : Antoine NOSAL
    Author     : Maxime BLAISE
--%>

<%@page import="org.hibernate.Transaction"%>
<%@page import="entity.Message"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<jsp:useBean id="unMessage" scope="session" class="entity.Message"/>
<jsp:useBean id="unAbon" scope="session" class="entity.Abonne"/>
<jsp:setProperty name="unMessage" property="*" />

<%
    final Session s = HibernateUtil.currentSession();
    try {
        final Transaction tx = s.beginTransaction();
        try {
            // The real work is here
            unMessage.setExpediteur(unAbon);
            s.save(unMessage);
            List<Message> messages = s.createQuery("FROM Message").list();
            request.setAttribute("messages", messages);
            tx.commit();
        } catch (Exception ex) {
            // Log the exception here
            tx.rollback();
            throw ex;
        }
    } finally {
        HibernateUtil.closeSession();
    }
    RequestDispatcher rd = getServletContext().getRequestDispatcher(("/diffusion/v_accueil.jsp"));
    rd.forward(request, response);
    
    //pageContext.forward("v_accueil.jsp");
    //response.sendRedirect("v_accueil.jsp");
%>