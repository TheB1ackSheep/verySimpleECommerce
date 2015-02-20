package model;

import javafx.scene.control.TableView;
import util.BuildConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by INT303 on 13/2/2558.
 */
public class Product {

    private int id;
    private Manufacturer manufacturer;
    private String code;
    private double cost;
    private int qty;
    private double markup;
    private String available;
    private String description;
    private double price;

    private static final String TABLE_NAME = "product";
    private static final String COLUMN_ID = "product_id";
    private static final String COLUMN_MANU = "manufacturer_id";
    private static final String COLUMN_CODE = "product_code";
    private static final String COLUMN_COST = "purchase_cost";
    private static final String COLUMN_QTY = "quantity_on_hand";
    private static final String COLUMN_MARKUP = "markup";
    private static final String COLUMN_AVAILABLE = "available";
    private static final String COLUMN_DESC = "description";

    public double getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getMarkup() {
        return markup;
    }

    public void setMarkup(double markup) {
        this.markup = markup;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private static void orm(ResultSet rs,Product p) throws SQLException, ClassNotFoundException {
        p.setId(rs.getInt(COLUMN_ID));
        p.setManufacturer(Manufacturer.findById(rs.getInt(COLUMN_MANU)));
        p.setCode(rs.getString(COLUMN_CODE));
        p.setCost(rs.getDouble(COLUMN_COST));
        p.setQty(rs.getInt(COLUMN_QTY));
        p.setMarkup(rs.getDouble(COLUMN_MARKUP));
        p.setAvailable(rs.getString(COLUMN_AVAILABLE));
        p.setDescription(rs.getString(COLUMN_DESC));
        p.price = p.cost + p.markup;
    }

    public static Product findById(int id) throws SQLException, ClassNotFoundException {
        Product p = null;
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+"=?";
        Connection conn = BuildConnection.getConnection();
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setInt(1,id);
        ResultSet rs = prep.executeQuery();
        if(rs.next())
        {
            p = new Product();
            orm(rs,p);
        }
        return p;
    }

    public static List<Product> findByName(int id) throws SQLException, ClassNotFoundException {
        List<Product> ps = new ArrayList<Product>();
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_DESC+ "LIKE ?";
        Connection conn = BuildConnection.getConnection();
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setString(1, "%" + id + "%");
        ResultSet rs = prep.executeQuery();
        if(rs.next())
        {
            Product p = new Product();
            orm(rs,p);
            ps.add(p);
        }
        return ps;
    }

    public static List<Product> getProductList() throws SQLException, ClassNotFoundException {
        List<Product> ps = new ArrayList<Product>();
        String sql = "SELECT * FROM "+TABLE_NAME;
        Connection conn = BuildConnection.getConnection();
        PreparedStatement prep = conn.prepareStatement(sql);
        ResultSet rs = prep.executeQuery();
        while(rs.next())
        {
            Product p = new Product();
            orm(rs,p);
            ps.add(p);
        }
        return ps;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", manufacturer=" + manufacturer +
                ", code='" + code + '\'' +
                ", cost=" + cost +
                ", qty=" + qty +
                ", markup=" + markup +
                ", available='" + available + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
