<%-- 
    Document   : listsistem
    Created on : 30/07/2013, 15:29:09
    Author     : Pedro
--%>
<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="label.adm.sistemas"/></h2>
    <div id="novoTicket">
        <a href="<s:url action="criarSistema"/>"><s:text name="botao.sistema.novo"/></a>
    </div>
    <s:iterator value="#request.sistemas">
        <div class="lista">
            <s:url id="deleteURL" action="removerSistema"><s:param name="id"><s:property value="id"/></s:param></s:url> 
            <a class="remover" href="<s:property value="deleteURL"/>">remover</a>
            <s:url id="editURL" action="editarSistema"><s:param name="id"><s:property value="id"/></s:param></s:url>
            <a class="editar" href="<s:property value="editURL"/>">editar</a>
            <a class="itemLista" href="<s:property value="editURL"/>"><s:property value="nome"/></a>
        </div>
    </s:iterator>
</div>
<%@include file="rodape.jsp"%>
