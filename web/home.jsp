<%-- 
    Document   : home
    Created on : Jul 28, 2013, 9:58:29 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <div id="cabecalhoHome">
        <a href="logoutAction">Logout</a>
        <a href="#">Alterar senha</a>
        <a href="#">Alterar dados</a>
    </div>
    <h2><s:text name="menu.home"/></h2>
    <span id="boasVindas">Bem-vindo(a) <s:property value="#session['usuario'].nome" /></span>
</div>
<%@include file="rodape.jsp"%>
