import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TabbedPane {
    private JPanel mainPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JButton switchToPanel1Button;
    private JButton switchToPanel2Button;

    public TabbedPane() {
        JFrame frame = new JFrame("Panel Switching Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        mainPanel = new JPanel();
        mainPanel.setLayout(new CardLayout());

        panel1 = new JPanel();
        panel1.add(new JLabel("This is Panel 1"));

        panel2 = new JPanel();
        panel2.add(new JLabel("This is Panel 2"));

        mainPanel.add(panel1, "Panel 1");
        mainPanel.add(panel2, "Panel 2");

        switchToPanel1Button = new JButton("Switch to Panel 1");
        switchToPanel2Button = new JButton("Switch to Panel 2");

        switchToPanel1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Panel 1");
            }
        });

        switchToPanel2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.show(mainPanel, "Panel 2");
            }
        });

        frame.add(switchToPanel1Button, BorderLayout.NORTH);
        frame.add(switchToPanel2Button, BorderLayout.SOUTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TabbedPane();
            }
        });
    }
}
