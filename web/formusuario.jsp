<%-- 
    Document   : formusuario
    Created on : Jul 22, 2013, 10:23:32 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="tituloPagina.usuario"/></title>
    </head>
    <body>
        <h1><a href="/tickets"/><s:text name="app.titulo"/></a></h1>
        <h2><s:text name="menu.cadastro.usuario"/></h2>
        <s:form action="salvarUsuario" method="get">
            <s:textfield key="label.usuario.nome" name="nome" value="%{#request.usuario.nome}" />
            <s:textfield key="label.usuario.sobrenome" name="sobrenome" value="%{#request.usuario.sobrenome}" />
            <s:textfield key="label.usuario.email" name="email" value="%{#request.usuario.email}" />
            <s:password key="label.usuario.senha" name="senha" value="%{#request.usuario.senha}" />
            <s:password key="label.usuario.confirmaSenha" name="confirmaSenha" value="%{#request.usuario.confirmaSenha}" />
            <s:submit />
        </s:form>
    </body>
</html>
