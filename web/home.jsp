<%-- 
    Document   : home
    Created on : Jul 28, 2013, 9:58:29 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="menu.home"/></h2>
    <span id="boasVindas">Bem-vindo(a) <s:property value="#session['usuario'].nome" /></span>
    <div style="display: ${areaTicketsFinal}">
        <div id="novoTicket">
            <a href="<s:url action="criarTicket"/>"><s:text -´="botao.ticket.novo"/></a>
        </div>
        <h3>Tickets</h3>
        <s:iterator value="#request.tickets">
            <div class="lista">
                <s:url id="editURL" action="editarTicket"><s:param name="idTicket"><s:property value="idTicket" /></s:param></s:url>
                <a class="editar" href="<s:property value="editURL"/>">editar</a>
                <s:url id="statusURL" action="editarStatusTicket"><s:param name="idTicket"><s:property value="idTicket" /></s:param></s:url>
                <a class="editar" href="<s:property value="statusURL"/>">atualizar status</a>
                <a class="itemLista" href="<s:property value="statusURL"/>"><s:property value="titulo" /></a>
            </div>
        </s:iterator>
    </div>
    <div style="display: ${areaTicketsOperador}">
        <h3>Meus tickets</h3>
        <s:iterator value="#request.tickets">
            <div class="lista">
                <s:url id="statusURL" action="editarStatusTicket"><s:param name="idTicket"><s:property value="idTicket" /></s:param></s:url>
                <a class="editar" href="<s:property value="statusURL"/>">atualizar status</a>
                <a class="itemLista" href="<s:property value="statusURL"/>"><s:property value="titulo" /></a>
            </div>
        </s:iterator>
    </div>
</div>
<%@include file="rodape.jsp"%>
