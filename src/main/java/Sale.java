import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Sale {

    private String sku;
    private String pname;
    private float price;
    private String company;


    public String getSKU() {
        return sku;
    }

    public String getPname() {
        return pname;
    }

    public float getPrice(){
        return price;
    }

    public String getCompany(){
        return company;
    }

    public void setSKU(final String sku) {
        this.sku = sku;
    }

    public void setPname(final String pname){
        this.pname=pname;
    }

    public void setPrice(final float price){
        this.price = price;
    }
    public void setCompany(final String company){
        this.company = company;
    }

    public void showProducts(){
        final String sql = "SELECT * FROM product";
        try (Connection connection = DbHelper.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)){

        }catch(SQLException e){
            System.out.println("There was a problem listing the products");
        }
    }
}
