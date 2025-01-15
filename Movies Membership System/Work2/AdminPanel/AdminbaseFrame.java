package Work2.AdminPanel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class AdminbaseFrame extends JFrame implements ActionListener{//หน้าแอดมิน Frame for admin page

    public static File std = new File("src/std.csv");
    public static File pre = new File("src/pre.csv");
    public static JFrame mainAdminFrame = new JFrame("AdminFrame");
    UserStandardHub standard = new UserStandardHub();
    UserPremiumHub premium = new UserPremiumHub();
    boolean isPremium;
    
    public AdminbaseFrame(boolean ispremium){
        UserInformationForAdmin.containPanel.add(standard);
        this.isPremium = ispremium;
        Initial();
        Finally();
        
    }
    public void Initial(){
        mainAdminFrame.setLayout(new BorderLayout());
        if(isPremium){//check for return
            mainAdminFrame.setContentPane(premium);
        }
        else{
            mainAdminFrame.setContentPane(standard);
        }
    }
    public void Finally(){
        mainAdminFrame.setVisible(true);
        mainAdminFrame.setSize(580, 500);
        mainAdminFrame.setLocation(700, 0);
        mainAdminFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainAdminFrame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}

    public void addContainPanel(JPanel panel) {//ใช้เพื่อเปลี่ยนหน้าไปมาในพาแนลของแอดมิน
        if(UserInformationForAdmin.containPanel.isEmpty()){//เช็คว่าแสต็คไม่ว่าง แสต็คเอาไว้เกบว่าตอนนี้อยู่หน้าไหน
            JPanel temp = new JPanel();
        UserInformationForAdmin.containPanel.add(temp);
        }
        UserInformationForAdmin.containPanel.pop();
        UserInformationForAdmin.containPanel.add(panel);

    }}

