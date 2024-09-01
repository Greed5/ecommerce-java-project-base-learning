package forms;

import Database.DBconnection;
import Cls.RowFilterUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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

        // Initialize table1 with some dummy data
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Product Name", "Details", "Price"}, 0);
        table1.setModel(tableModel);

        // Load product data from the database
        loadProductData();

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

    // Method to load product data from the database
    private void loadProductData() {
        DefaultTableModel tableModel = (DefaultTableModel) table1.getModel();
        String query = "SELECT product_name, detailed, P_price FROM product";

        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Clear existing rows in the table model
            tableModel.setRowCount(0);

            // Iterate through the ResultSet to add rows to the table model
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(rs.getString("product_name"));
                row.add(rs.getString("detailed"));
                row.add(rs.getDouble("P_price"));
                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update the table with product data
    public void updateProductTable(DefaultTableModel model) {
        table1.setModel(model);
    }
}
