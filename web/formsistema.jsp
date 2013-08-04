<%-- 
    Document   : formsistema
    Created on : 01/08/2013, 16:49:57
    Author     : Pedro
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <h2><s:text name="menu.cadastro.sistema" /></h2>
    <s:form action="salvarSistema" method="get">
        <s:hidden name="id" value="%{#request.sistema.id}" />
        <s:textfield key="label.sistema.nome" name="nome" value="%{#request.sistema.nome}" />
        <s:submit value="Salvar" />
    </s:form>
</div>
<%@include file="rodape.jsp"%>
