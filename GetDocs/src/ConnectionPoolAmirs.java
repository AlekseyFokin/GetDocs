import org.apache.log4j.Logger;

public class ConnectionPoolAmirs extends org.firebirdsql.pool.FBConnectionPoolDataSource{
    private volatile static ConnectionPoolAmirs uniqPool;
    private static final Logger logger = Logger.getLogger(ConnectionPoolAmirs.class);
    
    public ConnectionPoolAmirs(String ConnectionString) throws Exception   
    {
      setMaxPoolSize(80);
      setMinPoolSize(10);
      setMaxStatements(10);
      setDatabase(ConnectionString);
      setUserName("SYSDBA");
      setPassword("masterkey");
      setCharSet("UTF8");
     // setEncoding("UTF8");
    }
    
           
}

