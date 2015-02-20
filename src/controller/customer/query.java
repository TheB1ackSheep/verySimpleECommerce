package controller.customer;

import model.Customer;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by INT303 on 6/2/2558.
 */
@WebServlet(name = "ctr-cust-search",urlPatterns = "/customer/search")
public class query extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        if(cid == null){

        }else{
            if(Util.isInteger(cid)){
                int id = Integer.parseInt(cid);
                try {
                    Customer cust = Customer.findById(id);
                    if(cust != null)
                        request.setAttribute("c",cust);
                    else
                        request.setAttribute("error","Customer nut found");
                } catch (SQLException e) {
                    request.setAttribute("error", e.getMessage());
                } catch (ClassNotFoundException e) {
                    request.setAttribute("error", e.getMessage());
                }
            }else{
                request.setAttribute("error","Invalid customer ID");
            }
        }
        render(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        render(request,response);
    }

    protected void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageTitle","Customer Search");
        getServletContext().getRequestDispatcher("/WEB-INF/customer/index.jsp").include(request,response);
    }
}
