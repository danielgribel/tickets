<%-- 
    Document   : listsistem
    Created on : 30/07/2013, 15:29:09
    Author     : Pedro
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <h2><s:text name="menu.lista.sistema"/></h2>
    <s:iterator value="#request.sistemas">
        <div class="tituloSistema">
        <s:url id="deleteURL" action="deleteSistema"><s:param name="id"><s:property value="id"/></s:param></s:url> 
        <s:url id="editURL" action="editarSistema"><s:param name="id"><s:property value="id"/></s:param></s:url>
        
        <a href="<s:property value="deleteURL"/>"><img src="/img/Delete16.gif"/></a>
        <a href="<s:property value="editURL"/>"><s:property value="nome"/></a>
        </div>
    </s:iterator>
</div>
<%@include file="rodape.jsp"%>
