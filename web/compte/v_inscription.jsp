<%-- 
    Document   : inscription
    Created on : 15 nov. 2016, 14:48:38
    Author     : Maxime BLAISE
    Author     : Antoine NOSAL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Page d'inscription</h1>
        
        <form action="c_inscription.jsp">
            <p> Login : <input type="text" name="login" /></p>
            <p> Password : <input type="text" name="mdp" /></p>
            <input type="submit" value="Je m'inscris" />
        </form>
    </body>
</html>
