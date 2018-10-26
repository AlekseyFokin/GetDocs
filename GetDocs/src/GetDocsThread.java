import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author �����
 */
public class GetDocsThread extends Thread{
    private String pathMagistracyEXE;
    private String VersionAmirs;
    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger( GetDocsThread.class);
    private  int CountToBreak;
    private  int currentCount=0;
    private  int BigTimeout;
    private  int SmallTimeout;
    private String pathMySelf;
    private Process ProcessAmirs=null;
    private int currentReboot=0;
    private String DistrictNo="";
    private  int CountToBreakMax;
    private String pathMagistracyXML;
    private String IPadresFTPServer;
    private int PortFTPServer;
    private String FileName;
    public RMIClient mrmi;
    public GetDocsThread(String pathMagistracyEXE,String VersionAmirs,int CountToBreak,int BigTimeout,int SmallTimeout,String pathMySelf,String DistrictNo,String pathMagistracyXML,String IPadresFTPServer,int PortFTPServer, RMIClient mrmi)
    {
        this.pathMagistracyEXE=pathMagistracyEXE;
        this.VersionAmirs=VersionAmirs;
        this.CountToBreak=CountToBreak;
        this.BigTimeout=BigTimeout;
        this.SmallTimeout=SmallTimeout;
        this.pathMySelf=pathMySelf;
        this.DistrictNo=DistrictNo;
        this.CountToBreakMax= CountToBreak*12;
        this.pathMagistracyXML=pathMagistracyXML;
        this.IPadresFTPServer=IPadresFTPServer;
        this.PortFTPServer=PortFTPServer;
        this.mrmi=mrmi;
    }
   private void RebootProgramm(Process Amirs) //процедура закрытия программы
   {
    Amirs.destroy();
    logger.info("Закрываю все");
    // write to file
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("c:\\GetXMLAmirs\\GetDocs\\RebootDocs.txt"));
            currentReboot++;
            try {fw.write(""+currentReboot);} 
            catch (IOException ex) {logger.error("Нет файла с количеством перезапусков");}
            fw.close();
            } 
        catch (IOException ex) {logger.error("Нет файла с количеством перезапусков");}
        try {  
            Runtime.getRuntime().exec(pathMySelf);
        } catch (IOException ex) {logger.error("Не могу перезапустить Амирс");
        }
     
    System.exit(0);
   }
   
   private String GetSuffix(String filename)
    {
     boolean findFile=false;   
     int i=0;
     String number="";
     do {
         File f=null;
         try {f=new File(pathMagistracyXML+filename+Integer.toString(i)+".xml");System.out.println("поиск файла:"+pathMagistracyXML+filename+Integer.toString(i)+".xml");findFile=f.exists();}
         catch(SecurityException se){findFile=true;}
         finally {if (f!=null) {f=null;}}
         if(findFile) {i++;System.out.println("Нашел файл");}
        }  
     while (findFile);
     number=Integer.toString(i);
     return number;
    }
   
    private void EnterFileName(String string)
   {
   try {
        Robot robot0 = new Robot();
        for (int i=0; i< string.length();i++)
            {
            switch (string.charAt(i))
            {
                case '0':{
                          robot0.keyPress(48);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '1':{
                            robot0.keyPress(49);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '2':{
                            robot0.keyPress(50);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '3':{
                            robot0.keyPress(51);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '4':{  
                          robot0.keyPress(52);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '5':{
                            robot0.keyPress(53);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '6':{
                            robot0.keyPress(54);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '7':{
                            robot0.keyPress(55);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                          }
                case '8':{
                            robot0.keyPress(56);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '9':{
                            robot0.keyPress(57);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'a':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_A);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'b':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_B);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'c':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_C);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'd':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_D);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'e':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_E);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'f':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_F);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'g':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_G);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'j':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_J);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'k':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_K);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'l':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_L);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'm':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_M);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'n':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_N);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'o':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_O);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'p':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_P);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'r':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_R);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'q':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_Q);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 's':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_S);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 't':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_T);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'u':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_U);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'i':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_I);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'w':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_W);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'y':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_Y);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'h':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_H);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'z':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_Z);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'x':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_X);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case 'v':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_V);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case ' ':{
                           robot0.keyPress(java.awt.event.KeyEvent.VK_SPACE);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case '/':{
                           
                           robot0.keyPress(java.awt.event.KeyEvent.VK_BACK_SLASH);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                case ':':{
                           robot0.keyPress(KeyEvent.VK_SHIFT);
                           robot0.keyPress(KeyEvent.VK_SEMICOLON);
                           robot0.keyRelease(KeyEvent.VK_SEMICOLON);
                           robot0.keyRelease(KeyEvent.VK_SHIFT);
                          try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("ввод цифры не удался "+ex);System.exit(0);}
                          break;
                         }
                
            }
            }
        }
   catch (AWTException ex) {logger.error("ввод цифры не удался");System.exit(0);}
   }
   private int GetRebotNum()
   {
    String str = "";
    BufferedReader br;
    try {
         br = new BufferedReader(new FileReader(new File("c:\\GetXMLAmirs\\GetDocs\\RebootDocs.txt")));
         try {str = br.readLine();}
         catch (IOException ex) {logger.error("не открывается файл с количеством перезапусков");}
         } 
    catch (FileNotFoundException ex) {logger.error("Нет файла с количеством перезапусков");}
    return Integer.parseInt(str);
   }
    
    public void run() //Запуск потока обработки
    {
    currentReboot=GetRebotNum();
    if (currentReboot<4) //если программа загрузилась меньше 4 раз, то пусть выполниться еще раз
    {   
        try { ProcessAmirs=new ProcessBuilder(pathMagistracyEXE).start();logger.info("Запустил Амирс");} 
        catch (IOException ex) {logger.error("Не могу запустить Амирс");System.exit(0);}
       //--------------------------------- Амирс запустился
       // поиск окна SplashScreen 
       HWND SplashScreenHWND=null;
       currentCount=0;
       while (SplashScreenHWND==null)
       {
        SplashScreenHWND = User32.INSTANCE.FindWindow(null, "SplashScreen");
        try {sleep(BigTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
        if (currentCount>CountToBreak) {RebootProgramm(ProcessAmirs);}
        currentCount++;
       }
       logger.info("Нашел окно SplashScreen");
       System.out.println("Нашел окно SplashScreen");
       //--поис окна SplashScreen завершен
       //--поиск компонента ввода пороля
       char[] amirsClass = new char[256]; 
       User32.INSTANCE.GetClassName(SplashScreenHWND, amirsClass, 256);
       String amirsClassString=Native.toString(amirsClass).trim();
       String baseClass=amirsClassString.substring(amirsClassString.indexOf("20008")+6,amirsClassString.length());
       final String  amirsClassStringTrue="WindowsForms10.EDIT."+baseClass;
       //System.out.println("���: "+amirsClassStringTrue);
       HWND PassEnter1HWND=null;
       currentCount=0;
       while (PassEnter1HWND==null)
           {
           if (User32.INSTANCE.EnumChildWindows(SplashScreenHWND, new WinUser.WNDENUMPROC() {
                                                                                             @Override
                                                                                             public boolean callback(HWND hWnd, Pointer data) 
                                                                                                   {
                                                                                                    char [] ClassName= new char[256];
                                                                                                    User32.INSTANCE.GetClassName(hWnd, ClassName, 256);
                                                                                                    String className = Native.toString(ClassName);
                                                                                                    if (className.equals(amirsClassStringTrue)) 
                                                                                                    {return false;}
                                                                                                    else {return true;}
                                                                                                   }
                                                                                          }, null)==false) {break;}
            try {sleep(BigTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            if (currentCount>CountToBreak) {RebootProgramm(ProcessAmirs);}
            currentCount++;
           }
        logger.info("Нашел окно PassEnter1HWND");
        System.out.println("Нашел окно ввода пароля");
        //окно ввода пароля найдено
        // процедура ввода пароля
        try {sleep(BigTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
        
        try {
            Robot robot = new Robot();
            //robot.keyPress(KeyEvent.VK_ALT);  
            //robot.keyPress(KeyEvent.VK_SHIFT); 
            //try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Приостановка потока не возможна "+ex);System.exit(0);}
            //robot.keyRelease(KeyEvent.VK_ALT);  
            //robot.keyRelease(KeyEvent.VK_SHIFT); 
            robot.keyPress(65);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot.keyPress(68);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot.keyPress(77);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot.keyPress(73);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot.keyPress(78);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot.keyPress(KeyEvent.VK_ENTER);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            } 
         catch (AWTException ex) {logger.error("Ошибка ввода с клавиатуры");System.exit(0);}
        // Процедурва ввода пароля завершена
        // жду открытия амирса
        HWND AmirsHWND=null;
        currentCount=0;
        while(AmirsHWND==null) 
             {
              try {sleep(BigTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
              AmirsHWND = User32.INSTANCE.FindWindow(null,"АМИРС Версия "+VersionAmirs+"  - Администратор  .  .");
              if(AmirsHWND==null){AmirsHWND = User32.INSTANCE.FindWindow(null,"АМИРС Версия "+VersionAmirs+"  - Администратор"); }
              if (currentCount>CountToBreak) {RebootProgramm(ProcessAmirs);}
              currentCount++;
             }
        mrmi.SendText(Integer.parseInt(DistrictNo), 1);
        logger.info("Нашел окно АМИРС");
        System.out.println("Нашел окно АМИРС");
        int SWP_SHOWWINDOW =0x0040;
        HWND HWND_TOP;
        try {
            HWND_TOP = HWND.class.newInstance();
            User32.INSTANCE.SetWindowPos(AmirsHWND,HWND_TOP, 0, 0, 1024, 738, SWP_SHOWWINDOW);
            }
        catch (InstantiationException ex) {logger.error("Нет возможности сменить разрешение экрана");System.exit(0);} 
        catch (IllegalAccessException ex) {logger.error("Нет возможности сменить разрешение экрана");System.exit(0);}
        
        try {
            Robot robot1 = new Robot();
            robot1.mouseMove(120, 602);
            logger.info("Перевел курсор мыши в точку 120, 602 - Сервис");
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            if (VersionAmirs.contains("1.5.6"))
            {robot1.mouseMove(84, 131);}  else {robot1.mouseMove(103, 116);}
            
            logger.info("Перевел курсор мыши в точку 84, 131 - Обезличивание судебных актов");
            robot1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            robot1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("не могу приостоновить поток "+ex);System.exit(0);}
            } catch (AWTException ex) {logger.error("Ошибка ввода манипулятором");System.exit(0);}
            
        
        //Жду появления окна обезличивания
         currentCount=0;
         HWND WithOutPersonalHWND=null;
        // final String WithOutPersonal="WindowsForms10.MDICLIENT."+baseClass;
         final String WinNameWithOutPersonal="Обезличивание судебных актов";
         while (WithOutPersonalHWND==null)
           {
           if (User32.INSTANCE.EnumChildWindows(AmirsHWND, new WinUser.WNDENUMPROC() {
                                                                                             @Override
                                                                                             public boolean callback(HWND hWnd, Pointer data) 
                                                                                                   {
                                                                                                    char [] ClassName= new char[256];
                                                                                                    User32.INSTANCE.GetClassName(hWnd, ClassName, 256);
                                                                                                    String className = Native.toString(ClassName);
                                                                                                    
                                                                                                    char [] WinName = new char[512];
                                                                                                    User32.INSTANCE.GetWindowText(hWnd, WinName, 512);
                                                                                                    String WinNameS = Native.toString(WinName);
                                                                                                    System.out.println("Сравнение "+WinNameS +" и "+WinNameWithOutPersonal);
                                                                                                    if (WinNameS.equals(WinNameWithOutPersonal)) 
                                                                                                    {return false;}
                                                                                                    else {return true;}
                                                                                                   }
                                                                                          }, null)==false) {break;}
            try {sleep(BigTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            if (currentCount>CountToBreak) {RebootProgramm(ProcessAmirs);}
            currentCount++;
           }
        logger.info("Нашел окно обезличивания");
        System.out.println("Нашел окно обезличивания");
        
        try {
            Robot robot2 = new Robot();
            robot2.mouseMove(418, 81);
 //           robot2.mouseMove(418, 281);
            logger.info("Перевел курсор мыши в точку 418, 81 - Экспортировать XML");
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            robot2.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            robot2.mouseMove(425, 130);
            logger.info("Перевел курсор мыши в точку 425, 130 - Только не выгруженные");
            robot2.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            robot2.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            } catch (AWTException ex) {logger.error("Ошибка ввода манипулятором");System.exit(0);}
      // Жду диалог сохранения файла
        HWND SaveXMLDialogHWND=null;
        currentCount=0;
        while (SaveXMLDialogHWND==null)
        {
         SaveXMLDialogHWND = User32.INSTANCE.FindWindow(null, "Укажите файл для сохранения");
         try {sleep(BigTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
         if (currentCount>CountToBreak) {RebootProgramm(ProcessAmirs);}
         currentCount++;
        }
        logger.info("Нашел окно SaveXMLDialogHWND");
        System.out.println("Нашел окно SaveXMLDialogHWND");
        // ввод имени файла
        // ввод пути - место сохранения
         EnterFileName(pathMagistracyXML);
        //ввод пути - место сохранения - закончен
       EnterFileName(DistrictNo); //ввожу номер участка
        try {//ввожу docs
            Robot robot4 = new Robot();
           // robot4.keyPress(KeyEvent.VK_ALT);  
           // robot4.keyPress(KeyEvent.VK_SHIFT); 
           // robot4.keyRelease(KeyEvent.VK_ALT);  
           // robot4.keyRelease(KeyEvent.VK_SHIFT); 
            robot4.keyPress(68);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            robot4.keyPress(79);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            robot4.keyPress(67);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
            robot4.keyPress(83);
            try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостоновить поток "+ex);System.exit(0);}
           } 
         catch (AWTException ex) {logger.error("Ошибка ввода с клавиатуры");System.exit(0);}
       //Ввожу дату
        String timePattern = "yyyyMMdd";DateFormat dateFormatter =  new SimpleDateFormat(timePattern);   
        long today=System.currentTimeMillis();
        EnterFileName(dateFormatter.format(today));
         try {//ввожу знак_
             Robot robot32 = new Robot();
             robot32.keyPress(KeyEvent.VK_J);
             }
         catch (AWTException ex) {logger.error("Ошибка ввода с клавиатуры");System.exit(0);}
        
        FileName=DistrictNo+"docs"+dateFormatter.format(today)+"j";
        //ввожку ссуффикс
        EnterFileName((GetSuffix(FileName)));
        FileName=FileName+GetSuffix(FileName);
      //  FileName=DistrictNo+"docs"+dateFormatter.format(today);
        try {sleep(SmallTimeout);} catch (InterruptedException ex) {logger.error("Не могу приостановить поток "+ex);System.exit(0);}
        // Enter
       try {//ввожу docs
            Robot robot5 = new Robot(); 
            robot5.keyPress(KeyEvent.VK_ENTER);
           }
       catch (AWTException ex) {logger.error("Ошибка ввода с клавиатуры");System.exit(0);}
       //Жду окончания экспорта
       HWND ExportXMLEndHWND=null;
        currentCount=0;
        while (ExportXMLEndHWND==null)
        {
         ExportXMLEndHWND = User32.INSTANCE.FindWindow(null, "Экспорт завершён");
         try {
              sleep(BigTimeout);
              System.out.println("Жду 2 секунды, currentCount="+currentCount);
              if (currentCount>CountToBreakMax) {RebootProgramm(ProcessAmirs);}
              currentCount++;
             } 
         catch (InterruptedException ex) {logger.error("Не мгу приостановить поток "+ex);System.exit(0);}
         
        }
        logger.info("Нашел окно ExportXMLEndHWND");
        System.out.println("нашел окно ExportXMLEndHWND");
        
         mrmi.SendText(Integer.parseInt(DistrictNo), 2);
        
        logger.info("Можно все закрывать");
        System.out.println("Можно все закрывать");
        ProcessAmirs.destroy();
        
        // Process Process7z;
        //String Execstring="\""+path7Zip+"\" a "+"\""+pathMagistracyXML+FileName+".zip\" "+"\""+pathMagistracyXML+FileName+".xml\"";
        //System.out.println(Execstring);
        //try {
        //     Process7z = new ProcessBuilder(Execstring).start(); 
        //     logger.info("Запустил архивирование");
        //     try {Process7z.waitFor();} catch (InterruptedException ex) {logger.error("Ошибка ожидания архивирования");}
        //     } 
        //catch (IOException ex) {logger.error("не могу запустить архивирование");System.exit(0);}
        ZipArchiver ZA;
        ZA = new ZipArchiver(pathMagistracyXML+FileName+".xml",pathMagistracyXML+FileName+".zip");
        ZA.start();
        logger.info("Архивирую файл");
        try {ZA.join();} catch (InterruptedException ex) {logger.error("Не удалось приостановить поток на архивирования");}
        //Запуск задания  
        //Process ProcessXstarter;
        //String ExecstringX=pathMagistracyXML+pathXStarter;
        //System.out.println(ExecstringX);
        //try {
        //     ProcessXstarter = new ProcessBuilder(ExecstringX).start(); 
        ///     logger.info("Запустил задачу Xstarter");
         //    try {ProcessXstarter.waitFor();} catch (InterruptedException ex) {logger.error("Ошибка ожидания Xstarter");}
         //    } 
        //catch (IOException ex) {logger.error("Не могу запустить Xstarter");System.exit(0);}
        mrmi.SendText(Integer.parseInt(DistrictNo), 3);
        FtpUploader FU;
        try {
            // FU = new FTPUploader2(pathMagistracyXML+FileName+".zip",DistrictNo,IPadresFTPServer,PortFTPServer);FU.start();
            FU = new FtpUploader(pathMagistracyXML+FileName+".zip",DistrictNo,IPadresFTPServer,PortFTPServer);FU.start();
             logger.info("Запуск ftp");
             try {FU.join();} catch (InterruptedException ex) {logger.error("Не могу дождаться окончания Xstarter");}
            } 
        catch (Exception ex) {logger.error("не могу запустить ftp");System.exit(0);}
        mrmi.SendText(Integer.parseInt(DistrictNo), 4);
        logger.error("FTP библиотека отработала. Все отработало!!! скидываю файл перезагрузок в 0");
        
        logger.error("Скидываю количество попыток в 0");
        FileWriter fw = null;
        try {
             fw = new FileWriter(new File("c:\\GetXMLAmirs\\GetDocs\\RebootDocs.txt"));
             try {fw.write(""+0);} 
             catch (IOException ex) {logger.error("Нет файла с количеством перезапусков");}
             fw.close();
            } 
        catch (IOException ex) {logger.error("Нет файла с количеством перезапусков");}
             
     }//Выполнение программы завершилось
    else //Программа выполнелась 3 раза - закончить попытки
    {
      logger.error("Скидываю количество попыток в 0");
      FileWriter fw = null;
      try {
            fw = new FileWriter(new File("c:\\GetXMLAmirs\\GetDocs\\RebootDocs.txt"));
            try {fw.write(""+0);} 
            catch (IOException ex) {logger.error("Нет файла с количеством перезапусков");}
            fw.close();
            } 
      catch (IOException ex) {logger.error("Нет файла с количеством перезапусков");}
      System.exit(0);
    }
        
    }
    
}
