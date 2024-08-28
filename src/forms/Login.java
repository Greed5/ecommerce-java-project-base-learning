package forms;
import Cls.Authentication;
import Cls.User;
import Database.DBconnection;
import java.sql.SQLException;
//import forms.MainForm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login extends JDialog {
    private JPanel MainPanel;
    private JLabel LbTitle;
    private JPanel MidPanel;
    private JPanel DownPanel;
    private JButton LoingButton;
    private JButton RegisteredButton;
    private JCheckBox rememberPasswordCheckBox;
    private JPanel HeadPanel;
    private JLabel lblMsg;
    private JPasswordField PasswordInput;
    private JTextField UsernameInput;

    public Login(MainForm Frame){
        super();
        setContentPane(MainPanel);
        setTitle("Login");
        setMinimumSize(new Dimension(600, 400));
        setModal(true);
        setLocationRelativeTo(Frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);



//registered
        RegisteredButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Registered registered = new Registered(null);
                registered.setVisible(true);

            }
        });


//login button
        LoingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = UsernameInput.getText();
                    String password = String.valueOf(PasswordInput.getPassword());
                    Connection con = DBconnection.getConnection();
                    Statement stm = con.createStatement();
                    String query = "Select * from user where username=? and password=?";
                    PreparedStatement preparedStatement = con.prepareStatement(query);
                    preparedStatement.setString(1,username);
                    preparedStatement.setString(2,password);
                    ResultSet rs = preparedStatement.executeQuery();
                    if (rs.next()) {
                        User.setUserName(rs.getString("username"));
                        User.setRoleID(rs.getInt("role_id"));
                        Authentication.setauthenticated(true);
                        dispose();
                        MainForm mainForm = new MainForm(null);
                        mainForm.setVisible(true);
                    }
                    else {
                        Authentication.setauthenticated(false);
                        lblMsg.setText("LoginFailed");
                        lblMsg.setForeground(Color.RED);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
    }}

//    private void setLocationRelativeTo(MainForm frame) {
//    }
//}
