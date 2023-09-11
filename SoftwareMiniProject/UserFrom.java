import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class UserFrom extends JFrame implements ActionListener {//หน้ากรอกข้อมูล
    JTextArea usernametext,emailtext,passwordText;
    JLabel userLa,emailLa,packla,passwordLa;
    JComboBox combo;
    JButton registerButton;
    AdminFrom adfrom = new AdminFrom();
    ImageIcon background = new ImageIcon("poker-backg.jpg");

    public UserFrom(){
        initial();
        setComplement();
        Finally();
    }
    public void initial(){
        Container cp;
        cp = this.getContentPane();
        this.setTitle("UserLoginUI");
        this.setLayout(null);
    }
    public void setComplement(){
        LineBorder lineborder = new LineBorder(Color.BLACK);
        int xinput = 250;//use for set position
        int yinput = 80;
        

        
        userLa = new JLabel("Username");
        userLa.setBounds(xinput-40, 10+yinput, 100, 50);
        this.add(userLa);
        
        passwordLa = new JLabel("password");
        passwordLa.setBounds(xinput-40, 30+yinput, 100, 50);
        this.add(passwordLa);
        
        emailLa = new JLabel("       Email");
        emailLa.setBounds(xinput-40, 50+yinput, 100, 50);
        this.add(emailLa);

        packla = new JLabel("   package");
        packla.setBounds(xinput-40, 70+yinput, 100, 50);
        this.add(packla);

        usernametext = new JTextArea();
        usernametext.setBounds(xinput+60, 30+yinput, 130, 15);
        usernametext.setBorder(lineborder);
        this.add(usernametext);

        passwordText = new JTextArea();
        passwordText.setBounds(xinput+60, 50+yinput, 130, 15);
        passwordText.setBorder(lineborder);
        this.add(passwordText);

        emailtext = new JTextArea();
        emailtext.setBounds(xinput+60, 70+yinput, 130, 15);
        emailtext.setBorder(lineborder);
        this.add(emailtext);

        String comt[] = {"Standard","Prem","Prem+++"};
        combo = new JComboBox<>(comt);
        combo.setBounds(60+xinput, 90+yinput, 100, 20);
        this.add(combo);

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);
        registerButton.setBounds(xinput+60, 120+yinput, 100, 20);
        this.add(registerButton);
        
    }
    public void Finally(){
        this.setVisible(true);
        this.setSize(700, 500);
        this.setResizable(false);
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == registerButton){
            if(usernametext.getText()!=""&&passwordText.getText()!=""&& emailtext.getText()!=""){
            String userdata[] = {usernametext.getText(), passwordText.getText(), emailtext.getText(),(String)combo.getSelectedItem() };
            adfrom.repaint();
            for (String string : userdata) {
                System.out.println(string);
            }}
        }
        
    }
    
}
