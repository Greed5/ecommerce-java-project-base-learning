package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Market extends JDialog {

    private JTable table1;
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;
    private JPanel MainPanel;

    public Market(JFrame parent) {
        setContentPane(MainPanel);
        setTitle("Market");
        setMinimumSize(new Dimension(1024, 768));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
