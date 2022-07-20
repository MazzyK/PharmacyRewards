import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactsHelper {

    public static ContactsHelper getInstance(){
        return ContactsHelper.INSTANCE;
    }

    public static final ContactsHelper INSTANCE = new ContactsHelper();


    public List<Contact> getContacts() throws SQLException{
        final List<Contact> contacts = new ArrayList<>();


        final String sql = "SELECT * FROM customer order by Surname";

        try(Connection connection = DbHelper.getConnection();
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery()){


            while (rs.next()) {
                final Contact contact = new Contact();
                contact.setCid(rs.getInt("CustomerID"));
                contact.setTitle(rs.getString("Title"));
                contact.setFname(rs.getString("FirstName"));
                contact.setSname(rs.getString("Surname"));
                contact.setEmail(rs.getString("Email"));
                contact.setMobile(rs.getString("Mobile"));
                contact.setPoints(rs.getInt("Points"));
                contact.setCredit(rs.getDouble("Credit"));
                contacts.add(contact);
            }

        }
        return contacts;
    }


}
