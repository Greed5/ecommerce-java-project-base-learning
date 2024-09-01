package forms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderCart extends JDialog {
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;
    private JPanel MPanel;
    private JPanel HeadPane;
    private JPanel PaymentPane;
    private JPanel CartPane;
    private JTextField textField1;
    private JTextField CvvtextField2;
    private JTextField textField3;
    private JRadioButton clickHereToComfirmRadioButton;
    private JButton paymentComfirmButton;
    private JTable CartTable;

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
    }

    // Default constructor for OrderCart
    public OrderCart(JFrame parent) {
        this(parent, new DefaultTableModel(new String[]{"Product Name", "Details", "Price"}, 0));
    }
}
