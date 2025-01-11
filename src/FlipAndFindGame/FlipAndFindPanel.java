package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;

public class FlipAndFindPanel extends JPanel {
    private CardPanel cp;

    public FlipAndFindPanel() {
        setLayout(new BorderLayout());
        cp = new CardPanel();
        add(cp, BorderLayout.CENTER);


    }

}
