<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Product" %>
<%@ page import="model.Manufacturer" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ include file="/WEB-INF/header.jsp"%>

<div class="p6n-action-bar">
    <a class="btn btn-default"  href="<%=contextPath+"/product"%>">Back</a>
    <div class="btn-group">
        <button type="submit" class="btn btn-primary">Add to cart</button>
        <a class="btn btn-default" href="<%=contextPath+"/cart"%>">View cart</a>
    </div>
</div>

<%@ include file="/WEB-INF/error.jsp"%>

<%
    DecimalFormat df = new DecimalFormat("#,###.00");
    Product product = (Product) request.getAttribute("p");
    if (product != null) {
%>
    <h2><%=product.getId()%> : <%=product.getDescription()%></h2>
    <p>Code : <%=product.getCode()%><br/>
    Cost : <%=product.getCost()%><br/>
    Markup : <%=product.getMarkup()%><br/>
    Available : <%=product.getAvailable()%></p>
    <% Manufacturer m = product.getManufacturer(); %>
    <h2>Manufacturer</h2>
    <p>Name : <%=m.getName()%><br/>
    Address : <%=m.getAddressLine1()%><br/><%=m.getAddressLine2()%><br/>
    City : <%=m.getCity()%><br/>
    State : <%=m.getState()%><br/>
    Zip : <%=m.getZip()%><br/>
    Phone/Fax : <%=m.getPhone()%>/<%=m.getFax()%><br/>
    Email : <%=m.getEmail()%><br/>
    REP : <%=m.getRep()%></p>

<%
    }
%>
<%@ include file="/WEB-INF/footer.jsp" %>
