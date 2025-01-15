package Work2.Tools;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import Work2.AdminPanel.AdminbaseFrame;
import Work2.AdminPanel.UserInformationForAdmin;

public class ButtonBuilder implements ActionListener{
    Hashtable<String,String> emailDictionary = new Hashtable<>();
    public Hashtable<String,String> stdUser = readFileToCreateDictionary("src/std.csv",0);
    public Hashtable<String,String> preUser = readFileToCreateDictionary("src/pre.csv",0);
    
    Enumeration<String> standardUserKey,premiumUserKey;
    JButton[] buttonArray;
    public void buttonBuilder(JPanel panel,boolean ispremium){//use for create a buttons 
        if(!ispremium){
            int buttonCounter = 0;
            buttonArray = new JButton[stdUser.size()];
            standardUserKey = stdUser.keys();
            while(standardUserKey.hasMoreElements()){
                String key = standardUserKey.nextElement();
                buttonArray[buttonCounter] = new JButton(key);//สร้างปุ่มด้วยชื่อของuser
                panel.add(buttonArray[buttonCounter]);//เพิ่มปุ่มลงพาแนล
                buttonArray[buttonCounter].setContentAreaFilled(false);//ทำให้ปุ่มไม่นูน
                buttonArray[buttonCounter].setActionCommand(key);
                buttonArray[buttonCounter].addActionListener(new ActionListener() {//สร้างตัวListenerให้แก่แต่ละปุ่ม โดยกำหนดเงื่อนไขเข้าไปด้วย
                public void actionPerformed(ActionEvent e) {//pop up user data from button
                    JButton sorce = (JButton) e.getSource();//create sorce to identidy which button was cilcked
                    UserInformationForAdmin userInformation = new UserInformationForAdmin(key);//send username data
                    JFrame frame = AdminbaseFrame.mainAdminFrame;//เลือกเฟรมที่จะเปลี่ยนหน้า เป็นเฟรมของแอดมิน
                    PanelChanger change = new PanelChanger(frame, userInformation);
                        }
                    });//end of actionlistener
                    buttonCounter++;
            }
        }
        else if(ispremium){
            int buttonCounter = 0;
            buttonArray = new JButton[preUser.size()];
            premiumUserKey = preUser.keys();
            while(premiumUserKey.hasMoreElements()){
                String key = premiumUserKey.nextElement();
                buttonArray[buttonCounter] = new JButton(key);
                panel.add(buttonArray[buttonCounter]);
                buttonArray[buttonCounter].setContentAreaFilled(false);//ทำให้ปุ่มไม่นูน
                buttonArray[buttonCounter].setActionCommand(key);
                buttonArray[buttonCounter].addActionListener(new ActionListener() {//สร้างตัวListenerให้แก่แต่ละปุ่ม โดยกำหนดเงื่อนไขเข้าไปด้วย
                public void actionPerformed(ActionEvent e) {//pop up user data from button
                    JButton sorce = (JButton) e.getSource();//create sorce to identidy which button was cilcked
                    UserInformationForAdmin userInformation = new UserInformationForAdmin(key);//send username data
                    JFrame frame = AdminbaseFrame.mainAdminFrame;
                    PanelChanger change = new PanelChanger(frame, userInformation);
                        }
                    });//end of actionlistener
                    buttonCounter++;
                }
        }
        panel.setSize(460, 400);
    }
    public Hashtable readFileToCreateDictionary(String s,int select){
        Hashtable<String,String> dictionaryData = new Hashtable<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(s));
            String stringForLoop;
            int count = 0;
            while((stringForLoop = br.readLine()) != null){
                if(count == 0){ 
                    count++;
                    continue;                
                }
                dictionaryData.put(stringForLoop.split(",")[select],stringForLoop);
                emailDictionary.put(stringForLoop.split(",")[2], stringForLoop);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        finally{
            try {

                br.close();
            } catch (IOException e) {

                System.out.println(e);
            }
            return dictionaryData;
        }
}
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
