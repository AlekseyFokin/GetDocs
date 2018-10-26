
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.log4j.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author �����
 */
public class GetterDocs {
    public static Properties p;
    public static String DistrictNo;
    public static String VersionAmirs;
    public static String pathMagistracyEXE;
    public static String pathMagistracyDB;
    public static String pathMagistracyXML;
    public static String IPadresFTPServer;
    public static int PortFTPServer;
    public static int CountToBreak;
    public static int BigTimeout;
    public static int SmallTimeout;
    public static String pathMySelf;
    public static String RMIServerIP;
    public static int RMIServerPort;
    public static String RMIServiceName; 
    public static RMIClient MyRMIClient;
    
    private static final Logger logger = Logger.getLogger( GetterDocs.class);
    private static ConnectionPoolAmirs CPA;
   
public static void main (String [] args)
{
  try{
       p = new Properties();
       InputStream IS = GetterDocs.class.getResourceAsStream("prefer.properties");
       p.load(IS);
       pathMagistracyEXE=p.getProperty("pathMagistracyEXE");logger.info("pathMagistracyEXE="+pathMagistracyEXE);
       pathMagistracyDB=p.getProperty("pathMagistracyDB");logger.info("pathMagistracyDB="+pathMagistracyDB);
       pathMagistracyXML=p.getProperty("pathMagistracyXML");logger.info("pathMagistracyXML="+pathMagistracyXML);
       IPadresFTPServer=p.getProperty("IPadresFTPServer");logger.info("IPadresFTPServer="+IPadresFTPServer);
       PortFTPServer=Integer.parseInt(p.getProperty("PortFTPServer")); logger.info("PortFTPServer="+PortFTPServer);
       CountToBreak=Integer.parseInt(p.getProperty("CountToBreak"));logger.info("CountToBreak="+CountToBreak);
       BigTimeout=Integer.parseInt(p.getProperty("BigTimeout"));logger.info("BigTimeout="+BigTimeout);
       SmallTimeout=Integer.parseInt(p.getProperty("SmallTimeout"));logger.info("SmallTimeout="+SmallTimeout);
       pathMySelf=p.getProperty("pathMySelf");logger.info("pathMySelf="+pathMySelf);
       RMIServerIP=p.getProperty("RMIServerIP");logger.info("RMIServerIP="+RMIServerIP);
       RMIServerPort=Integer.parseInt(p.getProperty("RMIServerPort"));logger.info("RMIServerPort="+RMIServerPort);
       RMIServiceName=p.getProperty("RMIServiceName");logger.info("RMIServiceName="+RMIServiceName);
       
       IS.close();   
     }
  catch (Exception e) {logger.error("Свойства не загружены: "+e);System.exit(0);}
  try {
       CPA=new ConnectionPoolAmirs("localhost/3050:"+pathMagistracyDB);
       System.out.println(GetDistrictNo());
       System.out.println(GetVersionAmirs());
       MyRMIClient=new RMIClient(RMIServerIP,RMIServerPort,RMIServiceName);
       
       if (GetDistrictNo().equals("")){logger.error("Нет соединения с базой данных ");System.exit(0);}
       else{
       if (GetDistrictNo().length()<2)    
       {GetDocsThread GDT=new GetDocsThread(pathMagistracyEXE,GetVersionAmirs(),CountToBreak,BigTimeout,SmallTimeout,pathMySelf,"0"+GetDistrictNo(),pathMagistracyXML,IPadresFTPServer,PortFTPServer,MyRMIClient);
       GDT.start();
       }
       else
       {GetDocsThread GDT=new GetDocsThread(pathMagistracyEXE,GetVersionAmirs(),CountToBreak,BigTimeout,SmallTimeout,pathMySelf,GetDistrictNo(),pathMagistracyXML,IPadresFTPServer,PortFTPServer,MyRMIClient);
       GDT.start();
       }
       }
      }
  catch (Exception e) {logger.error("Не могу установить соединение с БД "+e);System.exit(0); }
}
public static String GetDistrictNo(){
    
  RequestString RS1=new RequestString();
  String DistrictNo="";
     try {
          //DistrictNo=RS1.GetRequestString("select \"Name\" as s from \"Agency\"  where  OID=1",CPA);
         DistrictNo=RS1.GetRequestString("select \"Agency\".\"Name\" as s from \"Court\" inner join \"Agency\" on (\"Court\".oid = \"Agency\".oid) where ( \"Court\".\"IsCurrentCourt\"=1)",CPA);
         }
     catch (SQLException ex) {logger.error("Не получен код участка из БД");} 
     
     if ((GetVersionAmirs().equals("1.5.6.5890"))||(GetVersionAmirs().equals("1.6.1.6079")))
         {
          DistrictNo=DistrictNo.toString().substring(DistrictNo.toString().indexOf("№")+1,DistrictNo.toString().indexOf("№")+4);
          DistrictNo=DistrictNo.replace(" ","");
          System.out.println("ННовый - "+DistrictNo);
          logger.error("ННовый - "+DistrictNo);
         }
         else
         {
          DistrictNo=DistrictNo.toString().substring(DistrictNo.toString().indexOf("№")+1,DistrictNo.toString().length());
          DistrictNo=DistrictNo.replace(" ","");
          System.out.println("НСтарый - "+DistrictNo);
          logger.error("НСтарый - "+DistrictNo);
         }
     return DistrictNo;

}
public static String GetVersionAmirs(){
  RequestString RS1=new RequestString();
  String VersionAmirs="";
  try {VersionAmirs=RS1.GetRequestString("select \"Version\" as s from \"Versions\" where OID=1",CPA);}
  catch (SQLException ex) {logger.error("Не получена версия БД");} 
  return VersionAmirs;  
}
    
}
