package forms;

import Cls.RowFilterUtil;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import forms.Market;

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
    private JTable TableModel;

    public MainForm(JFrame parent) {
            HeadPane.setSize(600,50);
            setContentPane(MPanel);
            setTitle("MainForm");
            setMinimumSize(new Dimension(1024, 768));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);



        // ActionListener for the Market button
        marketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  // Close the MainForm
                Market markets = new Market(parent);  // Pass the parent frame
                markets.setVisible(true);  // Open the Market dialog
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

}
