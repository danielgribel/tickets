<%-- 
    Document   : cabecalho
    Created on : Jul 26, 2013, 9:53:25 PM
    Author     : Daniel Gribel <daniel.gribel@uniriotec.br>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<%
	response.setHeader ("Cache-Control", "no-cache");
	response.setHeader ("Pragma", "no-cache");
	response.setDateHeader ("Expires", 0); 
%>
<html>
    <head>
        <title>Tickets</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div id="header">
            <a href="/tickets"><h1>tickets</h1></a>
            <span id="slogan">Um sistema para gerenciamento de tickets</span>
        </div>
