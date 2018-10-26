
import MyRMI.RMI;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author �����
 */
public class RMIClient {
public RMI rmi;
private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(RMIClient.class);
public RMIClient(String IP,int Port,String NameService)
{
     try {
            System.out.println("Connecting...");
            rmi = (RMI) Naming.lookup("rmi://"+IP+":"+Port+"/"+NameService);
         } 
    catch (Exception ex) {logger.error("не могу найти службу " + ex.getMessage());System.exit(1);}
}

public void SendText(int DistrictNumber, int Stage){
try {rmi.MoveMessage(DistrictNumber, Stage);} 
catch (Exception ex) {logger.error("не могу отправить: " + ex.getMessage());}
}

    }
