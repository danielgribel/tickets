<%-- 
    Document   : login
    Created on : Jul 25, 2013, 2:22:20 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloPagina.login"/></title>
    </head>
    <body>
        <h1><a href="/tickets"/><s:text name="app.titulo"/></a></h1>
        <h2><s:text name="menu.login"/></h2>
        <s:form action="login" method="get"> 
            <s:textfield key="label.usuario.email" />
            <s:textfield key="label.usuario.senha" />
            <s:submit key="botao.login" />
        </s:form>
    </body>
</html>