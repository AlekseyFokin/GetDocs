
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Фокин
 */
public class ZipArchiver extends Thread{
    String InputFileName;
    String OutputFileName;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger( GetDocsThread.class);
    
   ZipArchiver (String IFN,String OFN)
   {
       InputFileName=IFN;
       OutputFileName=OFN;
       System.out.println(InputFileName);
       System.out.println(OutputFileName);
       
       
   }
   
   public void  run()
   {
        try
           {
            File f= new File(InputFileName);   
            ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(OutputFileName));
            FileInputStream fis= new FileInputStream(f);
            ZipEntry entry1=new ZipEntry(f.getName());
            zout.putNextEntry(entry1);
            // считываем содержимое файла в массив byte
            byte[] buf = new byte[fis.available()];
            int len;
            while ((len = fis.read(buf)) > 0) {zout.write(buf, 0, len);}
            fis.close();
            zout.closeEntry();
            zout.finish();
            zout.close();
            // закрываем текущую запись для новой записи
        }
        catch(Exception ex){System.out.println(ex.getMessage());} 
        
    } 
   }
    

