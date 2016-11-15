<%-- 
    Document   : c_accueil_messages
    Created on : 15 nov. 2016, 18:50:36
    Author     : antoine-xubuntu
--%>

<%@page import="entity.Message"%>
<%@page import="java.util.List"%>
<%@page import="util.HibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Session s = HibernateUtil.currentSession();
    List<Message> messages = s.createQuery("FROM Message").list();
    request.setAttribute("messages", messages);
    RequestDispatcher rd = getServletContext().getRequestDispatcher(("/diffusion/v_accueil.jsp"));
    rd.forward(request, response);
%>
