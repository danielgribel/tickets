<%-- 
    Document   : alteracaoPerfil
    Created on : Aug 4, 2013, 4:25:27 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="menu.alteracaoPerfil"/></h2>
    <s:div>
        <s:actionerror />
        <s:form action="salvarPerfil" method="get">
            <s:textfield key="label.usuario.nome" name="nome" value="%{#request.usuario.nome}" readonly="true" />
            <s:textfield key="label.usuario.sobrenome" name="sobrenome" value="%{#request.usuario.sobrenome}" readonly="true" />
            <s:textfield key="label.usuario.email" name="email" value="%{#request.usuario.email}" readonly="true" />
            <s:select key="label.usuario.perfil"
		list="listaPerfis"
		name="perfil"
		value="%{#request.usuario.perfil}" />
            <s:submit value="Salvar" />
        </s:form>
    </s:div>
</div>
<%@include file="rodape.jsp"%>
