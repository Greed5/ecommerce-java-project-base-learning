package forms;

import Database.DBconnection;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private JTextField SearchBox;
    private JButton addCartB;

    public Market(JFrame parent) {
        setContentPane(MainPanel);
        setTitle("Market");
        setMinimumSize(new Dimension(1024, 768));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Initialize the JTable with column names
        String[] columnNames = {"Select", "Product Name", "Details", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        Product_Market.setModel(tableModel);

        // Center align the content in the JTable cells
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 1; i < Product_Market.getColumnCount(); i++) {
            Product_Market.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Set custom renderer and editor for the checkbox column
        Product_Market.getColumnModel().getColumn(0).setCellRenderer(new CheckBoxRenderer());
        Product_Market.getColumnModel().getColumn(0).setCellEditor(new CheckBoxEditor());

        // Fetch data from the database and populate the JTable
        loadProductData("");

        // Set up action listeners for buttons
        setupButtonListeners(parent);

        // Add a document listener to the search box
        SearchBox.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterData();
            }
        });
    }

    private void setupButtonListeners(JFrame parent) {
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

        // ActionListener for the Add to Cart button
        addCartB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddToCart();
            }
        });
    }

    private void filterData() {
        String searchText = SearchBox.getText();
        loadProductData(searchText);
    }

    private void handleAddToCart() {
        // Retrieve selected rows
        int rowCount = Product_Market.getRowCount();
        DefaultTableModel tableModel = (DefaultTableModel) Product_Market.getModel();
        DefaultTableModel cartTableModel = new DefaultTableModel(new String[]{"Product Name", "Details", "Price"}, 0);

        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Boolean isSelected = (Boolean) tableModel.getValueAt(rowIndex, 0);
            if (isSelected) {
                Vector<Object> row = new Vector<>();
                row.add(tableModel.getValueAt(rowIndex, 1)); // Product Name
                row.add(tableModel.getValueAt(rowIndex, 2)); // Details
                row.add(tableModel.getValueAt(rowIndex, 3)); // Price
                cartTableModel.addRow(row);
            }
        }

        // Create and display the OrderCart dialog with the cartTableModel
        OrderCart orderCart = new OrderCart(null, cartTableModel);
        orderCart.setVisible(true);

        // Show success message
        JOptionPane.showMessageDialog(this, "Products have been added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void loadProductData(String filter) {
        // SQL query to fetch data from the product table with optional filtering
        String query = "SELECT product_name, detailed, P_price FROM product";

        // Add filtering to the query if there's a filter text
        if (filter != null && !filter.isEmpty()) {
            query += " WHERE product_name LIKE '%" + filter + "%'";
        }

        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // Clear existing rows in the table model
            DefaultTableModel tableModel = (DefaultTableModel) Product_Market.getModel();
            tableModel.setRowCount(0);

            // Iterate through the ResultSet to add rows to the table model
            while (rs.next()) {
                Vector<Object> row = new Vector<>();
                row.add(false); // Checkbox default value
                row.add(rs.getString("product_name"));
                row.add(rs.getString("detailed"));
                row.add(rs.getDouble("P_price"));

                tableModel.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private class CheckBoxRenderer extends JCheckBox implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setSelected(value != null && (Boolean) value);
            return this;
        }
    }

    private class CheckBoxEditor extends DefaultCellEditor {
        public CheckBoxEditor() {
            super(new JCheckBox());
        }

        @Override
        public Object getCellEditorValue() {
            return ((JCheckBox) editorComponent).isSelected();
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            JCheckBox checkBox = (JCheckBox) editorComponent;
            checkBox.setSelected(value != null && (Boolean) value);
            return checkBox;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Market marketDialog = new Market(frame);
        marketDialog.setVisible(true);
    }
}
