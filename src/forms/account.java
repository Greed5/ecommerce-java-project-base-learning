package forms;

import Database.DBconnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JLabel usernameLabel; // JLabel to display the username

    private int userId; // Variable to hold the user ID

    // Constructor to initialize the account form with user ID
    public account(JFrame parent, int userId) {
        this.userId = userId; // Set the user ID
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
                dispose();  // Close the Account form
                Market markets = new Market(parent);  // Pass the parent frame
                markets.setVisible(true);  // Open the Market dialog
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
                account Account = new account(parent, userId); // Pass the user ID
                Account.setVisible(true);
            }
        });
    }

    // Default constructor for Account
    public account(JFrame parent) {
        this(parent, -1); // Default user ID or handle as needed
    }

    // Method to update the username label
    private void updateUsernameLabel() {
        if (userId <= 0) {
            usernameLabel.setText("Invalid user ID");
            return;
        }

        String query = "SELECT username FROM User WHERE user_id = ?";
        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String username = rs.getString("username");
                    usernameLabel.setText("Username: " + username);
                } else {
                    usernameLabel.setText("Username not found");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            usernameLabel.setText("Error retrieving username");
        }
    }

    public static void main(String[] args) {
        // Example usage (assumes currentUserID is known and passed correctly)
        JFrame frame = new JFrame();
        account acc = new account(frame, 1); // Pass the user ID here
        acc.setVisible(true);
    }
}
