package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;

public class FlipAndFindPanel extends JPanel {
    private CardPanel cardPanel;
    private ProgressBar progressBar;

    public FlipAndFindPanel() {
        setLayout(new BorderLayout());
        progressBar = new ProgressBar();
        cardPanel = new CardPanel(progressBar);
        add(progressBar, BorderLayout.NORTH);
        add(cardPanel, BorderLayout.CENTER);
    }
}
