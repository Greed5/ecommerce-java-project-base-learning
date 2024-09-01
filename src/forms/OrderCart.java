package forms;

import Database.DBconnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderCart extends JDialog {
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;
    private JPanel MPanel;
    private JPanel HeadPane;
    private JPanel PaymentPane;
    private JPanel CartPane;
    private JTextField Cnum_f;
    private JTextField Cvv_f;
    private JTextField mail_f;
    private JRadioButton clickHereToComfirmRadioButton;
    private JButton paid_b;
    private JTable CartTable;
    private JRadioButton comfirm_R;

    // Constructor with DefaultTableModel parameter
    public OrderCart(JFrame parent, DefaultTableModel cartTableModel) {
        setContentPane(MPanel);
        setTitle("Order");
        setMinimumSize(new Dimension(1024, 768));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Initialize CartTable with the provided model
        CartTable.setModel(cartTableModel);

        // Add action listeners
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
                Market_Backup markets = new Market_Backup(null);
                markets.setVisible(true);
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

        paid_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handlePayment();
            }
        });
    }

    // Default constructor for OrderCart
    public OrderCart(JFrame parent) {
        this(parent, new DefaultTableModel(new String[]{"Product Name", "Details", "Price"}, 0));
    }

    private void handlePayment() {
        String cardNumber = Cnum_f.getText();
        String cvv = Cvv_f.getText();
        String email = mail_f.getText();

        // Check if the confirmation radio button is selected
        if (!comfirm_R.isSelected()) {
            JOptionPane.showMessageDialog(this, "Payment not yet confirmed.", "Confirmation Required", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Validate card information
        if (validateCardInfo(cardNumber, cvv, email)) {
            JOptionPane.showMessageDialog(this, "Paid successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Clear CartTable
            DefaultTableModel model = (DefaultTableModel) CartTable.getModel();
            model.setRowCount(0); // Clears all rows in the table model
        } else {
            JOptionPane.showMessageDialog(this, "Incorrect card information.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean validateCardInfo(String cardNumber, String cvv, String email) {
        String query = "SELECT COUNT(*) FROM card WHERE card_n = ? AND cvv = ? AND email = ?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, cardNumber);
            stmt.setString(2, cvv);
            stmt.setString(3, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        OrderCart orderCartDialog = new OrderCart(frame);
        orderCartDialog.setVisible(true);
    }
}
