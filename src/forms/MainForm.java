package forms;

import Cls.RowFilterUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JDialog {
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;
    private JPanel MPanel;
    private JPanel LegPane;
    private JPanel HeadPane;
    private JPanel ProductPane;
    private JPanel SearchPanel;
    private JTextField SearchtextField1;
    private JLabel Blankspace_search;
    private JTable table1;

    public MainForm(JFrame parent) {
        setContentPane(MPanel);
        setTitle("MainForm");
        setMinimumSize(new Dimension(1024, 768));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Initialize table1 with some dummy data (you should replace this with your actual data loading logic)
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Product Name", "Details", "Price"}, 0);
        table1.setModel(tableModel);

        // Apply the row filter to the table
        RowFilterUtil.applyFilter(SearchtextField1, table1);

        // ActionListener for the Market button
        marketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Market markets = new Market(parent);
                markets.setVisible(true);
            }
        });

        // ActionListener for the Cart Order button
        cartOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                OrderCart orderCart = new OrderCart(null);
                orderCart.setVisible(true);
            }
        });

        // ActionListener for the Account button
        accountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                account Account = new account(null);
                Account.setVisible(true);
            }
        });
    }

    // Method to update the table with product data
    public void updateProductTable(DefaultTableModel model) {
        table1.setModel(model);
    }
}
