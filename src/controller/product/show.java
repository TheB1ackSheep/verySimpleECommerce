package controller.product;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by INT303 on 13/2/2558.
 */
@WebServlet(name = "ctr-product-show", urlPatterns = "/product/*")
public class show extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession s = request.getSession(true);
        String pathInfo = request.getPathInfo();
        if(pathInfo.split("/").length >= 1){
            String strId = pathInfo.split("/")[1];

            if (strId != null && Util.isInteger(strId)) {
                try {
                    Product p = Product.findById(Integer.parseInt(strId));
                    if (p != null) {
                        request.setAttribute("p", p);
                    }else{
                        s.setAttribute("error", "ไม่พบสินค้า");
                    }
                } catch (SQLException e) {
                    s.setAttribute("error", e.getMessage());
                } catch (ClassNotFoundException e) {
                    s.setAttribute("error", e.getMessage());
                }

            } else {
                s.setAttribute("error", "ไม่พบสินค้า");
            }
        }else{
            s.setAttribute("error","ไม่พบสินค้า");
        }

        request.setAttribute("pageTitle", "Product");
        getServletContext().getRequestDispatcher("/WEB-INF/product/show.jsp").include(request, response);

    }
}
