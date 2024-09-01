package forms;

import Database.DBconnection;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Market extends JDialog {

    private JTable Product_Market;
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;
    private JPanel MainPanel;
    private JTextField SearchtextField1;

    public Market(JFrame parent) {
        setContentPane(MainPanel);
        setTitle("Market");
        setMinimumSize(new Dimension(1024, 768));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Initialize the JTable with column names
        String[] columnNames = {"Product Name", "Details", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Product_Market.setModel(tableModel);

        // Center align the content in the JTable cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < Product_Market.getColumnCount(); i++) {
            Product_Market.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Fetch data from the database and populate the JTable
        loadProductData(tableModel);

        // Set up action listeners for buttons
        setupButtonListeners(parent);

        // Refresh the table to ensure data is visible
        tableModel.fireTableDataChanged();
    }

    private void setupButtonListeners(JFrame parent) {
        // ActionListener for the Market button
        marketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the current Market dialog
                Market markets = new Market(parent);  // Open a new Market dialog
                markets.setVisible(true);
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

    private void loadProductData(DefaultTableModel tableModel) {
        // SQL query to fetch data from the product table
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

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Market marketDialog = new Market(frame);
        marketDialog.setVisible(true);
    }
}
