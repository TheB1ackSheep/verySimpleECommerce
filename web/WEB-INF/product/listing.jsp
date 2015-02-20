<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ include file="/WEB-INF/header.jsp"%>

<form action="<%=contextPath+"/cart"%>" method="POST">

<div class="p6n-action-bar">
    <div class="btn-group">
        <button type="submit" class="btn btn-primary">Add to cart</button>
        <a class="btn btn-default" href="<%=contextPath+"/cart"%>">View cart</a>
    </div>
</div>

<%@ include file="/WEB-INF/error.jsp"%>

<%
    DecimalFormat df = new DecimalFormat("#,###.00");
    List<Product> products = (ArrayList<Product>)request.getAttribute("p");
    if(products != null){
        %>
<table class="p6n-table">
    <tr>
        <th>
            <label ng-transclude="" pan-form-option-type="checkbox" class="ng-isolate-scope p6n-checkbox">
                <input type="checkbox" class="ng-pristine ng-untouched ng-valid ng-scope">
                <span class="p6n-form-label ng-scope"></span>
            </label>
        </th>
        <th><a class="p6n-clickable-link p6n-sort-link p6n-sort-flip">Name</a></th>
        <th class="text-right"><a class="p6n-clickable-link p6n-sort-link p6n-sort-flip">Price</a></th>
        <th class="text-right"><a class="p6n-clickable-link p6n-sort-link p6n-sort-flip">Qty</a></th>
    </tr><%
        for(Product p : products){
            %>
                <tr>
                    <td>
                        <label ng-transclude="" pan-form-option-type="checkbox" class="ng-isolate-scope p6n-checkbox">
                            <input type="checkbox" name="pid" value="<%=p.getId()%>" class="ng-pristine ng-untouched ng-valid ng-scope">
                            <span class="p6n-form-label ng-scope"></span>
                        </label>
                    </td>
                    <td><a href="<%=contextPath+"/product/"+p.getId()%>"><%=p.getDescription()%></a></td>
                    <td class="text-right"><%=df.format(p.getPrice())%></td>
                    <td class="text-right"><%=p.getQty()%></td>
                </tr>
            <%
        }
        %></table><%
    }

%>
</form>

<%@ include file="/WEB-INF/footer.jsp"%>
