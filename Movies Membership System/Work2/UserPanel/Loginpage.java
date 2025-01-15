package Work2.UserPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import Work2.AdminPanel.AdminbaseFrame;
import Work2.Tools.CheckHave;
import Work2.Tools.Notification;
import Work2.Tools.PanelChanger;


public class Loginpage extends JPanel implements ActionListener{//register page. use for get input 
    JTextArea usernametext,passwordText;
    JLabel userLa,passwordLa,loginContext,backgroundLabel;
    JPanel inputPanel,mainPanel;
    JButton LoginButton, registerButton;
    AdminbaseFrame adfrom = new AdminbaseFrame(false);//เอาไว้ดูหน้าแอดมิน
    ImageIcon background = new ImageIcon("src/colorkit (6).png");//พื้นหลัง
    Container cp;
    JFrame frame = BaseFromRegis.mainframe;//สร้างเพื่อใช้งานเฟรมของตั;ฐาน
    
    public Loginpage(){
        initial();
        setComplement();
        Finally();
    }
    public void initial(){
        this.setLayout(null);
    }
    public void setComplement(){

        Font font = new Font("Arial", Font.PLAIN, 35);
        LineBorder lineborder = new LineBorder(Color.BLACK);
        
        int xinput = 250;//use for set position
        int yinput = 150;
        
        //la = label
        userLa = new JLabel("Username");
        userLa.setBounds(xinput-20, 10+yinput, 100, 50);
        this.add(userLa);
        
        passwordLa = new JLabel("password");
        passwordLa.setBounds(xinput-20, 40+yinput, 100, 50);
        this.add(passwordLa);
        
        registerButton = new JButton("Register here");
        registerButton.setBounds(340,305, 150, 30);
        registerButton.setContentAreaFilled(false);
        registerButton.setBorderPainted(false);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//กดแล้วเปลี่ยนไปหน้าสมัคร
                Registerpanel regis = new Registerpanel();//หน้าพาแนลสมัคร
                PanelChanger change = new PanelChanger(frame, regis);
            }
            
        });
        this.add(registerButton);

        //text = textarea
        usernametext = new JTextArea();
        usernametext.setBounds(xinput+60, 30+yinput, 130, 15);
        usernametext.setBorder(lineborder);
        this.add(usernametext);

        passwordText = new JTextArea();
        passwordText.setBounds(xinput+60, 60+yinput, 130, 15);
        passwordText.setBorder(lineborder);
        this.add(passwordText);

        LoginButton = new JButton("Login");//register button
        LoginButton.addActionListener(this);
        LoginButton.setBounds(xinput+10, 100+yinput, 150, 30);
        LoginButton.setBackground(Color.WHITE);
        this.add(LoginButton);

        loginContext = new JLabel("Login");//register context on top
        loginContext.setFont(font);
        loginContext.setBounds(xinput-30, yinput-40, 200, 50);
        this.add(loginContext);

        inputPanel = new JPanel();//background for input
        inputPanel.setBounds(210, 110, 250, 200);
        inputPanel.setBackground(Color.WHITE);
        this.add(inputPanel);

        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0,700, 500);
        this.add(backgroundLabel);

    }
    
    public void Finally(){
        this.setVisible(true);
        this.setSize(700, 500);
    }
    
    public void actionPerformed(ActionEvent e) {
        Notification noti = new Notification(frame);
        CheckHave check = new CheckHave();
        if(e.getSource() == LoginButton){//Check data for login 
            
            // เช็คกอนว่าข้อมูลช่องนั้นๆว่างไหม 
            // เช็คว่าข้อมูลนั้นๆมีจริงไหม
            // เช็คว่าข้อมูลนั้นเป็นยูเซอร์แบบไหน
            if(!usernametext.getText().trim().isEmpty()&&!passwordText.getText().trim().isEmpty()){//เช็คว่าไม่ว่าง
                //ต้องเพิ่มเงื่อนไขการเช็คข้อมูลก่อน
                if(CheckHave.isHavelogin(usernametext.getText(),passwordText.getText())){//เรียกเช็คข้อมูล ว่าข้อมูลพวกนี้มีจรงไหม
                    //หาว่าเป็นยูเซอร์ประเภทไหน
                    if(check.FindIsPremium(usernametext.getText())==true){
                        PremiumUserUI preUI = new PremiumUserUI(usernametext.getText());//เปิดพาแนลนั้นๆ
                        PanelChanger changer = new PanelChanger(frame,preUI);//เปลี่ยนหน้า
                }
                    else if(check.FindIsPremium(usernametext.getText())==false){
                        StandardUserUI stdUI = new StandardUserUI(usernametext.getText());//เปิดพาแนลนั้นๆ
                        PanelChanger changer = new PanelChanger(frame,stdUI);//เปลี่ยนหน้า
                    }
                }
                else{noti.showNoAccountFoundMessage();}
            }
        else{noti.showInputAllDataMessage();}
        }
        
    }
}


