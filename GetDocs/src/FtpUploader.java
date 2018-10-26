
import it.sauronsoftware.ftp4j.FTPAbortedException;
import it.sauronsoftware.ftp4j.FTPClient;
import it.sauronsoftware.ftp4j.FTPDataTransferException;
import it.sauronsoftware.ftp4j.FTPException;
import it.sauronsoftware.ftp4j.FTPIllegalReplyException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Фокин
 */
public class FtpUploader extends Thread{
   
    String OutputFileName;
    String NumDistrict;
     String IP;
    int Port;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger( GetDocsThread.class);
    
    FtpUploader(String OFN, String ND,String IPadresFTPServer, int PortFTPServer)
    {
        OutputFileName=OFN;
        NumDistrict=ND;
        IP=IPadresFTPServer;
        Port=PortFTPServer;
    }
    public void  run()
   {
       FTPClient client = new FTPClient();
        try {
            client.connect(IP, Port);
            client.login("-uch"+NumDistrict+"ftp", "amir$"+NumDistrict);
            client.upload(new java.io.File(OutputFileName), new MyTransferListener());
            client.disconnect(true);
        } catch (IllegalStateException ex) {logger.error("");     }
          catch (IOException ex) {logger.error("Ошибка ввода вывода");} 
          catch (FTPIllegalReplyException ex) {logger.error("Не могу разрешить ftp server"); }
          catch (FTPException ex) {logger.error("ошибка ftp");}
          catch (FTPDataTransferException ex) {logger.error("ошибка передачи файла");}
          catch (FTPAbortedException ex) {logger.error("ftp передача прервана");}
   }
}
