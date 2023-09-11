import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class UserInformationWindow extends JFrame  {//หน้าข้อมูล
    Container cp;
    JPanel datapanel;
    JLabel userLa,emailLa,regsdateLa,expiredateLa,statusLa,thisLabel;
    String str;
    JButton Backbutton;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);

    public UserInformationWindow(String str){
        this.str = str;
        Initial();
        setComplement();
        Finally();

    }
    public void Initial(){
        cp = this.getContentPane();
        this.setTitle(str+" Information");
        this.setLayout(new BorderLayout());
    };
        
        
    public void setComplement(){
        datapanel = new JPanel();
        datapanel.setBackground(Color.CYAN);//use for checking space
        datapanel.setBorder(border);

        thisLabel = new JLabel("About "+str);
        thisLabel.setFont(new Font("Arial", Font.BOLD, 30));
        
        int xinput = 250;//use for set position
        int yinput = 80;
        

        
        userLa = new JLabel("Username : ");
        //userLa.setBounds(xinput-40, 10+yinput, 100, 50);
        datapanel.add(userLa);
        
        regsdateLa = new JLabel("Register : ");
        //regsdateLa.setBounds(xinput-40, 30+yinput, 100, 50);
        datapanel.add(regsdateLa);

        expiredateLa = new JLabel("Expire : ");
        //expiredateLa.setBounds(xinput-40, 30+yinput, 100, 50);
        datapanel.add(expiredateLa);
        
        emailLa = new JLabel("Email : ");
        //emailLa.setBounds(xinput-40, 50+yinput, 100, 50);
        datapanel.add(emailLa);

        statusLa = new JLabel("package : ");
        //statusLa.setBounds(xinput-40, 70+yinput, 100, 50);
        datapanel.add(statusLa);

        Backbutton = new JButton("return to menu");
        Backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                AdminFrom adminfrom = new AdminFrom();
                dispose();
            }
        });
        
        this.add(thisLabel,BorderLayout.NORTH);
        this.add(datapanel,BorderLayout.CENTER);
        this.add(Backbutton,BorderLayout.SOUTH);
        
    }
    public void Finally(){
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(800, 0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    

    
}
