<%-- 
    Document   : home
    Created on : Jul 28, 2013, 9:58:29 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <h2><s:text name="menu.home"/></h2>
    <span id="boasVindas">Bem-vindo(a) <s:property value="#session['usuario'].nome" /></span>
    <div id="novoTicket">
        <a href="<s:url action="criarTicket"/>"><s:text name="botao.ticket.novo"/></a>
    </div>
    
    <h3>Meus tickets</h3>
    <s:iterator value="#request.tickets">
        <div class="tituloTicket">
            <s:url id="editURL" action="editarTicket"><s:param name="idTicket"><s:property value="idTicket" /></s:param></s:url>
            <a href="<s:property value="editURL"/>"><s:property value="titulo" /></a>
        </div>
    </s:iterator>
    
</div>
<%@include file="rodape.jsp"%>
