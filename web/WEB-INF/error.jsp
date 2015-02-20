<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String error = (String)request.getSession().getAttribute("error");
  if(error != null)
    out.print("<div class=\"alert alert-danger\" role=\"alert\">"+error+"</div>");
  request.getSession().removeAttribute("error");
%>

<%
    String msg = (String)request.getSession().getAttribute("msg");
    if(msg != null)
        out.print("<div class=\"alert alert-success\" role=\"alert\">"+msg+"</div>");
    request.getSession().removeAttribute("msg");
%>