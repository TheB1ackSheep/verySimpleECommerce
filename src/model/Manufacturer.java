package model;

import util.BuildConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by INT303 on 13/2/2558.
 */
public class Manufacturer {

    private int id;
    private String name;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String fax;
    private String email;
    private String rep;

    private static final String TABLE_NAME = "manufacturer";
    private static final String COLUMN_ID = "manufacturer_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_ADDR1 = "addressline1";
    private static final String COLUMN_ADDR2 = "addressline2";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_STATE = "state";
    private static final String COLUMN_ZIP = "zip";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_FAX = "fax";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_REP = "rep";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    private static void orm(ResultSet rs,Manufacturer m) throws SQLException {
        m.setId(rs.getInt(COLUMN_ID));
        m.setName(rs.getString(COLUMN_NAME));
        m.setAddressLine1(rs.getString(COLUMN_ADDR1));
        m.setAddressLine2(rs.getString(COLUMN_ADDR2));
        m.setCity(rs.getString(COLUMN_CITY));
        m.setState(rs.getString(COLUMN_STATE));
        m.setZip(rs.getString(COLUMN_ZIP));
        m.setPhone(rs.getString(COLUMN_PHONE));
        m.setFax(rs.getString(COLUMN_FAX));
        m.setEmail(rs.getString(COLUMN_EMAIL));
        m.setRep(rs.getString(COLUMN_REP));
    }

    public static Manufacturer findById(int id) throws SQLException, ClassNotFoundException {
        Manufacturer m = null;
        String sql = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_ID+"=?";
        Connection conn = BuildConnection.getConnection();
        PreparedStatement prep = conn.prepareStatement(sql);
        prep.setInt(1,id);
        ResultSet rs = prep.executeQuery();
        if(rs.next())
        {
            m = new Manufacturer();
            orm(rs,m);
        }
        return m;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", rep='" + rep + '\'' +
                '}';
    }
}
