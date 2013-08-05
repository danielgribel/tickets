<%-- 
    Document   : statusTicket
    Created on : Aug 4, 2013, 10:20:10 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="menu.statusTicket"/></h2>
    <s:div>
        <s:actionerror />
        <s:form action="salvarStatus" method="get">
            <s:hidden name="idTicket" value="%{#request.ticket.idTicket}"/>
            <s:textfield key="label.titulo" name="titulo" value="%{#request.ticket.titulo}" readonly="true" />
            <s:textfield key="label.sistema" name="sistema" value="%{#request.ticket.sistema}" readonly="true" />
            <s:textfield key="label.componente" name="componente" value="%{#request.ticket.componente}" readonly="true" />
            <s:textfield key="label.descricao" name="descricao" value="%{#request.ticket.descricao}" readonly="true" />
            <s:textfield key="label.operador" name="operador" value="%{#request.ticket.operador}" readonly="true" />
            <s:select key="label.status"
		list="listaStatus"
		name="status"
		value="%{#request.ticket.status}" />
            <s:submit value="Salvar" />
        </s:form>
    </s:div>
</div>
<%@include file="rodape.jsp"%>