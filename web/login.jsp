<%-- 
    Document   : login
    Created on : Jul 25, 2013, 2:22:20 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@include file="cabecalho.jsp"%>
<div id="content">        
    <h2><s:text name="menu.login"/></h2>
    <s:form action="login" method="get"> 
        <s:textfield key="label.usuario.email" />
        <s:textfield key="label.usuario.senha" />
        <s:submit value="Login" />
    </s:form>
</div>
<%@include file="rodape.jsp"%>