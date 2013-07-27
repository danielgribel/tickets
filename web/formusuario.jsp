<%-- 
    Document   : formusuario
    Created on : Jul 22, 2013, 10:23:32 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="cabecalho.jsp"%>
<div id="content">
    <h2><s:text name="menu.cadastro.usuario"/></h2>
    <s:form action="salvarUsuario" method="get">
        <s:textfield key="label.usuario.nome" name="nome" value="%{#request.usuario.nome}" />
        <s:textfield key="label.usuario.sobrenome" name="sobrenome" value="%{#request.usuario.sobrenome}" />
        <s:textfield key="label.usuario.email" name="email" value="%{#request.usuario.email}" />
        <s:password key="label.usuario.senha" name="senha" value="%{#request.usuario.senha}" />
        <s:password key="label.usuario.confirmaSenha" name="confirmaSenha" value="%{#request.usuario.confirmaSenha}" />
        <s:submit value="Salvar" />
    </s:form>
</div>
<%@include file="rodape.jsp"%>