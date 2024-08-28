package forms;

import Database.DBconnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Registered extends JDialog {
    private JPanel MainPane;
    private JButton Registered_B;
    private JPanel RegisterPane;
    private JTextField email;
    private JPasswordField password;
    private JPanel TitlePane;
    private JLabel TitleLabel;
    private JTextField username;
    private JLabel usernamelbl;
    private JLabel passwordlbl;
    private JLabel email_l;
    private JTextField Contact;
    private JLabel Contactlbl;

    public Registered(JFrame Frame) {  // Changed to JFrame for the parent frame
        super(Frame, "Register", true);  // Pass the parent frame and set the title
        setContentPane(MainPane);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(Frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        Registered_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String usernameText = username.getText();
                String passwordText = new String(password.getPassword());
                String emailText = email.getText();
                String contactText = Contact.getText();
                registerUser(usernameText,passwordText,emailText,contactText);
            }
        });
    }

    private void registerUser(String usernameText,String passwordText,String emailText ,String contactText ) {
        // Retrieve data from input fields

        // Validate input fields
        if (usernameText.isEmpty() || passwordText.isEmpty() || emailText.isEmpty() || contactText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert data into the database
        try {
            Connection con = DBconnection.getConnection();
            String sql = "INSERT INTO user (username, password, email, contact,role_id) VALUES (?, ?, ?, ?,1)";
            PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, usernameText);
                pstmt.setString(2, passwordText);
                pstmt.setString(3, emailText);
                pstmt.setString(4, contactText);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Registration successful!");
                dispose();  // Close the registration form after successful registration
            MainForm mainForm = new MainForm(null);
            Login login = new Login(mainForm);
            login.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}

