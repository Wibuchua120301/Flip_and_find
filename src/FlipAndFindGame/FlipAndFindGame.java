package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;

public class FlipAndFindGame extends JFrame {
    private FlipAndFindPanel panel;
    private Login login;


    public FlipAndFindGame() {
        login = new Login();
        this.add(login);
        panel = new FlipAndFindPanel();
        this.add(panel);
        setTitle("Flip and Find Game");
        setBackground(Color.white);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FlipAndFindGame();
    }
}
