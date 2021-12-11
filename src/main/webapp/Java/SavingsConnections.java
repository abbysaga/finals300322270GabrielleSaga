import org.springframework.stereotype.Service;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SavingsConnections {
    public java.sql.Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/inventory", "root", "");
        return con1;
    }
}
