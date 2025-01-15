package Work2.UserPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import Work2.InterfaceClass.UserUIInterface;
import Work2.Tools.ButtonBuilder;
import Work2.Tools.PanelChanger;

public class PremiumUserUI extends JPanel implements UserUIInterface{//หน้าข้อมูล แบบพาแนล สำหรับ User
    JPanel datapanel,topPanel;
    JLabel userLa,emailLa,regsdateLa,expiredateLa,statusLa,thisLabel,backgroundPanel,userDayRemainLa,giantDayRemain,movieLabel;
    String str;
    JButton Backbutton,deletethisdatabutton;
    ImageIcon pic = new ImageIcon();
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    JFrame mainFrame = BaseFromRegis.mainframe;//เฟรมของยูเซอร์
    Font labelFont = new Font("Monospaced", Font.BOLD, 20);
    Font giantFont = new Font("Monospaced", Font.BOLD, 180);
    
    private String[] infoarr = null;//เอาไว้เก็ยข้อฒูลที่ดึงมาจาก dic
    private ButtonBuilder buttonbuilder = new ButtonBuilder();
    private LocalDate now;
    private LocalDate ex;
    private long remain;
    private boolean isAdmin,isPremium;

    public static Stack<JPanel> containPanel = new Stack<>();//เอาไว้ใช้เก็บหน้าก่อนกดปุ่มยูสเซอร์ว่าเป็นพรีหรือธรรมดา
    
    public PremiumUserUI(String str){
        this.str = str;
        this.infoarr = buttonbuilder.preUser.get(str).split(",");
        System.out.println("here word");
        isPremium = true;

        this.now = LocalDate.now();
        this.ex = LocalDate.parse(this.infoarr[4]);
        this.remain = ChronoUnit.DAYS.between(now, ex);

        Initial();
        setComplementDataInformation();
        Finally();
    }
    public void Initial(){
        this.setLayout(new BorderLayout());
    };
        
    public void setComplementDataInformation(){//Override
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
        giantDayRemain.setBounds(0, 180+yinput, 350, 200);
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

        FreeMoviePanel();
        PremiumMoviePanel();
        deleteDataButton();
        backButton();
        topPanel.add(thisLabel);
        topPanel.add(Backbutton);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(datapanel,BorderLayout.CENTER);

    }
    public void backButton(){//สร้างปุ่มกลับ เป็นการ overide method จาก interface class
        Backbutton = new JButton("Logout");
        Backbutton.setBounds(500, 0, 180, 40);
        Backbutton.setContentAreaFilled(false);
        Backbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //แก้ตรงนี้น่าจได้เปลี่ยนหน้ากลับเป็นหน้าเดิม แต่ยี่ใส่ standard ไ;้ก่อน
                JFrame frame = BaseFromRegis.mainframe;//สร้างให้ใช้งานเฟรมจากตั;เก่า เพื่อเปลี่ยน
                Loginpage login = new Loginpage();
                PanelChanger change = new PanelChanger(frame, login);
            }
        });
        topPanel.add(Backbutton);
    }
    

    public void FreeMoviePanel(){//เพิ่มหน้าต่างหนังสำหรับฟรี Override
            JPanel backpane = new JPanel();
            JPanel moviePanel = new JPanel();
            JScrollPane scroll = new JScrollPane(moviePanel);
            
            moviePanel.setLayout(new FlowLayout());
            moviePanel.setBounds(350, 10, 305, 180);
            moviePanel.setBackground(Color.DARK_GRAY);

            backpane.setLayout(new BorderLayout());
            backpane.setBounds(350, 10, 305, 180);
            backpane.add(scroll,BorderLayout.CENTER);

            datapanel.add(backpane);

            movieLabel = new JLabel("Free Movies");
            movieLabel.setBounds(400, 0, 100, 40);
            movieLabel.setFont(labelFont);
            backpane.add(movieLabel,BorderLayout.NORTH);

            ImageIcon standardMovie = new ImageIcon("src/standardmovie.png");

            JButton[] standardLaPic = new JButton[5];

            for(int i=0; i<5;i++){//for everyone
                standardLaPic[i] = new JButton(standardMovie);
                standardLaPic[i].setPreferredSize(new Dimension(100, 140));
                moviePanel.add(standardLaPic[i]);
            }
    }


    private void PremiumMoviePanel(){//เพิ่มหน้าต่างหนังสำหรับพรีเมี่ยม Method ใหม่
            JPanel backpanePre = new JPanel();
            JPanel moviePanelPre = new JPanel();
            JScrollPane scrollPre = new JScrollPane(moviePanelPre);
            
            moviePanelPre.setLayout(new FlowLayout());
            moviePanelPre.setBounds(350, 190, 305, 180);
            moviePanelPre.setBackground(Color.DARK_GRAY);

            backpanePre.setLayout(new BorderLayout());
            backpanePre.setBounds(350, 190, 305, 190);
            backpanePre.add(scrollPre,BorderLayout.CENTER);

            datapanel.add(backpanePre);

            movieLabel = new JLabel("Premium Movies");
            movieLabel.setBounds(400, 170, 100, 40);
            movieLabel.setFont(labelFont);
            backpanePre.add(movieLabel,BorderLayout.NORTH);

            ImageIcon premiumMovie = new ImageIcon("src/premiummovie.png");
            JButton[] premiumbuttons = new JButton[10];

            if(isPremium){//only premium
                for(int i = 0 ; i<10 ; i++){
                premiumbuttons[i] = new JButton(premiumMovie);
                premiumbuttons[i].setPreferredSize(new Dimension(100, 140));
                moviePanelPre.add(premiumbuttons[i]);
                }
            }
    }

    public void deleteDataButton(){//Override
        if(!isAdmin){
            deletethisdatabutton = new JButton("Delete this account");
            deletethisdatabutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConfirmDelete confirm = new ConfirmDelete(str,isPremium);
                PanelChanger change = new PanelChanger(mainFrame, confirm);
                //บ้ายลบไปไว้ในคอนเฟิร์ม
            }
        });
        this.add(deletethisdatabutton,BorderLayout.SOUTH);
        }
    }

    public void Finally(){
        this.setSize(580, 500);
        this.setLocation(700, 0);
    }

}
