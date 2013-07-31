<%-- 
    Document   : alteracaoDados
    Created on : Jul 30, 2013, 7:36:06 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <h2><s:text name="menu.alteracaoDados"/></h2>
    <s:div>
        <s:actionerror />
        <s:form action="alterarDados" method="get">
            <s:hidden name="email" value="%{#session['usuario'].email}" />
            <s:textfield key="label.usuario.nome" name="nome" value="%{#request.usuario.nome}" />
            <s:textfield key="label.usuario.sobrenome" name="sobrenome" value="%{#request.usuario.sobrenome}" />
            <s:submit value="Salvar" />
        </s:form>
    </s:div>
</div>
<%@include file="rodape.jsp"%>