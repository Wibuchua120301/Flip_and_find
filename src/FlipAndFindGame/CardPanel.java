package FlipAndFindGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CardPanel extends JButton {
    private int numButtons;
    private String[] pics = {"./img/darkness.jpg", "./img/double.jpg", "./img/fairy.jpg", "./img/fighting.jpg", "./img/fire.jpg", "./img/grass.jpg", "./img/lightning.jpg", "./img/metal.jpg", "./img/psychic.jpg", "./img/water.jpg"};
    //    private String[] cardList = {"darkness", "double", "fairy", "fighting", "fire", "grass", "lightning", "metal", "psychic", "water"};
    private JButton[] buttons;
    private ImageIcon cardBack = new ImageIcon(this.getClass().getResource("./img/back.jpg"));
    private ImageIcon[] icons;
    private ImageIcon temp;
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
        // Tạo mảng icons chứa các đối tượng ImageIcon để lưu trữ các biểu tượng (icon) cho các nút
        icons = new ImageIcon[numButtons];
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(15, 15, 15, 15); // Khoảng cách giữa các nút
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; // Chiếm đều không gian ngang
        gbc.weighty = 1.0; // Chiếm đều không gian dọc

        int[] test = shuffleIcons();
        for (int i = 0, j = 0; i < test.length; i++) {
            // Tạo biểu tượng
            buttons[i] = new JButton(test[i] + "");
            buttons[i].setPreferredSize(new Dimension(10, 10));

            icons[i] = new ImageIcon("./img/darkness.jpg");
            Image scaledImage = icons[j].getImage().getScaledInstance(10, 10, Image.SCALE_SMOOTH);
            icons[i] = new ImageIcon(scaledImage);

            for (int k = 0; k < 20; k++) {
                buttons[j].setIcon(cardBack);
            }
            gbc.gridx = j % 5; // Cột
            gbc.gridy = j / 5; // Hàng
            add(buttons[j], gbc); // Thêm nút với GridBagConstraints
            j++;

        }
    }

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
}




