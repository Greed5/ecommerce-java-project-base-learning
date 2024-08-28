package forms;

import javax.swing.*;
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
    private JList Product_list;

    public OrderCart(JFrame parent) {
        setContentPane(MPanel);
        setTitle("Order");
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
            }});

    }
}
