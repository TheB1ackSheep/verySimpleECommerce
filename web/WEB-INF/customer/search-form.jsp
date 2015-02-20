<form action="<%=request.getContextPath()%>/customer/search" method="POST">
    <label for="keyword">Enter customer ID: <input type="text" id="cid" name="cid" placeholder="customer id" autocomplete="off" required value="<%=request.getParameter("cid")!=null?request.getParameter("cid"):""%>"/></label>
    <button>Search</button>
</form>