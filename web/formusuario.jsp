<%-- 
    Document   : CadastroUsuario
    Created on : Jul 22, 2013, 10:23:32 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tickets - Cadastro de usuario</title>
    </head>
    <body>
        <h2><s:text name="Cadastro de usuario"/></h2>
        <s:form action="salvarUsuario" method="get"> 
            <s:textfield key="usuario.nome" />
            <s:textfield key="label.usuario.sobrenome" />
            <s:textfield key="label.usuario.email" />
            <s:submit />
        </s:form>
    </body>
</html>
