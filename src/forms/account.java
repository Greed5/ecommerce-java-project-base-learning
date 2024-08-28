package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class account extends JDialog {
    private JLabel logolbl;
    private JPanel legpanel;
    private JPanel headPane;
    private JPanel Mainpane;
    private JButton closeButton;

    public account(JFrame parent) {
            setContentPane(Mainpane);
            setTitle("MainForm");
            setMinimumSize(new Dimension(1024, 768));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        closeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            Market market = new Market(null);
            market.setVisible(true);
        }
        });
    }
}