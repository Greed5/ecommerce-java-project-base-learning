package forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Market extends JDialog{
    private JPanel HeadPanel;
    private JPanel ProductPane;
    private JList product_List;
    private JButton marketButton;
    private JButton cartOrderButton;
    private JButton accountButton;
    private JPanel MainPanel;

    public Market(Market Frame) {
        setContentPane(MainPanel);
        setTitle("Market");
        setMinimumSize(new Dimension(1024, 768));
        setModal(true);
        setLocationRelativeTo(Frame);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void createUIComponents() {

    }
}
