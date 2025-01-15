package Work2.UserPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Work2.AdminPanel.AdminbaseFrame;
import Work2.Tools.CheckHave;
import Work2.Tools.Delete;
import Work2.Tools.PanelChanger;

public class ConfirmDelete extends JPanel implements ActionListener {//เป็นพาแนลที่จะขึ้นมาเพื่อขอการยืนยันการลบ
    ImageIcon pic = new ImageIcon("src/colorkit (8).png");
    JLabel la,confirmLa,repeatLa;
    JButton yesButton,noButton;
    Font font = new Font("Arial", Font.PLAIN, 35);
    JFrame frame = BaseFromRegis.mainframe;
    String username;
    File f;
    
    public ConfirmDelete(String username,boolean isPremium){
        this.username = username;
        Finally();
        setFrame(isPremium);
        setComplement();
        
    }
    public void setFrame(boolean isPremium){// เลือกว่าจะต้องกลับไปที่เฟรมไหนหลังจากจบหน้านี้
        if(isPremium){
            this.f = AdminbaseFrame.pre;
        }
        else{
            this.f = AdminbaseFrame.std;
        }
        this.setLayout(null);
    }
    public void setComplement(){
        
        confirmLa = new JLabel("Are you sure?"); 
        confirmLa.setFont(font);
        confirmLa.setBounds(220, 180, 300, 100);
        confirmLa.setBackground(Color.WHITE);
        this.add(confirmLa);

        noButton = new JButton("No");
        noButton.setBackground(Color.red);
        noButton.setBounds(210, 280, 110, 30);
        noButton.addActionListener(this);
        this.add(noButton);

        yesButton = new JButton("Yes");
        yesButton.setBackground(Color.white);
        yesButton.setBounds(330, 280, 110, 30);
        yesButton.addActionListener(this);
        this.add(yesButton);

        repeatLa = new JLabel("Are you sure you want to delete your account?");
        repeatLa.setBounds(190, 250, 300, 20);
        this.add(repeatLa);
        
        
    }
    public void Finally(){
        this.setSize(700, 500);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==noButton){//หากกดไม่ ให้กลับไปหน้าข้อมูลนั้นๆ
                CheckHave check = new CheckHave();
                if(check.FindIsPremium(username)){//โดยเช็คว่าเปฌน user ชนิดไหน จะสงกลับไปเฟรมนั้นๆ
                    PremiumUserUI preui = new PremiumUserUI(username);
                    PanelChanger change = new PanelChanger(frame, preui);
                }
                else{
                    StandardUserUI stdui = new StandardUserUI(username);
                    PanelChanger change = new PanelChanger(frame, stdui);
                    System.out.println("inside i f");
                }
                
        }
        if(e.getSource()==yesButton){//หากใช่ ก็จะส่งข้อมูลไปลบในคลาส delete
            SuccessFrom2 success = new SuccessFrom2();
            PanelChanger changePanel = new PanelChanger(frame, success);
            Delete deleter = new Delete();//สร้าง object จากคลาส delete
            deleter.deleteByValue(username, f, 0);//ส่งข้อมูลให้ลบโดยใช้ข้อมูล ในที่นี้้คือชื่อ
        }
        
    }
    
}
