package controller.product;

import model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static model.Product.getProductList;

/**
 * Created by INT303 on 13/2/2558.
 */
@WebServlet(name = "ctr-product-list",urlPatterns = "/product")
public class list extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession s = request.getSession(true);
        List<Product> products = null;
        try {
            products = getProductList();
            request.setAttribute("p",products);
        } catch (SQLException e) {
            s.setAttribute("error",e.getMessage());
        } catch (ClassNotFoundException e) {
            s.setAttribute("error",e.getMessage());
        }
        request.setAttribute("pageTitle","Product");
        getServletContext().getRequestDispatcher("/WEB-INF/product/listing.jsp").include(request,response);

    }
}
