<%-- 
    Document   : formComponente
    Created on : Aug 4, 2013, 1:04:07 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="menu.cadastro.componente"/></h2>
    <s:form action="salvarComponente" method="get">
        <s:hidden name="idComponente" value="%{#request.componente.idComponente}"/>
        <s:textfield key="label.componente.nome" name="nome" value="%{#request.componente.nome}" />
        <s:select key="label.sistema"
		headerKey="-1" headerValue="Selecione o sistema"
		list="listaSistemas"
		listValue="nome"
                listKey="id"
                name="sistema"
                value="%{#request.componente.sistema}" />
        <s:select key="label.operador"
		headerKey="-1" headerValue="Selecione o operador"
		list="listaOperadores"
                listValue="email"
                listKey="email"
		name="operador"
		value="%{#request.componente.operador}" />
        <s:submit value="Salvar" />
    </s:form>
</div>
<%@include file="rodape.jsp"%>