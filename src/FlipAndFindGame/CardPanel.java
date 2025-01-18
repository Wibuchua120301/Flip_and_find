package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;
import javax.swing.Timer;

public class CardPanel extends JButton {
    private Image background;
    private ImageIcon cardBack = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
    private JButton[] buttons;
    private ImageIcon[] icons;
    private ImageIcon icon;
    private int count = 0;
    private JButton[] clickButtons = new JButton[3];
    private int pairsFound = 0;
    private final int totalPairs = 5;
    private ProgressBar progressBar;

    public CardPanel(ProgressBar progressBar) {
        this.progressBar = progressBar;
        buttons = new JButton[10];
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(100, 50, 80, 50));
        background = new ImageIcon("src\\FlipAndFindGame\\img\\Pokemon.jpg").getImage();
        setVisible(true);
        addButtons();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
    }

    public void addButtons() {
        buttons = new JButton[10];
        icons = new ImageIcon[10];
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        int[] test = shuffleIcons();
        for (int i = 0, j = 0; i < test.length; i++) {
            buttons[i] = new JButton(String.valueOf(test[i]));
            buttons[i].addActionListener(flip());
            final int index = i;
            buttons[i].addComponentListener(new ComponentAdapter() {
                public void componentResized(ComponentEvent e) {
                    int width = buttons[index].getWidth();
                    int height = buttons[index].getHeight();
                    ImageIcon cardBack = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
                    Image scaledImage = cardBack.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    icons[index] = new ImageIcon(scaledImage);
                    buttons[index].setFont(new Font("Arial", Font.PLAIN, 0));
                    buttons[index].setIcon(icons[index]);
                }
            });

            gbc.gridx = j % 5;
            gbc.gridy = j / 5;
            add(buttons[j], gbc);
            j++;
        }
    }

    public int[] shuffleIcons() {
        int[] numbers = new int[10];
        for (int i = 0; i < 5; i++) {
            numbers[i * 2] = i + 1;
            numbers[i * 2 + 1] = i + 1;
        }
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int j = rand.nextInt(numbers.length);
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    public ActionListener flip() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                icon = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
                Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                icon = new ImageIcon(scaledImage);
                String click = e.getActionCommand();
                switch (click) {
                    case "1" -> imgBehind("src\\FlipAndFindGame\\img\\darkness.jpg", button);
                    case "2" -> imgBehind("src\\FlipAndFindGame\\img\\dragon.jpg", button);
                    case "3" -> imgBehind("src\\FlipAndFindGame\\img\\metal.jpg", button);
                    case "4" -> imgBehind("src\\FlipAndFindGame\\img\\fairy.jpg", button);
                    case "5" -> imgBehind("src\\FlipAndFindGame\\img\\fighting.jpg", button);
                }
                gamePlay(button);
            }
        };
    }

    public void imgBehind(String s, JButton button) {
        icon = new ImageIcon(s);
        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
        icon = new ImageIcon(scaledImage);
        button.setIcon(icon);
    }

    public void gamePlay(JButton button) {
        icon = new ImageIcon("src\\FlipAndFindGame\\img\\back.jpg");
        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconBack = new ImageIcon(scaledImage);
        clickButtons[count] = button;
        ++count;
        switch (count) {
            case 2 -> {
                if (clickButtons[0].getActionCommand().equals(clickButtons[1].getActionCommand()) && clickButtons[0] != clickButtons[1]) {
                    clickButtons[0].setEnabled(false);
                    clickButtons[1].setEnabled(false);
                    pairsFound++;
                    int progress = (int) ((double) pairsFound / totalPairs * 100);
                    progressBar.updateProgress(progress);
                } else {
                    Timer timer = new Timer(90, e -> {
                        clickButtons[0].setIcon(iconBack);
                        clickButtons[1].setIcon(iconBack);
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
                count = 0;
            }
            case 3 -> {
                count = 0;
                clickButtons[0].setIcon(iconBack);
                clickButtons[1].setIcon(iconBack);
            }
        }
    }
}
