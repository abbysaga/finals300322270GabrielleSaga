import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService implements SavingsInterface{
    Connection con;

    public DatabaseService(Connection con) { this.con = con; }

    // add method
    @Override
    public void add(SavingsCategory cat) throws ClassNotFoundException, SQLException {

        String quer1 = "INSERT INTO savings VALUES (?,?)";
        PreparedStatement query = con.prepareStatement(quer1);

        query.setString(1, cat.getCustno());
        query.setString(2, cat.getCustname());
        query.setDouble(3, cat.getCdep());
        query.setInt(4, cat.getNyears());
        query.setString(5, cat.getSavtype());

        query.executeUpdate();
    }

    // edit method
    @Override
    public SavingsCategory edit(SavingsCategory cat, String custno) throws SQLException, ClassNotFoundException {
        PreparedStatement query;
        query = con.prepareStatement("Update savings set custno=?, custname=? where catcode = ?");
        query.setString(1, cat.getCustno());
        query.setString(2, cat.getCustname());
        query.setDouble(3, cat.getCdep());
        query.setInt(4, cat.getNyears());
        query.setString(5, cat.getSavtype());

        query.executeUpdate();

        return cat;
    }

    // delete method
    @Override
    public void delete(String custno) throws SQLException {
        String quer1 = "Delete from savings where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);
        query.executeUpdate();
    }

    // search method
    public SavingsCategory search(String custno) throws SQLException, ClassNotFoundException {
        String quer1 = "Select * from savings where custno = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, custno);

        ResultSet rs = query.executeQuery();

        if(!rs.first()) {
            System.out.print("Record not existing");
            return null;
        }

        SavingsCategory obj1 = null;

        obj1 = new SavingsCategory(rs.getString("custno"), rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));

        return obj1;
    }

    // display method
    @Override
    public List<SavingsCategory> display() throws ClassNotFoundException, SQLException {
        // create an array list that will contain the data recovered
        List<SavingsCategory> Custlist = new ArrayList<SavingsCategory>();

        String quer1 = "Select * from savings";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();

        SavingsCategory obj1;

        // display records if there is data;
        while (rs.next()) {
            obj1 = new SavingsCategory(rs.getString("custno"), rs.getString("custname"), rs.getDouble("cdep"), rs.getInt("nyears"), rs.getString("savtype"));
            Custlist.add(obj1);
        }

        return Custlist;
    }

    public List<SavingsCategory> display2(String custno) throws ClassNotFoundException, SQLException {
        // create an array list that will contain the data recovered
        List<SavingsCategory> Itemlist = new ArrayList<SavingsCategory>();

        String quer1 = "Select itemcode, itemdesc from items where catcode=?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, catcode);
        ResultSet rs =  query.executeQuery();

        Items obj2;

        // display records if there is data;

        while (rs.next()) {
            obj2 = new Items(rs.getString("itemcode"), rs.getString("itemdesc"));

            Itemlist.add(obj2);
        }

        return Itemlist;
    }
}
