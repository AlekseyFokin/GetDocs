
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Фокин
 */
public class RequestString {
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RequestString.class);
         
    public String GetRequestString(String SQL,org.firebirdsql.pool.FBConnectionPoolDataSource Pool) throws SQLException
    {
        Connection connection = null;
        String out="";
        try {
            connection = Pool.getPooledConnection().getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);//��������� SQL ������.
            rs.next();
            out=rs.getString("s");
            } 
      catch (SQLException ex) {logger.error("��� ���������� � ����"+Pool.getDatabase());}
      finally {
               if (connection!=null)
               {connection.close();}
               return out;
              }
    }
    
}
