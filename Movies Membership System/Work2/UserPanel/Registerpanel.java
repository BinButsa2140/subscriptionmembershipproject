package Work2.UserPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import Work2.AdminPanel.AdminbaseFrame;
import Work2.Tools.ButtonBuilder;
import Work2.Tools.CheckHave;
import Work2.Tools.Notification;
import Work2.Tools.PanelChanger;
import Work2.Tools.PreUser;
import Work2.Tools.Select_Status;
import Work2.Tools.StdUser;

public class Registerpanel extends JPanel implements ActionListener{//register page. use for get input 
    JTextArea usernametext,emailtext,passwordText;
    JLabel userLa,emailLa,packla,passwordLa,registerContext,backgroundLabel,successLabel;
    JPanel inputPanel,mainPanel;
    JComboBox combo;
    JButton registerButton,loginPageButton;
    AdminbaseFrame adfrom = new AdminbaseFrame(false);
    ImageIcon background = new ImageIcon("src/colorkit (6).png");//พื้นหลัง
    Container cp;
    JFrame frame = BaseFromRegis.mainframe;//สร้างเพื่อใช้งานเฟรมของตั;ฐาน
    Notification noti = new Notification(frame);//notification error
    
    LocalDate regisday_plus = LocalDate.now().plus(1,ChronoUnit.DAYS);//วันที่สมัคร
    LocalDate stdExpired  = regisday_plus.plus(1,ChronoUnit.MONTHS);//วันที่หมดอายุ
    LocalDate preExpired = regisday_plus.plus(6, ChronoUnit.MONTHS);

    public Registerpanel(){
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
        int yinput = 100;

        loginPageButton = new JButton("login here");
        loginPageButton.setBounds(xinput, yinput, xinput, yinput);
        loginPageButton.setBounds(350,355, 150, 30);
        loginPageButton.setContentAreaFilled(false);
        loginPageButton.setBorderPainted(false);
        loginPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//กลับไปหน้าล็อกอิน
                Loginpage login = new Loginpage();
                PanelChanger change = new PanelChanger(frame, login);
            }
        });
        this.add(loginPageButton);
        
        //la = label
        userLa = new JLabel("Username");
        userLa.setBounds(xinput-20, 10+yinput, 100, 50);
        this.add(userLa);
        
        passwordLa = new JLabel("password");
        passwordLa.setBounds(xinput-20, 40+yinput, 100, 50);
        this.add(passwordLa);
        
        emailLa = new JLabel("       Email");
        emailLa.setBounds(xinput-20, 70+yinput, 100, 50);
        this.add(emailLa);

        packla = new JLabel("   package");
        packla.setBounds(xinput-20, 100+yinput, 100, 50);
        this.add(packla);

        //text = textarea
        usernametext = new JTextArea();
        usernametext.setBounds(xinput+60, 30+yinput, 130, 15);
        usernametext.setBorder(lineborder);
        this.add(usernametext);

        passwordText = new JTextArea();
        passwordText.setBounds(xinput+60, 60+yinput, 130, 15);
        passwordText.setBorder(lineborder);
        this.add(passwordText);

        emailtext = new JTextArea();
        emailtext.setBounds(xinput+60, 90+yinput, 130, 15);
        emailtext.setBorder(lineborder);
        this.add(emailtext);

        String comt[] = {"Standard","Prem"};//Combo for package select
        combo = new JComboBox<>(comt);
        combo.setBounds(60+xinput, 120+yinput, 100, 20);
        combo.setBackground(Color.WHITE);
        this.add(combo);

        registerButton = new JButton("Register");//register button
        registerButton.addActionListener(this);
        registerButton.setBounds(xinput+10, 200+yinput, 150, 30);
        registerButton.setBackground(Color.WHITE);
        this.add(registerButton);

        registerContext = new JLabel("Sign up");//register context on top
        registerContext.setFont(font);
        registerContext.setBounds(xinput-30, yinput-40, 200, 50);
        this.add(registerContext);

        inputPanel = new JPanel();//background for input
        inputPanel.setBounds(210, 60, 250, 300);
        inputPanel.setBackground(Color.WHITE);
        this.add(inputPanel);

        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(0, 0,700, 500);
        this.add(backgroundLabel);

        successLabel = new JLabel("Success");
        successLabel.setBounds(0, 0,700, 500);
        
    }
    
    public void Finally(){
        this.setVisible(true);
        this.setSize(700, 500);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == registerButton){//เมื่อกดล็อกอิน
            
            //เช็คว่าไม่เป็นช่องว่าง
            if(!usernametext.getText().trim().isEmpty() &&
            !passwordText.getText().trim().isEmpty() &&
            !emailtext.getText().trim().isEmpty() &&
            emailtext.getText().contains("@")
            ){
                //แพคข้อมูลเป็นหนึ่ง
                String info = usernametext.getText() + "," + passwordText.getText() + "," + emailtext.getText() + "," + regisday_plus;
                if(CheckHave.ishave(usernametext.getText(),emailtext.getText())){ //เอามาเช็คก่อน ถ้ามีแอคนี้แล้วให้เด้งเตือน
                        noti.showAccountAlreadyInUseMessage();}//โชว์ข้อมูล
                else{//ถ้าไม่มีข้อมูลนั้นอยู่ ก็เขียนได้
                    if(combo.getSelectedItem().equals("Standard")){//ถ้าโดนเลือกมาเป็นแสตนดาร์ด
                        Select_Status user = new Select_Status();//สร้างออปเจคตัวจัดการไฟล์
                        user.setTypeUser(new StdUser());//ส่งไปเลือกไฟล์ว่าจะลงที่ไหน อันนี้ไปลงแสตนดาร์ด
                        user.writeUser("std", info+ ","+ stdExpired + ",standard");
                        ButtonBuilder hash = new ButtonBuilder();//ดึงแฮชแฮชเตรียมใช้

                    }
                    else if(combo.getSelectedItem().equals("Prem")){//ถ้าโดนเลือกมาเป็นพรีเมี่ยม
                        Select_Status user = new Select_Status();//สร้างออปเจคตัวตัวจัดการไฟล์
                        user.setTypeUser(new PreUser());//ส่งไปเลือกไฟล์ว่าจะลงที่ไหน อันนี้ไปลงพรีเมี่ยม
                        user.writeUser("pre", info+ ","+ preExpired +",premium");
                        ButtonBuilder hash = new ButtonBuilder();//ดึงแฮชแฮชเตรียมใช้
                    }

                //รีเฟรชหน้าแอดมิน//////////////////////////////////
                adfrom.dispose();//close admin window
                adfrom = new AdminbaseFrame(false);//open admin window(reflesh)
                ////////////////////////////////
                //เปลี่ยนหน้าไปหน้าสำเร็จ
                SuccessFrom2 success = new SuccessFrom2();//call success window as from
                PanelChanger changer = new PanelChanger(frame, success);
                changer.change();
                
                }
            }
            else{
                noti.showInputAllDataMessage();
            }
        }
    }
}

