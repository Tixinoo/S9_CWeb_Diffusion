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
        <title>Diffusion - Inscription</title>
    </head>
    <body>
        <div style="text-align:center"><a style="text-decoration:none;" href="../index.html">← Accueil</a></div>
        <hr>
        <h1 style="text-align:center;">Inscription</h1>
        <form action="c_inscription.jsp">
            <table style="margin-left:auto;margin-right:auto;">
                <tr>
                    <td>Identifiant :</td>
                    <td><input type="text" name="login" /></td>
                </tr>
                <tr>
                    <td>Mot de passe : </td>
                    <td><input type="password" name="mdp" /></td>
                </tr>
                <tr></tr>
                <tr>
                    <td colspan=2><input style="width:100%" type="submit" value="Je m'inscris" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
