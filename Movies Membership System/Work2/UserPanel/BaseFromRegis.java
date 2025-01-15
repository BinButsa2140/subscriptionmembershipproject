package Work2.UserPanel;
import java.awt.Container;
import javax.swing.JFrame;
public class BaseFromRegis extends JFrame{//Frame for RegisterPage
    Container cp;
    public static JFrame mainframe = new JFrame("Register");
    //UserFrom1 regisPanel = new UserFrom1();
    Loginpage login = new Loginpage();//สร้างออปเจคของตัวล็อกอินเพจ
    public BaseFromRegis(){
        initial();
        Finally();
    }
    public void initial(){
        mainframe.setContentPane(login);//ตั้งเปิดหน้าล็อกอินเป็นหน้าแรก
    }
    public void Finally(){
        mainframe.setVisible(true);
        mainframe.setSize(700, 500);
        mainframe.setResizable(false);
        mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
}
