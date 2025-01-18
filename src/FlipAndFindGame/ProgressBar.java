package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;

public class ProgressBar extends JPanel {
    private JProgressBar progressBar;
    private JLabel progressLabel;

    public ProgressBar() {
        setLayout(new BorderLayout());
        progressLabel = new JLabel("Game Progress", JLabel.CENTER);
        progressLabel.setFont(new Font("Arial", Font.BOLD, 14));
        progressLabel.setForeground(Color.BLACK);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(34, 139, 34));
        progressBar.setBackground(Color.LIGHT_GRAY);

        add(progressLabel, BorderLayout.NORTH);
        add(progressBar, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public void updateProgress(int value) {
        progressBar.setValue(value);
    }
}
