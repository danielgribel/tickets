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
		listValue="nome"
                listKey="id"
                name="sistema" 
                value="%{#request.ticket.sistema}" />
        <s:select key="label.ticket.componente"
		headerKey="-1" headerValue="Selecione o componente"
		list="listaComponentes"
                listValue="nome"
                listKey="idComponente"
		name="componente"
		value="%{#request.ticket.componente}" />
        <s:textfield key="label.ticket.descricao" name="descricao" value="%{#request.ticket.descricao}" />
        <s:select key="label.ticket.operador"
		headerKey="-1" headerValue="Selecione o operador"
		list="listaOperadores"
                listValue="email"
                listKey="email"
		name="operador"
		value="%{#request.ticket.operador}" />
        <s:submit value="Salvar" />
    </s:form>
</div>
<%@include file="rodape.jsp"%>
