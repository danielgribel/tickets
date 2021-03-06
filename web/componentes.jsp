<%-- 
    Document   : componentes
    Created on : Aug 4, 2013, 2:02:10 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="label.adm.componentes"/></h2>
    <div id="novoTicket">
        <a href="<s:url action="criarComponente"/>"><s:text name="botao.componente.novo"/></a>
    </div>
    
    <s:iterator value="#request.componentes">
        <div class="lista">
            <s:url id="deleteURL" action="removerComponente"><s:param name="idComponente"><s:property value="idComponente"/></s:param></s:url>
            <a class="remover" href="<s:property value="deleteURL"/>">remover</a>
            <s:url id="editURL" action="editarComponente"><s:param name="idComponente"><s:property value="idComponente" /></s:param></s:url>
            <a class="editar" href="<s:property value="editURL"/>">editar</a>
            <a class="itemLista" href="<s:property value="editURL"/>"><s:property value="nome" /></a>
        </div>
    </s:iterator>
    
</div>
<%@include file="rodape.jsp"%>
