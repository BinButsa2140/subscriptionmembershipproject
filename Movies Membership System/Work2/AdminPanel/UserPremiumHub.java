package Work2.AdminPanel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import Work2.Tools.ButtonBuilder;
import Work2.Tools.PanelChanger;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class UserPremiumHub extends JPanel implements ActionListener{//หน้าแอดมินของยุเซอร์พรีเมี่ยม
    String f = "pre";
    Container cp;
    JTable table;
    JButton changeButton;
    JLabel adminPanelHead,numberofuserla;
    String data[][] = {};
    JPanel displaypanel,backPanel,leftPanel,buttomPanel;
    FileReader fr;
    BufferedReader bf;
    JFrame mainAdminFrame = AdminbaseFrame.mainAdminFrame;
    boolean isPremium;
    
    public UserPremiumHub(){
        Initial();
        changeButton();
        setComplement();
        Finally();
        
    }
    public void Initial(){
        this.setLayout(new BorderLayout());
    }

    private void changeButton(){
        changeButton = new JButton("View Standard User");
        changeButton.setBounds(400,5,170,30);
        changeButton.setBackground(Color.WHITE);
        changeButton.addActionListener(new ActionListener() {//เปลี่ยนกลุ่มuser
            public void actionPerformed(ActionEvent e){
                PanelChanger change = new PanelChanger(mainAdminFrame,true);
                AdminbaseFrame user = new AdminbaseFrame(false);
                user.addContainPanel(user.standard);
            }
        });

    }
    public void setComplement(){
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);//Border 
        
        this.add(changeButton,BorderLayout.NORTH);
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.GREEN);
        this.add(leftPanel,BorderLayout.WEST);

        //adminLabel
        adminPanelHead = new JLabel("Admin Panel: premium");
        adminPanelHead.setFont(new Font("Arial", Font.BOLD, 30));
        adminPanelHead.setBounds(10, 10, 200, 30);
        this.add(adminPanelHead,BorderLayout.NORTH);

        backPanel = new JPanel();
        backPanel.setLayout(new BoxLayout(backPanel, BoxLayout.Y_AXIS));
        backPanel.setBorder(border);
        
        displaypanel = new JPanel();
        displaypanel.setLayout(new BoxLayout(displaypanel, BoxLayout.Y_AXIS));
        ButtonBuilder buildbutton = new ButtonBuilder();
        buildbutton.buttonBuilder(displaypanel,true);
        displaypanel.setBorder(border);
        
        backPanel.add(displaypanel);
        JScrollPane scrollPane = new JScrollPane(displaypanel);
        this.add(scrollPane,BorderLayout.CENTER);

        int numofpre = new ButtonBuilder().preUser.size();
        buttomPanel = new JPanel();
        numberofuserla = new JLabel("Number of user "+numofpre);
        buttomPanel.add(numberofuserla);
        buttomPanel.setBackground(Color.WHITE);
        this.add(buttomPanel,BorderLayout.SOUTH);
        
    }

    public void Finally(){
        this.setVisible(true);
        this.setSize(580, 500);
        this.setLocation(700, 0);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}