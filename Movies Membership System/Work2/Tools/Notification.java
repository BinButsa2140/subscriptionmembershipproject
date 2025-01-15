package Work2.Tools;

import javax.swing.*;

public class Notification extends JDialog {//ใช้แจ้งเตือนจร้า

    public Notification(JFrame parent) {
        super(parent, "Custom Dialog", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);
    }
    public void showNoAccountFoundMessage() {
        JOptionPane.showMessageDialog(this, "Invalid Input", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showAccountAlreadyInUseMessage() {
        JOptionPane.showMessageDialog(this, "This account is already in use", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInputAllDataMessage() {
        JOptionPane.showMessageDialog(this, "Input all the data", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
