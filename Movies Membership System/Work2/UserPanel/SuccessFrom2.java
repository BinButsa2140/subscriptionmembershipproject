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
import Work2.Tools.PanelChanger;

public class SuccessFrom2 extends JPanel implements ActionListener {//just register success frame
    ImageIcon pic = new ImageIcon("src/colorkit (8).png");
    JLabel picla,successLa;
    JButton goback;
    Font font = new Font("Arial", Font.PLAIN, 35);
    Container cp;
    JFrame frame = BaseFromRegis.mainframe;

    public SuccessFrom2(){
        Finally();
        initial();
        setComplement();
        
    }
    public void initial(){
        
        this.setLayout(null);
    }
    public void setComplement(){
        successLa = new JLabel("Success"); 
        successLa.setFont(font);
        successLa.setBounds(280, 180, 200, 100);
        successLa.setBackground(Color.WHITE);
        this.add(successLa);

        goback = new JButton("Go Back To Register Page");
        goback.setBounds(250, 250, 200, 20);
        goback.setContentAreaFilled(false);
        goback.setBorderPainted(false);
        goback.addActionListener(this);
        this.add(goback);
        
        picla = new JLabel(pic);
        picla.setBounds(0, 0, 700, 500);
        this.add(picla);
    }
    public void Finally(){
        //this.setVisible(true);
        this.setSize(700, 500);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == goback){// ปุ่มกลับไปหน้าล็อกอิน
            Registerpanel userregispage =  new  Registerpanel();
            PanelChanger changer = new PanelChanger(frame, userregispage);
            changer.change();
        }
    }
    
}
