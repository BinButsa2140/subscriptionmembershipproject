package Work2.AdminPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import Work2.Tools.ButtonBuilder;
import Work2.Tools.PanelChanger;
import Work2.UserPanel.BaseFromRegis;

public class UserInformationForAdmin extends JPanel implements ActionListener{//หน้าข้อมูล แบบพาแนล สำหรับ Admin
    JPanel datapanel,topPanel;
    JLabel userLa,emailLa,regsdateLa,expiredateLa,statusLa,thisLabel,backgroundPanel,userDayRemainLa,giantDayRemain,movieLabel;
    String str;
    JButton Backbutton,deletethisdatabutton;
    ImageIcon pic = new ImageIcon();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    JFrame mainFrame = BaseFromRegis.mainframe;//เฟรมของยูเซอร์
    Font labelFont = new Font("Monospaced", Font.BOLD, 20);
    Font giantFont = new Font("Monospaced", Font.BOLD, 160);

    private String[] infoarr = null;//เอาไว้เก็ยข้อฒูลที่ดึงมาจาก dic
    private ButtonBuilder bu = new ButtonBuilder();
    private LocalDate now;
    private LocalDate ex;
    private long remain;
    private boolean isAdmin,isPremium;

    public static Stack<JPanel> containPanel = new Stack<>();//เอาไว้ใช้เก็บหน้าก่อนกดปุ่มยูสเซอร์ว่าเป็นพรีหรือธรรมดา
    
    public UserInformationForAdmin(String str){
        this.str = str;
        if(this.bu.stdUser.containsKey(str)){//ถ้าสตริงยูเซอร์ตรงกับstd ก็จะ
            this.infoarr = bu.stdUser.get(str).split(",");
            isPremium = false;
        }
        else if(this.bu.preUser.containsKey(str)){//ถ้าสตริงยูเซอร์ตรงกับpre ก็จะ
            this.infoarr = bu.preUser.get(str).split(",");
            isPremium = true;
        }

        this.now = LocalDate.now();
        this.ex = LocalDate.parse(this.infoarr[4]);
        this.remain = ChronoUnit.DAYS.between(now, ex);
        this.isAdmin = isAdmin;
        Initial();
        setComplementDataInformation();
        Finally();
    }

    public void Initial(){
        this.setLayout(new BorderLayout());
    };
        
    public void setComplementDataInformation(){
        //set panel
        topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setPreferredSize(new java.awt.Dimension(400, 50));
        topPanel.setBackground(Color.white);

        thisLabel = new JLabel("About "+str);
        thisLabel.setFont(new Font("Arial", Font.BOLD, 30));
        thisLabel.setBounds(10, 0, 700, 40);

        datapanel = new JPanel();
        datapanel.setBorder(border);
        datapanel.setLayout(null);
        
        int xinput = 50;//use for set position
        int yinput = 0;

        giantDayRemain = new JLabel(remain+"");
        giantDayRemain.setBounds(0, 180+yinput, 300, 200);
        giantDayRemain.setFont(giantFont);
        if(remain<=7){
            giantDayRemain.setForeground(Color.red);
        }
        datapanel.add(giantDayRemain);
        
        userLa = new JLabel("Username : " + infoarr[0]);
        userLa.setHorizontalAlignment(SwingConstants.LEFT);
        userLa.setBounds(xinput-40, yinput, 300, 50);
        userLa.setFont(labelFont);
        datapanel.add(userLa);
        
        regsdateLa = new JLabel("Register : " + infoarr[3]);
        regsdateLa.setHorizontalAlignment(SwingConstants.LEFT);
        regsdateLa.setBounds(xinput-40, 30+yinput, 300, 50);
        regsdateLa.setFont(labelFont);
        datapanel.add(regsdateLa);

        expiredateLa = new JLabel("Expire : " + infoarr[4]);
        expiredateLa.setHorizontalAlignment(SwingConstants.LEFT);
        expiredateLa.setBounds(xinput-40, 60+yinput,300, 50);
        expiredateLa.setFont(labelFont);
        datapanel.add(expiredateLa);
        
        emailLa = new JLabel("Email : " + infoarr[2]);
        emailLa.setHorizontalAlignment(SwingConstants.LEFT);
        emailLa.setBounds(xinput-40, 90+yinput, 300, 50);
        emailLa.setFont(labelFont);
        datapanel.add(emailLa);

        statusLa = new JLabel("package : "+ infoarr[5]);
        statusLa.setHorizontalAlignment(SwingConstants.LEFT);
        statusLa.setBounds(xinput-40, 120+yinput, 300, 50);
        statusLa.setFont(labelFont);
        datapanel.add(statusLa);

        userDayRemainLa = new JLabel("Day remain :" + remain + "Days");
        userDayRemainLa.setHorizontalAlignment(SwingConstants.LEFT);
        userDayRemainLa.setBounds(xinput-40, 150+yinput, 300, 50);
        userDayRemainLa.setFont(labelFont);
        datapanel.add(userDayRemainLa);

        backButton();
        topPanel.add(thisLabel);
        topPanel.add(Backbutton);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(datapanel,BorderLayout.CENTER);

    }
    public void backButton(){// return button Override
        Backbutton = new JButton("return to menu");
        Backbutton.setBounds(400, 0, 180, 40);
        Backbutton.setContentAreaFilled(false);
        Backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //แก้ตรงนี้น่าจได้เปลี่ยนหน้ากลับเป็นหน้าเดิม แต่ยี่ใส่ standard ไ;้ก่อน
                JFrame frame = AdminbaseFrame.mainAdminFrame;//สร้างให้ใช้งานเฟรมจากตั;เก่า เพื่อเปลี่ยน
                PanelChanger change = new PanelChanger(frame,containPanel.peek());
            }
        });
    }

    public void Finally(){
        this.setSize(580, 500);
        this.setLocation(700, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
