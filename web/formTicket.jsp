<%-- 
    Document   : formTicket
    Created on : Jul 31, 2013, 11:11:53 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <h2><s:text name="menu.cadastro.ticket"/></h2>
    <s:form action="salvarTicket" method="get">
        <s:hidden name="idTicket" value="%{#request.ticket.idTicket}"/>
        <s:textfield key="label.ticket.titulo" name="titulo" value="%{#request.ticket.titulo}" />
        <s:select key="label.ticket.sistema"
		headerKey="-1" headerValue="Selecione o sistema"
		list="listaSistemas"
		name="sistema"
		value="defaultSistema" />
        <s:select key="label.ticket.componente"
		headerKey="-1" headerValue="Selecione o componente"
		list="listaComponentes"
		name="componente"
		value="defaultComponente" />
        <s:textfield key="label.ticket.descricao" name="descricao" value="%{#request.ticket.descricao}" />
        <s:select key="label.ticket.operador"
		headerKey="-1" headerValue="Selecione o operador"
		list="listaOperadores"
		name="operador"
		value="defaultOperador" />
        <s:submit value="Salvar" />
    </s:form>
</div>
<%@include file="rodape.jsp"%>
