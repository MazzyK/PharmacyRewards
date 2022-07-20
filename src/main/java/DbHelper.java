import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbHelper {

    public static Connection getConnection() throws SQLException {

        return DbHelper.getInstance().getDataSource().getConnection();
    }

    public static DbHelper getInstance() {

        return DbHelper.INSTANCE;
    }

    private static final DbHelper INSTANCE = new DbHelper();

    private BasicDataSource ds;

    private DbHelper() {}

    public void close(){
        if(ds!=null){
            System.out.println("Closing the datasource");
            try {
                ds.close();
            } catch (final SQLException e) {
                System.out.println("Failed to close the database" +e);
            }
        }
    }


    public DataSource getDataSource(){
        return ds;
    }

    public void init(){

        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/pharmareward?serverTimezone=UTC");
        ds.setUsername("prsadm");
        ds.setPassword("Ph@rma");

    }

    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

            @Override
            public void run() {

                close();
            }
        }));
    }

}
