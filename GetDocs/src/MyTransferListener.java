
import it.sauronsoftware.ftp4j.FTPDataTransferListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Фокин
 */
public class MyTransferListener implements FTPDataTransferListener{
   
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger( GetDocsThread.class);
    public void started() {
		// Transfer started
        logger.error("Ftp-предача начата");
	}

	public void transferred(int length) {
		// Yet other length bytes has been transferred since the last time this
		// method was called
            
	}

	public void completed() {
		// Transfer completed
            logger.error("Ftp-предача завершена");
	}

	public void aborted() {
		logger.error("Ftp-предача отменена");
	}

	public void failed() {
		logger.error("Ftp-предача провалена");
	}
    
}
