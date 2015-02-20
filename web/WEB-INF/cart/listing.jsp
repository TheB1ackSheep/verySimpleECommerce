<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.DecimalFormat" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Cart" %>
<%@ include file="/WEB-INF/header.jsp"%>

<div class="p6n-action-bar">
    <a class="btn btn-default"  href="<%=contextPath+"/product"%>">Back</a>
</div>

<%@ include file="/WEB-INF/error.jsp"%>

<%
    DecimalFormat df = new DecimalFormat("#,###.00");
    Cart cart = (Cart)request.getSession().getAttribute("cart");
    if(cart != null){
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
        <th class="text-right"><a class="p6n-clickable-link p6n-sort-link p6n-sort-flip">Price/Unit</a></th>
        <th class="text-right"><a class="p6n-clickable-link p6n-sort-link p6n-sort-flip">Qty</a></th>
    </tr><%
    for(Cart.CartItem i : cart.items){
%>
    <tr>
        <td>
            <label ng-transclude="" pan-form-option-type="checkbox" class="ng-isolate-scope p6n-checkbox">
                <input type="checkbox" value="<%=i.getProduct().getId()%>" class="ng-pristine ng-untouched ng-valid ng-scope">
                <span class="p6n-form-label ng-scope"></span>
            </label>
        </td>
        <td><a href="<%=contextPath+"/product/"+i.getProduct().getId()%>"><%=i.getProduct().getDescription()%></a></td>
        <td class="text-right"><%=df.format(i.getProduct().getPrice())%></td>
        <td class="text-right"><%=i.getQty()%></td>
    </tr>
    <%
        }
    %></table><%
    }else{
        %>
        <p>ไม่มีสินค้าในตะกร้า</p>
        <%
    }

%>

<%@ include file="/WEB-INF/footer.jsp"%>
