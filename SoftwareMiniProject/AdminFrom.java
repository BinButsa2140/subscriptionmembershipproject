import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;

public class AdminFrom extends JFrame implements ActionListener{//หน้าแอดมิน
    Container cp;
    JTable table;
    JButton testbutton;
    JPanel mainPanel;
    JLabel adminPanelHead;
    String data[][] = {};

    File f = new File("test.csv");
    FileReader fr;
    BufferedReader bf;
    
    JButton buttonwithValue[] = new JButton[LineCounter(f)];
    JScrollPane scrollpanel = new JScrollPane(mainPanel);
    UserInformationWindow userInformation;

    public AdminFrom(){
        Initial();
        setComplement();
        Finally();
    }

    public void Initial(){
        cp = this.getContentPane();
        this.setTitle("Admin UI");
        this.setLayout(new BorderLayout());
    }

    public void setComplement(){
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        adminPanelHead = new JLabel("Admin Panel");
        adminPanelHead.setFont(new Font("Arial", Font.BOLD, 30));
        adminPanelHead.setBounds(10, 10, 200, 30);
        this.add(adminPanelHead,BorderLayout.NORTH);


        System.out.println(LineCounter(f)); //test delete when finish
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.setBorder(border);
        
        try {//create button
            fr = new FileReader(f);
            bf = new BufferedReader(fr);
            String st;
            int count = 0;

            while((st=bf.readLine())!=null){

                String[] userdata = st.split(",");//ตัดสตริงยาวๆ ซอยย่อย
                if(!userdata[0].equalsIgnoreCase("username")){//ถ้าไม่ใช่บรรทัดหัวข้อ
                    buttonwithValue[count] = new JButton(userdata[0]);
                    mainPanel.add(buttonwithValue[count]);
                    buttonwithValue[count].setContentAreaFilled(false);//ทำให้ปุ่มไม่นูน
                    buttonwithValue[count].addActionListener(new ActionListener() {//สร้างตัวListenerให้แก่แต่ละปุ่ม โดยกำหนดเงื่อนไขเข้าไปด้วย
                        
                        public void actionPerformed(ActionEvent e) {//pop up user data from button
                            JButton sorce = (JButton) e.getSource();
                            System.out.println(sorce.getText());//test
                            userInformation = new UserInformationWindow(sorce.getText());//send username data
                            dispose();//close this window

                        }
                    });
                    count++;// rnner use for making
                    
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        mainPanel.setSize(460, 400);
        this.add(mainPanel,BorderLayout.CENTER);

        
    }

    public void Finally(){
        this.setVisible(true);
        this.setSize(500, 500);
        this.setLocation(800, 0);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }



    public int LineCounter(File file){//เอาไว้นับจำนวนแถว
        int n=0;
        try {
            f = new File("test.csv");
            fr = new FileReader(f);
            bf = new BufferedReader(fr);
            String st;
            while((st=bf.readLine())!=null){
                n++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return n;
}


    public void actionPerformed(ActionEvent e) {
        
    }
    
    
}
