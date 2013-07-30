<%-- 
    Document   : alteracaoSenha
    Created on : Jul 30, 2013, 7:36:18 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>

<%@include file="cabecalho.jsp"%>
<div id="content">
    <%@include file="cabecalhoHome.jsp"%>
    <h2><s:text name="menu.alteracaoSenha"/></h2>
    <s:div>
        <s:actionerror />
        <s:form action="alteraSenha" method="post">
            <s:password name="senhaAtual" label="Senha atual" />
            <s:password name="novaSenha" label="Nova senha" />
            <s:password name="confirmaNovaSenha" label="Confirmar nova senha" />
            <s:submit />
        </s:form>
    </s:div>
</div>
<%@include file="rodape.jsp"%>