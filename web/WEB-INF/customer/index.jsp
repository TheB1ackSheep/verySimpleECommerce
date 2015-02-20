<%@ page import="model.Customer" %>
<%@ include file="/WEB-INF/header.jsp"%>

<h1>::Customer Information::</h1>
<%@ include file="/WEB-INF/customer/search-form.jsp"%>
<%@ include file="/WEB-INF/error.jsp"%>
<%
  if(request.getAttribute("c") != null){
%>
<table>
  <tr><td>Customer ID:</td><td>${c.cid}</td></tr>
  <tr><td>Customer Name:</td><td>${c.name}</td></tr>
  <tr><td>City:</td><td>${c.city}</td></tr>
  <tr><td>Phone:</td><td>${c.zip}</td></tr>
  <tr><td>eMail:</td><td>${c.email}</td></tr>
  <tr><td>Credit Limit:</td><td>${c.creditLimit}</td></tr>
</table>
<%
  }
%>

<%@ include file="/WEB-INF/footer.jsp"%>
