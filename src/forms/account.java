package forms;

import Database.DBconnection;
import Cls.Authentication;
import Cls.User;
import forms.Login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class account extends JDialog {
    private JPanel legpanel;
    private JPanel headPane;
    private JPanel Mainpane;
    private JButton closeButton;
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;
    private JLabel usernameLabel;
    private int userId;

    // Constructor to initialize the account form with user ID
    public account(JFrame parent, int userId) {
        setContentPane(Mainpane);
        setTitle("Account");
        setMinimumSize(new Dimension(1024, 768));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Initialize the username label
        updateUsernameLabel();

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Market_Backup markets = new Market_Backup(null);
                markets.setVisible(true);
            }
        });

        marketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                Market markets = new Market(parent); 
                markets.setVisible(true);  
            }
        });

        cartOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OrderCart orderCart = new OrderCart(parent);
                orderCart.setVisible(true);
            }
        });

        accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                account Account = new account(parent, userId); 
                Account.setVisible(true);
            }
        });
        usernameLabel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                User user = new User();
                String currentUsername = user.getUsername();
                usernameLabel.setText(currentUsername);
            }
        });
    }
    // Default constructor for Account
    public account(JFrame parent) {
        this(parent, -1); 
    }
    // Method to update the username label
    private void updateUsernameLabel() {
        if (userId <= 0) {
            User user = new User();
            String currentUsername = user.getUsername();
            usernameLabel.setText(currentUsername);
            return;

        }
    }
}
