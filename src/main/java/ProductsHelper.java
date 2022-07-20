
import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductsHelper {


    public static ProductsHelper getInstance(){
        return ProductsHelper.INSTANCE;
    }

    public static final ProductsHelper INSTANCE = new ProductsHelper();


    public List<Product> getProducts() throws SQLException{
        final List<Product> products = new ArrayList<>();


        final String sql = "SELECT * FROM product order by Pname";

        try(Connection connection = DbHelper.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery()){


            while (rs.next()) {
                final Product product = new Product();
                product.setSKU(rs.getString("SKU"));
                product.setPname(rs.getString("Pname"));
                product.setPrice(rs.getFloat("Price"));
                product.setCompany(rs.getString("Company"));
                products.add(product);
            }

        }
        return products;
    }


}
