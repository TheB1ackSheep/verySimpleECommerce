package controller.cart;

import model.Cart;
import model.Product;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by INT303 on 20/2/2558.
 */
@WebServlet(name = "ctr-cart-add",urlPatterns = "/cart")
public class add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String[] params = request.getParameterValues("pid");
        if(params != null) {
            HttpSession s = request.getSession(true);
            Cart cart = (Cart) s.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
                s.setAttribute("cart", cart);
            }

            for (String id : params) {
                if (Util.isInteger(id)) {
                    int pid = Integer.parseInt(id);
                    try {
                        Product p = Product.findById(pid);
                        cart.add(p, 1);
                        s.setAttribute("msg", "เพิ่มสินค้าลงตะกร้าเรียบร้อย");
                    } catch (SQLException e) {
                        s.setAttribute("error", e.getMessage());
                    } catch (ClassNotFoundException e) {
                        s.setAttribute("error", e.getMessage());
                    }
                }
            }
        }

        request.setAttribute("pageTitle","รายการสินค้า");
        response.sendRedirect(getServletContext().getContextPath()+"/product");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("pageTitle","ตะกร้าสินค้า");
        getServletContext().getRequestDispatcher("/WEB-INF/cart/listing.jsp").include(request, response);
    }
}
