<%-- 
    Document   : usuarios
    Created on : Aug 4, 2013, 4:16:11 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="label.adm.usuarios"/></h2>
    <s:iterator value="#request.usuarios">
        <div class="tituloTicket">
            <s:url id="editURL" action="alterarPerfil"><s:param name="email"><s:property value="email" /></s:param></s:url>
            <a href="<s:property value="editURL"/>"><s:property value="nome" /></a>
        </div>
    </s:iterator>
    
</div>
<%@include file="rodape.jsp"%>
