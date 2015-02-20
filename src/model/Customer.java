package model;

import util.BuildConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int cid;
    private String name;
    private String city;
    private String zip;
    private String email;
    private int creditLimit;

    private static final String TABLE_NAME = "customer";
    private static final String COLUMN_CID = "customer_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_ZIP = "zip";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_CREDITLIMIT = "credit_limit";

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getcreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(int creditLimit) {
        this.creditLimit = creditLimit;
    }

    public static Customer findById(int id) throws SQLException, ClassNotFoundException {
        Customer c = null;
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ");
        sql.append(TABLE_NAME);
        sql.append(" WHERE ");
        sql.append(COLUMN_CID+"=?");
        Connection conn = BuildConnection.getConnection();
        PreparedStatement prep = conn.prepareStatement(sql.toString());
        prep.setInt(1,id);
        ResultSet rs = prep.executeQuery();
        if(rs.next()){
            c = new Customer();
            orm(rs,c);
        }
        return c;
    }

    public static List<Customer> getCustomerList() throws SQLException, ClassNotFoundException {
        List<Customer> custs = new ArrayList<Customer>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ");
        sql.append(TABLE_NAME);
        Connection conn = BuildConnection.getConnection();
        PreparedStatement prep = conn.prepareStatement(sql.toString());
        ResultSet rs = prep.executeQuery();
        while(rs.next()){
            Customer c = new Customer();
            orm(rs,c);
            custs.add(c);
        }
        return custs;
    }

    private static void orm(ResultSet rs,Customer c) throws SQLException {
        c.setCid(rs.getInt(COLUMN_CID));
        c.setCity(rs.getString(COLUMN_CID));
        c.setCreditLimit(rs.getInt(COLUMN_CREDITLIMIT));
        c.setEmail(rs.getString(COLUMN_EMAIL));
        c.setName(rs.getString(COLUMN_NAME));
        c.setZip(rs.getString(COLUMN_ZIP));
    }
}
