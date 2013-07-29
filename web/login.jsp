<%-- 
    Document   : login
    Created on : Jul 25, 2013, 2:22:20 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">        
    <h2><s:text name="menu.login"/></h2>
    <s:actionerror />
    <s:form action="login" method="post">
        <s:textfield key="label.usuario.email" name="email" />
        <s:password key="label.usuario.senha" name="senha" />
        <s:submit value="Login" />
    </s:form>
</div>
<%@include file="rodape.jsp"%>