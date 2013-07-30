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
        <s:form action="alteraDados" method="post">
            <s:textfield name="nome" label="Nome" />
            <s:textfield name="sobrenome" label="Sobrenome" />
            <s:submit />
        </s:form>
    </s:div>
</div>
<%@include file="rodape.jsp"%>