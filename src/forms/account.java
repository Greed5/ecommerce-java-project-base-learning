package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class account extends JDialog {
    private JPanel legpanel;
    private JPanel headPane;
    private JPanel Mainpane;
    private JButton closeButton;
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;

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
            Market_Backup markets = new Market_Backup(null);
            markets.setVisible(true);
        }
        });
        // ActionListener for the Market button
        marketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the MainForm
                Market markets = new Market(parent);  // Pass the parent frame
                markets.setVisible(true);  // Open the Market dialog
            }
        });

        cartOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OrderCart orderCart = new OrderCart(null);
                orderCart.setVisible(true);
            }
        });
        accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                account Account = new account(null);
                Account.setVisible(true);

            }
        });
    }
}
