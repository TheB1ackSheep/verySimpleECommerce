<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<% String contextPath = pageContext.getServletContext().getContextPath(); %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>${pageTitle}</title>

    <link rel="stylesheet" href="<%=contextPath%>/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=contextPath%>/css/todc-bootstrap.min.css">
    <link rel="stylesheet" href="<%=contextPath%>/css/app.css">
    <style>
        .text-right {
            text-align: right;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-toolbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">FALOOK STORE</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="<%=response.encodeURL(contextPath+"/product")%>">Product</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<section class="container">
