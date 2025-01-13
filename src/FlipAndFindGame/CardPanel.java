package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class CardPanel extends JButton {
    private int numButtons;
    private String[] pics = {"/FlipAndFindGame\\img\\darkness.jpg", "/FlipAndFindGame\\img\\dragon.jpg", "/FlipAndFindGame\\img\\fairy.jpg", "/FlipAndFindGame\\img\\fighting.jpg",
            "/FlipAndFindGame\\img\\fire.jpg", "/FlipAndFindGame\\img\\grass.jpg", "/FlipAndFindGame\\img\\lightning.jpg", "/FlipAndFindGame\\img\\metal.jpg", "/FlipAndFindGame\\img\\psychic.jpg", "/FlipAndFindGame\\img\\water.jpg"};
    //    private String[] cardList = {"darkness", "double", "fairy", "fighting",
    //    "fire", "grass", "lightning", "metal", "psychic", "water"};
    private JButton[] buttons;
    private ImageIcon cardBack = new ImageIcon(this.getClass().getResource("/FlipAndFindGame\\img\\back.jpg"));
    private ImageIcon[] icons;
    private ImageIcon temp;
    private ImageIcon icon;
    int columns = 5;
    int rows = 4;
    private static int score = 0;
    private boolean gameOver;
    Timer myTimer;
    int openImages;
    public int currentIndex;
    public int oddClickIndex;
    public int numClicks;

    public CardPanel() {
        buttons = new JButton[20];
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createEmptyBorder(100, 50, 80, 50));
        setBackground(Color.white);
        setVisible(true);
        addButtons();

    }

    // Phương thức thêm Buttons vào CardPanel
    public void addButtons() {
        numButtons = pics.length * 2;
        buttons = new JButton[numButtons];
        icons = new ImageIcon[numButtons];
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các nút
        gbc.fill = GridBagConstraints.BOTH;


        int[] test = shuffleIcons();
        for (int i = 0, j = 0; i < test.length; i++) {
            // Tạo biểu tượng
            buttons[i]= new JButton();
            buttons[i].setActionCommand(String.valueOf(test[i]));
            buttons[i].setPreferredSize(new Dimension(100, 138));

            buttons[i].addActionListener(flip());

            // Set mặt lưng cho các nút
            ImageIcon originalIcon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\back.jpg"));

            Image scaledImage = originalIcon.getImage().getScaledInstance(100, 138, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(scaledImage);

            // Set mặt lưng cho các nút
            buttons[i].setIcon(icons[i]);

            // Chỉnh vị trí cho các nút
            gbc.gridx = j % 5; // Cột
            gbc.gridy = j / 5; // Hàng
            add(buttons[j], gbc); // Thêm nút với GridBagConstraints
            j++;

        }

    }

    // Trộn các nút ngẫu nhiên
    public int[] shuffleIcons() {
        int[] numbers = new int[20];
        for (int i = 0; i < 10; i++) {
            numbers[i * 2] = i + 1;
            numbers[i * 2 + 1] = i + 1;
        }
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            int j = rand.nextInt(numbers.length); // Chọn chỉ số ngẫu nhiên
            // Hoán đổi phần tử tại vị trí i và j
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
                JButton button = (JButton) e.getSource(); // Lấy nút đã nhấn
                String click = e.getActionCommand();
                switch (click) {
                    case "1" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\double.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "2" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\darkness.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "3" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\fairy.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "4" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\fighting.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "5" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\fire.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "6" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\lightning.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "7" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\metal.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "8" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\psychic.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "9" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\grass.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                    case "10" -> {
                        icon = new ImageIcon(getClass().getResource("/FlipAndFindGame\\img\\water.jpg"));
                        Image scaledImage = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
                        icon = new ImageIcon(scaledImage);
                        button.setText("");
                        button.setIcon(icon);
                        break;
                    }
                }
            }
        };
    }
}




