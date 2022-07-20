
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Contact {

    private int cid = -1;
    private String title;
    private String fname;
    private String sname;
    private String email;
    private String mobile;
    private int points;
    private double credit;

    public void delete() throws SQLException {
        if (cid == -1) {
            System.out.println("Can't delete this contact has never been saved");
        } else {
            System.out.println("Deleting contact: {}");
            final String sql = "DELETE FROM customer WHERE CustomerID = ?";
            try (Connection connection = DbHelper.getConnection(); PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, cid);
                pstmt.execute();
                cid = -1;
            }catch(SQLException e){
                System.out.println("error:" + e);
            }
        }
    }

    @Override
    public boolean equals (final Object object){
        if (object instanceof Contact){
            final Contact other = (Contact) object;
            return cid !=-1 && cid == other.cid;
        }
        return false;
    }

    public int getCid() {
        return cid;
    }
    public String getTitle() {
        return title;
    }
    public String getFname() {
        return fname;
    }
    public String getSname() {
        return sname;
    }
    public String getEmail() {
        return email;
    }
    public String getMobile() {
        return mobile;
    }
    public int getPoints() {
        return points;
    }
    public double getCredit() {
        return credit;
    }

    @Override
    public int hashCode() {
        return 31 * 1 +(int)(cid ^ cid >>> 32);
    }

    public void save() throws SQLException{

        try (Connection connection = DbHelper.getConnection()) {
            if (cid == -1){
                final String sql = "insert into customer values(DEFAULT,?,?,?,?,?,?,?)";
                try (PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

                    pstmt.setString(1, title);
                    pstmt.setString(2, fname);
                    pstmt.setString(3, sname);
                    pstmt.setString(4, email);
                    pstmt.setString(5, mobile);
                    pstmt.setInt(6, points);
                    pstmt.setDouble(7, credit);
                    pstmt.execute();

                    try (final ResultSet rs = pstmt.getGeneratedKeys()){
                        rs.next();
                        cid = rs.getInt(1);
                    }
                }
            } else {
                final String sql = "UPDATE customer set Title = ?, FirstName = ?, Surname = ?, Email = ?, Mobile = ?, Points = ?, Credit = ? where CustomerID = ? ";
                try (PreparedStatement pstmt = connection.prepareStatement(sql)){


                    pstmt.setString(1, title);
                    pstmt.setString(2, fname);
                    pstmt.setString(3, sname);
                    pstmt.setString(4, email);
                    pstmt.setString(5, mobile);
                    pstmt.setInt(6, points);
                    pstmt.setDouble(7, credit);
                    pstmt.setInt(8, cid);
                    pstmt.execute();
                }catch(SQLException e){
                    System.out.println("Error:" +e);
                }
            }
        }

    }


    public void setCid(final int cid) {
        this.cid = cid;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setFname(final String fname) {
        this.fname = fname;
    }

    public void setSname(final String sname) {
        this.sname = sname;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setMobile(final String mobile) {
        this.mobile = mobile;
    }

    public void setPoints(final int points) {
        this.points = points;
    }

    public void setCredit(final double credit) {
        this.credit = credit;
    }



    @Override
    public String toString() {
        final StringBuilder formatted = new StringBuilder();
        if(cid ==-1){
            formatted.append("[No ID] ");
        }else {
            formatted.append("[").append(cid).append("] ");
        }

        if (title == null){
            formatted.append("no title");
        }else{
            formatted.append(title).append(" | ");
        }

        if (fname == null){
            formatted.append("no first name");
        }else{
            formatted.append(fname).append(" | ");
        }
        if (sname == null){
            formatted.append("no surname");
        }else{
            formatted.append(sname).append(" | ");
        }
        if (email == null){
            formatted.append("no email");
        }else{
            formatted.append(email).append(" | ");
        }
        if (mobile == null){
            formatted.append("no mobile");
        }else{
            formatted.append(mobile).append(" | ");
        }
        if (points == 0){
            formatted.append("no points");
        }else{
            formatted.append(points).append(" | ");
        }
        if (credit == 0){
            formatted.append("no credit");
        }else{
            formatted.append(credit).append(" | ");
        }

        return formatted.toString();
    }


}
