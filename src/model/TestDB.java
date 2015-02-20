package model;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by INT303 on 13/2/2558.
 */
public class TestDB {
    public static void main(String[] args) {
        try {
            List<Product> products = Product.getProductList();
            Cart c = new Cart();
            Product p = null;
            for(int i=0;i<=4;i++){
                c.add(products.get(i),1);
            }

            System.out.println(c);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
