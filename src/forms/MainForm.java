package forms;

import javax.swing.*;
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
    private JButton searchButton;
    private JList Product_list;

    public MainForm(JFrame parent) {
            HeadPane.setSize(600,50);
            setContentPane(MPanel);
            setTitle("MainForm");
            setMinimumSize(new Dimension(1024, 768));
            setModal(true);
            setLocationRelativeTo(parent);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        marketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              Market mark = new Market(null);
              mark.setVisible(true);
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
