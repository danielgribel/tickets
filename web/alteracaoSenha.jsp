<%-- 
    Document   : alteracaoSenha
    Created on : Jul 30, 2013, 7:36:18 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <%@include file="menuAdministrador.jsp"%>
    <h2><s:text name="menu.alteracaoSenha"/></h2>
    <s:div>
        <s:actionerror />
        <s:form action="alterarSenha" method="get">
            <s:hidden name="email" value="%{#session['usuario'].email}" />
            <s:password name="senhaAtual" label="Senha atual" value="%{#request.usuario.senhaAtual}" />
            <s:password name="novaSenha" label="Nova senha" value="%{#request.usuario.novaSenha}" />
            <s:password name="confirmaSenha" label="Confirmar senha" value="%{#request.usuario.confirmaSenha}" />
            <s:submit value="Salvar" />
        </s:form>
    </s:div>
</div>
<%@include file="rodape.jsp"%>