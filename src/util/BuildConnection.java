/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author INT303
 */
public class BuildConnection {
    public static Connection getConnectionX() {
        Connection con = null;
        try {
            Context ctx = null;
            ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("jdbc/sample");
            con = ds.getConnection();
        } catch (NamingException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con ;
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/sample";
            con = DriverManager.getConnection(url, "app", "app");
        return con ;
    }
}
