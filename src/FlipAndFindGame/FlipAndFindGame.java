package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlipAndFindGame extends JFrame {
    private FlipAndFindPanel panel;
    private Login login;
    private CardLayout cardLayout;
    private JPanel containerPanel;

    public FlipAndFindGame() {
        cardLayout = new CardLayout();
        containerPanel = new JPanel(cardLayout);
        login= new Login();
        panel = new FlipAndFindPanel();
        containerPanel.add(login,"LoginPanel");
        containerPanel.add(panel,"GamePanel");
        this.add(containerPanel);
        setTitle("Flip and Find Game");
        setBackground(Color.white);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args) {
        new FlipAndFindGame();
    }


public void showPanel(String panelName) {
    cardLayout.show(containerPanel, panelName);
}
}
