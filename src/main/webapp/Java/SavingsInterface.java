import java.sql.SQLException;
import java.util.List;

public interface SavingsInterface {
    public void add(SavingsCategory cat) throws ClassNotFoundException, SQLException;
    public SavingsCategory edit(SavingsCategory cat, String custno) throws SQLException, ClassNotFoundException;
    public void delete(String custno) throws SQLException;
    public List<SavingsCategory> display() throws ClassNotFoundException, SQLException;
}
