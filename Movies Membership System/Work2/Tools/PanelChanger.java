package Work2.Tools;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Work2.AdminPanel.UserPremiumHub;
import Work2.AdminPanel.UserStandardHub;

public class PanelChanger {//ใช้เพื่อเปลี่ยนพาแนล
    JPanel  newPanel;
    JFrame frame;
    UserPremiumHub premium = new UserPremiumHub();
    UserStandardHub standard = new UserStandardHub();

    public PanelChanger(JFrame frame,JPanel newPanel){//get frame that u want to change and new panel
        this.frame = frame;
        this.newPanel = newPanel;
        change();
    }
    public PanelChanger(JFrame frame, boolean isPremium){//in case switch premium and standard
        //for admin 
        if(isPremium){
            this.frame = frame;
            this.newPanel = new UserStandardHub();
            change();
        }
        else if(isPremium==false){
            this.frame = frame;
            this.newPanel = new UserPremiumHub();
            change();
        }
    }
    public void change(){//changer 
        frame.setContentPane(newPanel);
        frame.invalidate();
        frame.validate();
    }
    
}
