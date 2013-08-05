<%-- 
    Document   : menuAdministrador
    Created on : Aug 4, 2013, 2:10:28 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<div style="visibility: ${menuAdministradores}">
    <a href="usuarios"><s:text name="label.adm.usuarios" /></a>
    <a href="sistemas"><s:text name="label.adm.sistemas"/></a>
    <a href="componentes"><s:text name="label.adm.componentes"/></a>
</div>